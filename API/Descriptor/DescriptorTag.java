/**
 * 
 */
package API;

/**
 * @author SungHun Park (dr.superchamp@gmail.com)
 *
 */
public enum DescriptorTag {
	STUFFING(0x80),
	AC3_AUDIO(0x81),
	CAPTION_SERVICE(0x86),
	CONTENT_ADVISORY(0x87),
	EXTENDED_CHANNEL_NAME(0xA0),
	SERVICE_LOCATION(0xA1),
	TIMESHIFTED_SERVICE(0xA2),
	COMPONENT_NAME(0xA3),
	DCC_DEPARTING_REQUEST(0xA8),
	DCC_ARRIVING_REQUEST(0xA9),
	REDISTRIBUTION_CONTROL(0xAA),
	ATSC_PRIVATE_INFORMATION(0xAD),
	CONTENT_IDENTIFIER(0xB6),
	GENRE(0xAB);
	
	
	private int value;

	private DescriptorTag(int x) {
		value = x;
	}
	
	public int getValue() {
		return value;
	}
}
