/**
 * 
 */
package API;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


/**
 * 
 * TODO:
 *  - bandwidth
 *  - continuity field
 *  - PCR_PID
 * 
 * @author SungHun Park (dr.superchamp@gmail.com)
 *
 */
public class TransportStreamProducer implements Runnable {
	private String name;
	private long bitrate_per_sec;
	private static final int DEFAULT_SCHEDULE_TIME_GRANULARITY_MILLISEC = 100;
	private TreeMap<Long,Integer> schedule_tree = new TreeMap<Long,Integer>();
	private long schedule_time_granularity_ms = DEFAULT_SCHEDULE_TIME_GRANULARITY_MILLISEC;
	private long current_time_ms = 0;
	private long end_time_ms = 0;
	private long next_timeout_ms = 0;
	private int num_of_null_packets_for_idle;
	private OutputStream output_pipe;
	private TreeMap<Integer,Integer> continuity_counter_server = new TreeMap<Integer,Integer>();
	
	private volatile boolean threadSuspended = false;
	private volatile Thread runningThread = null;

	private byte[] null_packet_bytes;

	public TransportStreamProducer(String name, long bitrate_per_sec,
			long running_time_ms, long schedule_time_granularity_ms, OutputStream os) {
		this.name = new String(name);
		num_of_null_packets_for_idle = (int)((bitrate_per_sec * schedule_time_granularity_ms)/(188*1000*8));
		this.bitrate_per_sec = (188*1000*8*num_of_null_packets_for_idle) / schedule_time_granularity_ms;
		end_time_ms = running_time_ms;
		this.schedule_time_granularity_ms = schedule_time_granularity_ms;
		output_pipe = os;
		null_packet_bytes = TransportPacketFactory.createMPEGNullPacket().toByteArray();
	}

	public String getName() {
		return name;
	}

	public long getBitrate() {
		return bitrate_per_sec;
	}
	
	public int getNumPktsForSchedule() {
		return num_of_null_packets_for_idle;
	}
	
	public synchronized boolean addSchedule(SITable table) {
		if (schedule_tree.containsValue(new Integer(table.getUniqueID()))) {
			return false;
		}

		long schedule_key = table.getIntervalMillis()+table.getStartTime();
		while (schedule_tree.containsKey(new Long(schedule_key)))
			schedule_key += schedule_time_granularity_ms;
		schedule_tree.put(new Long(schedule_key), new Integer(table.getUniqueID()));
		
		updateNextTimeout();
		return true;
	}
	
	private synchronized boolean addScheduleRuntime(SITable table) {
		if (schedule_tree.containsValue(new Integer(table.getUniqueID()))) {
			return false;
		}

		long schedule_key = table.getIntervalMillis()+current_time_ms;
		while (schedule_tree.containsKey(new Long(schedule_key)))
			schedule_key += schedule_time_granularity_ms;
		schedule_tree.put(new Long(schedule_key), new Integer(table.getUniqueID()));
		
		updateNextTimeout();
		return true;
	}

