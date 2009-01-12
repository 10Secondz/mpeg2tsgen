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
	private long bnadwidth_bps;
	private static final int DEFAULT_SCHEDULE_TIME_GRANULARITY_MILLISEC = 100;
	private TreeMap<Long,Integer> schedule_tree = new TreeMap<Long,Integer>();
	private long schedule_time_granularity_ms = DEFAULT_SCHEDULE_TIME_GRANULARITY_MILLISEC;
	private long current_time_ms = 0;
	private long end_tims_ms = 0;
	private long next_timeout_ms = 0;
	private OutputStream output_pipe;

	private volatile boolean threadSuspended = false;
	private volatile Thread runningThread = null;

	private byte[] null_packet_bytes;

	public TransportStreamProducer(long running_time_ms, long schedule_time_granularity_ms, OutputStream os) {
		end_tims_ms = running_time_ms;
		this.schedule_time_granularity_ms = schedule_time_granularity_ms;
		output_pipe = os;
		null_packet_bytes = TransportPacketFactory.createMPEGNullPacket().toByteArray();
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
		while (thisThread == runningThread && current_time_ms < end_tims_ms ) {
			synchronized(this) {
				while(threadSuspended && runningThread == thisThread) {
					try { wait();} catch (InterruptedException e){}
				}
			}

			current_time_ms += schedule_time_granularity_ms;

			if (schedule_tree.size() > 0 && current_time_ms > next_timeout_ms) {
				Integer val = schedule_tree.pollFirstEntry().getValue();
				SITable table = SITableRepository.getTable(val.intValue());
				if (table != null) {
					if (current_time_ms < table.getEndTime()) {
						writeTable(table);
						addSchedule(table); // insert table again
					}
					updateNextTimeout();
				}
			}else {
				doIdleWork();
			}
		}
	}

	private void updateNextTimeout() {
		if (!schedule_tree.isEmpty())
			next_timeout_ms = schedule_tree.firstKey().longValue();
	}

	private void doIdleWork() {
		// TODO: how many NullPacket should be sent during idle time?
		writeNullPacket(20);
	}

	private void writeNullPacket(int ntimes) {
		try {
			for (int n=0; n < ntimes; n++)
				output_pipe.write(null_packet_bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeTable(SITable table) {
		if ( table.getTableID() != TableID.PROGRAM_ASSOCIATION_TABLE )
			System.out.println("Writing.. :" + table.getTableID().toString()+" "+table.getUniqueID());
		Section[] sections = table.toSection();
		for(int s=0; s < sections.length; s++) {
			TransportPacket[] packets = TransportPacketGenerator.generatePackets(sections[s]);
			for(int p=0; p < packets.length; p++) {
				byte[] data_bytes = packets[p].toByteArray();
				try {
					output_pipe.write(data_bytes);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
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
