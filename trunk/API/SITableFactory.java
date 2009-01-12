package API;

import Core.CVCTChannelDefaultImpl;
import Core.CVCTDefaultImpl;
import Core.EITDefaultImpl;
import Core.EITEventDefaultImpl;
import Core.ETTDefaultImpl;
import Core.MGTDefaultImpl;
import Core.MGTTableDefaultImpl;
import Core.PATDefaultImpl;
import Core.PATProgramDefaultImpl;
import Core.PMTStreamDefaultImpl;
import Core.RRTDefaultImpl;
import Core.RRTDimensionDefaultImpl;
import Core.RRTDimensionValueDefaultImpl;
import Core.STTDefaultImpl;
import Core.TVCTChannelDefaultImpl;
import Core.TVCTDefaultImpl;
/**
 * 
 */
import Core.PMTDefaultImpl;

/**
 * @author SungHun Park (dr.superchamp@gmail.com)
 *
 */
public class SITableFactory {
	public static PAT createPAT(int table_version, int transport_stream_id) {
		return new PATDefaultImpl(table_version, transport_stream_id);
	}

	public static PATProgram createPATProgram(int program_number, int pid) {
		return new PATProgramDefaultImpl(program_number, pid);
	}

	public static PMT createPMT(int table_pid, int table_version, int program_num, int pcr_pid) {
		return new PMTDefaultImpl(table_pid, table_version, program_num, pcr_pid);
	}
	
	public static PMTStream createPMTStream(StreamType stream_type, int elementary_pid) {
		return new PMTStreamDefaultImpl(stream_type,elementary_pid);
	}
	
	public static MGT createMGT(int table_version) {
		MGT mgt = new MGTDefaultImpl();
		mgt.setVersionNumber(table_version);
		return mgt;
	}
	
	public static MGTTable createMGTTable(TableType type, int table_pid, int table_version, int table_num_bytes) {
		MGTTable table = new MGTTableDefaultImpl(type);
		table.setTableTypePID(table_pid);
		table.setTableTypeVersionNumber(table_version);
		table.setNumberBytes(table_num_bytes);
		return table;
	}
	
	public static TVCT createTVCT(int table_version, int transport_stream_id) {
		TVCT tvct = new TVCTDefaultImpl();
		tvct.setVersionNumber(table_version);
		tvct.setTransportStreamId(transport_stream_id);
		return tvct;
	}
	
	public static TVCTChannel createTVCTChannel(char[] short_name, int major_num, int minor_num,
			int modulation_mode, int frequency, int program_num, ServiceType stype,
			int source_id) {
		TVCTChannel channel = new TVCTChannelDefaultImpl();
		channel.setShortName(short_name);
		channel.setMajorChannelNumber(major_num);
		channel.setMinorChannelNumber(minor_num);
		channel.setModulationMode(modulation_mode);
		channel.setCarrierFrequency(frequency);
		channel.setProgramNumber(program_num);
		channel.setETMLocation(1); // '01' ETM located in the PTC carrying this PSIP
		channel.setAccessControlled(0); // not restricted
		channel.setHidden(0); // not hidden
		channel.setHideGuide(0); // guide(0)
		channel.setServiceType(stype);
		channel.setSourceId(source_id);

		return channel;
	}
	
	public static CVCT createCVCT(int table_version, int transport_stream_id) {
		CVCT cvct = new CVCTDefaultImpl();
		cvct.setVersionNumber(table_version);
		cvct.setTransportStreamId(transport_stream_id);
		return cvct;
	}
	
	public static CVCTChannel createCVCTChannel(char[] short_name, int major_num, int minor_num,
			int modulation_mode, int frequency, int program_num, ServiceType stype,
			int source_id) {
		CVCTChannel channel = new CVCTChannelDefaultImpl();
		channel.setShortName(short_name);
		channel.setMajorChannelNumber(major_num);
		channel.setMinorChannelNumber(minor_num);
		channel.setModulationMode(modulation_mode);
		channel.setCarrierFrequency(frequency);
		channel.setProgramNumber(program_num);
		channel.setETMLocation(1); // '01' ETM located in the PTC carrying this PSIP
		channel.setAccessControlled(0); // not restricted
		channel.setHidden(0); // not hidden
		channel.setPathSelect(0); // path 1
		channel.setOutOfBand(0); // this VC is carried within a tuned multiplex.
		channel.setHideGuide(0); // guide(0)
		channel.setServiceType(stype);
		channel.setSourceId(source_id);

		return channel;
	}
	
	public static STT createSTT(int table_version, long system_time, int gps_utc_offset, int daylight_savings) {
		STT stt = new STTDefaultImpl();
		stt.setVersionNumber(table_version);
		stt.setSystemTime(system_time);
		stt.setGPS_UTC_Offset(gps_utc_offset);
		stt.setDatlightSavings(daylight_savings);
		return stt;
	}
	
	public static RRT createRRT(int table_version, int rating_region) {
		RRT rrt = new RRTDefaultImpl();
		rrt.setVersionNumber(table_version);
		rrt.setRatingRegion(rating_region);
		return rrt;
	}
	
	public static RRTDimension createRRTDimension(int graduated_scale) {
		RRTDimension rrtdim = new RRTDimensionDefaultImpl();
		rrtdim.setGraduatedScale(graduated_scale);
		return rrtdim;
	}
	
	public static RRTDimensionValue createRRTDimensionValue() {
		RRTDimensionValue dimval = new RRTDimensionValueDefaultImpl();
		return dimval;
	}
	
	public static EIT createEIT(int table_pid, int table_version, int source_id) {
		EIT eit = new EITDefaultImpl(table_pid);
		eit.setVersionNumber(table_version);
		eit.setSourceId(source_id);
		return eit;
	}

	public static EITEvent createEITEvent(int event_id,	long start_time, int length_in_seconds) {
		EITEvent event = new EITEventDefaultImpl();
		event.setEventId(event_id);
		event.setStartTime(start_time);
		event.setLengthInSeconds(length_in_seconds);
		event.setETMLocation(0x1);
		return event;
	}
	
	public static ETT createETT(int table_pid, int ETT_table_id_extension, long ETM_id) {
		ETT ett = new ETTDefaultImpl(table_pid);
		ett.setETTTableIdExtension(ETT_table_id_extension);
		ett.setETMId(ETM_id);
		return ett;
	}
}
