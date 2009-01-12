package API;
/**
 * 
 */

/**
 * @author SungHun Park (dr.superchamp@gmail.com)
 *
 */
public enum TableID {
	PROGRAM_ASSOCIATION_TABLE(0x00),
	CONDITIONAL_ACCESS_TABLE(0x01),
	PROGRAM_MAP_TABLE(0x02),
	MASTER_GUIDE_TABLE(0xC7),
	TERRESTRIAL_VIRTUAL_CHANNEL_TABLE(0xC8),
	CABLE_VIRTUAL_CHANNEL_TABLE(0xC9),
	RATING_REGION_TABLE(0xCA),
	EVENT_INFORMATION_TABLE(0xCB),
	EVENT_TEXT_TABLE(0xCC),
	SYSTEM_TIME_TABLE(0xCD),
	DIRECTED_CHANNEL_CHANGE_TABLE(0xD3),
	FORBIDDEN(0xFF);

	private int value;

	private TableID(int val) {
		value = val;
	}
	
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
