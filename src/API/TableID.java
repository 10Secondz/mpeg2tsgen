package API;
/**
 * 
 */

/**
 * @author SungHun Park (dr.superchamp@gmail.com)
 *
 */
/**
 * @author SungHun Park (dr.superchamp@gmail.com)
 *
 */
public enum TableID {
	/**
	 * 
	 */
	PROGRAM_ASSOCIATION_TABLE(0x00),
	/**
	 * 
	 */
	CONDITIONAL_ACCESS_TABLE(0x01),
	/**
	 * 
	 */
	PROGRAM_MAP_TABLE(0x02),
	/**
	 * 
	 */
	MASTER_GUIDE_TABLE(0xC7),
	/**
	 * 
	 */
	TERRESTRIAL_VIRTUAL_CHANNEL_TABLE(0xC8),
	/**
	 * 
	 */
	CABLE_VIRTUAL_CHANNEL_TABLE(0xC9),
	/**
	 * 
	 */
	RATING_REGION_TABLE(0xCA),
	/**
	 * 
	 */
	EVENT_INFORMATION_TABLE(0xCB),
	/**
	 * 
	 */
	EVENT_TEXT_TABLE(0xCC),
	/**
	 * 
	 */
	SYSTEM_TIME_TABLE(0xCD),
	/**
	 * 
	 */
	DIRECTED_CHANNEL_CHANGE_TABLE(0xD3),
	
	/**
	 * 
	 */
	NETWORK_INFORMATION_TABLE_ACTUAL(0x40),
	
	/**
	 * 
	 */
	NETWORK_INFORMATION_TABLE_OTHER(0x41),
	
	/**
	 * 
	 */
	SERVICE_DESCRIPTION_TABLE_ACTUAL(0x42),
	
	/**
	 * 
	 */
	SERVICE_DESCRIPTION_TABLE_OTHER(0x46),
	
	/**
	 * 
	 */
	BOUQUET_ASSOCIATION_TABLE(0x4A),
	
	EVENT_INFORMATION_ACTUAL_PF(0x4E),
	
	EVENT_INFORMATION_OTHER_PF(0x4F),
	
	EVENT_INFORMATION_ACTUAL_SCHEDULE_0(0x50),
	EVENT_INFORMATION_ACTUAL_SCHEDULE_1(0x51),
	EVENT_INFORMATION_ACTUAL_SCHEDULE_2(0x52),
	EVENT_INFORMATION_ACTUAL_SCHEDULE_3(0x53),
	EVENT_INFORMATION_ACTUAL_SCHEDULE_4(0x54),
	EVENT_INFORMATION_ACTUAL_SCHEDULE_5(0x55),
	EVENT_INFORMATION_ACTUAL_SCHEDULE_6(0x56),
	EVENT_INFORMATION_ACTUAL_SCHEDULE_7(0x57),
	EVENT_INFORMATION_ACTUAL_SCHEDULE_8(0x58),
	EVENT_INFORMATION_ACTUAL_SCHEDULE_9(0x59),
	EVENT_INFORMATION_ACTUAL_SCHEDULE_A(0x5A),
	EVENT_INFORMATION_ACTUAL_SCHEDULE_B(0x5B),
	EVENT_INFORMATION_ACTUAL_SCHEDULE_C(0x5C),
	EVENT_INFORMATION_ACTUAL_SCHEDULE_D(0x5D),
	EVENT_INFORMATION_ACTUAL_SCHEDULE_E(0x5E),
	EVENT_INFORMATION_ACTUAL_SCHEDULE_F(0x5F),

	EVENT_INFORMATION_OTHER_SCHEDULE_0(0x60),
	EVENT_INFORMATION_OTHER_SCHEDULE_1(0x61),
	EVENT_INFORMATION_OTHER_SCHEDULE_2(0x62),
	EVENT_INFORMATION_OTHER_SCHEDULE_3(0x63),
	EVENT_INFORMATION_OTHER_SCHEDULE_4(0x64),
	EVENT_INFORMATION_OTHER_SCHEDULE_5(0x65),
	EVENT_INFORMATION_OTHER_SCHEDULE_6(0x66),
	EVENT_INFORMATION_OTHER_SCHEDULE_7(0x67),
	EVENT_INFORMATION_OTHER_SCHEDULE_8(0x68),
	EVENT_INFORMATION_OTHER_SCHEDULE_9(0x69),
	EVENT_INFORMATION_OTHER_SCHEDULE_A(0x6A),
	EVENT_INFORMATION_OTHER_SCHEDULE_B(0x6B),
	EVENT_INFORMATION_OTHER_SCHEDULE_C(0x6C),
	EVENT_INFORMATION_OTHER_SCHEDULE_D(0x6D),
	EVENT_INFORMATION_OTHER_SCHEDULE_E(0x6E),
	EVENT_INFORMATION_OTHER_SCHEDULE_F(0x6F),
	
	
	/**
	 * 
	 */
	FORBIDDEN(0xFF);

	private int value;

	private TableID(int val) {
		value = val;
	}
	
	/**
	 * @return
	 */
	public int getValue() {
		return value;
	}
	
	public String toString() {
		switch(value) {
		case 0x00:
			return "PROGRAM_ASSOCIATION_TABLE";
		case 0x01:
			return "CONDITIONAL_ACCESS_TABLE";
		case 0x02:
			return "PROGRAM_MAP_TABLE";
		case 0xC7:
			return "MASTER_GUIDE_TABLE";
		case 0xC8:
			return "TERRESTRIAL_VIRTUAL_CHANNEL_TABLE";
		case 0xC9:
			return "CABLE_VIRTUAL_CHANNEL_TABLE";
		case 0xCA:
			return "RATING_REGION_TABLE";
		case 0xCB:
			return "EVENT_INFORMATION_TABLE";
		case 0xCC:
			return "EVENT_TEXT_TABLE";
		case 0xCD:
			return "SYSTEM_TIME_TABLE";
		case 0xD3:
			return "DIRECTED_CHANNEL_CHANGE_TABLE";
		case 0xFF:
			return "FORBIDDEN";
		default:
			return "UNKNOWN";
		}
	}
}