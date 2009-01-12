package API;


/**
 * @author Administrator
 * @version 1.0
 * @created 30-Dec-2008 3:26:52 PM
 */
public enum ServiceType {
	RESERVED(0x00),
	ANALOG_TELEVISION(0x01),
	ATSC_DIGITAL_TELEVISION(0x02),
	ATSC_AUDIO(0x03),
	ATSC_DATA_ONLY_SERVICE(0x04);
	
	private int value;
	private ServiceType(int x) {
		value = x;
	}
	
	public int getValue() {
		return value;
	}
}