	public synchronized boolean removeSchedule(SITable table) {
		int table_unique_id = table.getUniqueID();
		Iterator<Map.Entry<Long,Integer>> it = schedule_tree.entrySet().iterator();
		while(it.hasNext()) { // O(n) in the worst case.
			Map.Entry<Long,Integer> entry = it.next();
			if (entry.getValue().intValue() == table_unique_id) {
				schedule_tree.remove(entry.getKey());
				return true;
			}
		}

		return false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		Thread thisThread = Thread.currentThread();
		while (thisThread == runningThread && current_time_ms < end_time_ms ) {
			synchronized(this) {
				while(threadSuspended && runningThread == thisThread) {
					try { wait();} catch (InterruptedException e){}
				}
			}

			if ( (current_time_ms/1000) != ((current_time_ms+schedule_time_granularity_ms)/1000))
				System.out.println((current_time_ms/1000+1) + " sec..");
			current_time_ms += schedule_time_granularity_ms;

			if (schedule_tree.size() > 0 && current_time_ms > next_timeout_ms) {
				int written_packets = 0;
				while(schedule_tree.size() > 0 && current_time_ms > next_timeout_ms) {
					Integer val = schedule_tree.pollFirstEntry().getValue();
					SITable table = SITableRepository.getTable(val.intValue());
					if (table != null) {
						if (current_time_ms < table.getEndTime()) {
							written_packets += writeTable(table);
							addScheduleRuntime(table); // update schedule position
						}
						updateNextTimeout();
					}
				}
				writeNullPacket(num_of_null_packets_for_idle-written_packets);
			}else {
				doIdleWork();
			}
/*
			if (schedule_tree.size() > 0 && current_time_ms > next_timeout_ms) {
				Integer val = schedule_tree.pollFirstEntry().getValue();
				SITable table = SITableRepository.getTable(val.intValue());
				if (table != null) {
					if (current_time_ms < table.getEndTime()) {
						writeTable(table);
						addScheduleRuntime(table); // insert table again
					}else {
						writeNullPacket(num_of_null_packets_for_idle);
					}
					updateNextTimeout();
				}
			}else {
				doIdleWork();
			}
*/
		}
		System.out.println("TS generation is done.");
	}

	private void updateNextTimeout() {
		if (!schedule_tree.isEmpty())
			next_timeout_ms = schedule_tree.firstKey().longValue();
	}

	private void doIdleWork() {
		writeNullPacket(num_of_null_packets_for_idle);
	}

	private void writeNullPacket(int ntimes) {
		try {
			for (int n=0; n < ntimes; n++)
				output_pipe.write(null_packet_bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int writeTable(SITable table) {
		int written_packets = 0;
		Section[] sections = table.toSection();
		//System.out.println("Writing: "+table.getTableID());
		for(int s=0; s < sections.length; s++) {
			TransportPacket[] packets = TransportPacketGenerator.generatePackets(sections[s]);
			for(int p=0; p < packets.length; p++) {
				updateContinuityCounter(packets[p]);
				byte[] data_bytes = packets[p].toByteArray();
				try {
					output_pipe.write(data_bytes);
					written_packets++;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return written_packets;
	}
	
	private int updateContinuityCounter(TransportPacket packet) {
		if (packet.getPID() == 0x1FFF) // null packet
			return 0;
		boolean needIncrement = true;
		if (packet.getAdaptationFieldControl() == 0x0 ||
			packet.getAdaptationFieldControl() == 0x2 )
			needIncrement = false;

		Integer key = new Integer(packet.getPID());
		if ( continuity_counter_server.containsKey(key) ) {
			Integer val = continuity_counter_server.get(key).intValue();
			if (needIncrement) val = (val+1) % 16;
			continuity_counter_server.put(key, val);
			packet.setContinuityCounter(val.intValue());
		}
		else {
			continuity_counter_server.put(key, new Integer(0));
			packet.setContinuityCounter(0);
		}
		return 0;
	}

	public synchronized void start() {
		if (runningThread != null)
			return;

		threadSuspended = false;
		runningThread = new Thread(this);
		runningThread.start();
	}

	public synchronized void stop() {
		runningThread = null;
    }

	public synchronized void pause() {
		if (threadSuspended)
			return;
		threadSuspended = true;
	}

	public synchronized void resume() {
		if (threadSuspended == true)
			return;
		
		threadSuspended = true;
		notify();
	}
	
	public void debugDump() {
		Iterator<Map.Entry<Long,Integer>> it = schedule_tree.entrySet().iterator();
		System.out.println("CurrentTime: "+current_time_ms);
		while(it.hasNext()) {
			Map.Entry<Long,Integer> entry = it.next();
			SITable table = SITableRepository.getTable(entry.getValue().intValue());
			if (table == null)
				System.out.println("timeout: "+entry.getKey()+", but deleted in repository.");
			else
				System.out.println("timeout: "+entry.getKey()+", "+table.getTableID()+" "+table.getUniqueID());
		}
		System.out.println();
	}
}
