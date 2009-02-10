/**
 * 
 */
package Core;

import API.BitOutputStream;
import API.MultiString;
import API.MyUTIL;
import API.RRTDimensionValue;

/**
 * @author SungHun Park (dr.superchamp@gmail.com)
 *
 */
public class RRTDimensionValueDefaultImpl implements RRTDimensionValue {
	protected MultiString abbrev_rating_value_text;
	protected MultiString rating_value_text;

	/* (non-Javadoc)
	 * @see API.RRTDimensionValue#getAbbrevRatingValueLength()
	 */
	@Override
	public int getAbbrevRatingValueLength() {
		if (abbrev_rating_value_text == null)
			return 0;
		return abbrev_rating_value_text.getSizeInBytes();
	}

	/* (non-Javadoc)
	 * @see API.RRTDimensionValue#getAbbrevRatingValueText()
	 */
	@Override
	public MultiString getAbbrevRatingValueText() {
		return abbrev_rating_value_text;
	}

	/* (non-Javadoc)
	 * @see API.RRTDimensionValue#getRatingValueLength()
	 */
	@Override
	public int getRatingValueLength() {
		if (rating_value_text == null)
			return 0;
		return rating_value_text.getSizeInBytes();
	}

	/* (non-Javadoc)
	 * @see API.RRTDimensionValue#getRatingValueText()
	 */
	@Override
	public MultiString getRatingValueText() {
		return rating_value_text;
	}

	/* (non-Javadoc)
	 * @see API.RRTDimensionValue#setAbbrevRatingValueText(API.MultiString)
	 */
	@Override
	public void setAbbrevRatingValueText(MultiString text) {
		abbrev_rating_value_text = text;
	}

	/* (non-Javadoc)
	 * @see API.RRTDimensionValue#setRatingValueText(API.MultiString)
	 */
	@Override
	public void setRatingValueText(MultiString text) {
		rating_value_text = text;
	}

	/* (non-Javadoc)
	 * @see API.ByteRepresentation#getSizeInBytes()
	 */
	@Override
	public int getSizeInBytes() {
		return 2 + abbrev_rating_value_text.getSizeInBytes() + rating_value_text.getSizeInBytes();
	}


	/* (non-Javadoc)
	 * @see API.ByteRepresentation#toByteArray()
	 */
	@Override
	public byte[] toByteArray() {
		BitOutputStream os = new BitOutputStream(getSizeInBytes()*Byte.SIZE);
		os.writeFromLSB(getAbbrevRatingValueLength(), 8);
		os.write(abbrev_rating_value_text.toByteArray());
		os.writeFromLSB(getRatingValueLength(), 8);
		os.write(rating_value_text.toByteArray());
		return os.toByteArray();
	}

	/* (non-Javadoc)
	 * @see API.XMLRepresentation#toXML(int)
	 */
	@Override
	public String toXMLString(int base_space) {
		String str = new String();
		str += (MyUTIL.whiteSpaceStr(base_space)+"<RRTDimensionValue>\n");

		if(abbrev_rating_value_text != null)
			str += abbrev_rating_value_text.toXMLString(base_space+2);
		if(rating_value_text != null)
			str += rating_value_text.toXMLString(base_space+2);

		str += (MyUTIL.whiteSpaceStr(base_space)+"</RRTDimensionValue>\n");
		return str;
	}
}
