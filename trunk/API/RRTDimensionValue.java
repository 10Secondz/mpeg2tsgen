/**
 * 
 */
package API;

import Core.ByteRepresentation;
import Core.XMLRepresentation;


/**
 * @author SungHun Park (dr.superchamp@gmail.com)
 *
 */
public interface RRTDimensionValue extends ByteRepresentation, XMLRepresentation {
	/**
	 * return a value of 'abbrev_rating_value_length'.
	 * @return
	 */
	int getAbbrevRatingValueLength();
	
	/**
	 * return a value of 'abbrev_rating_value_text()'.
	 * @return
	 */
	MultiString getAbbrevRatingValueText();

	/**
	 * return a value of 'rating_value_length'.
	 * @return
	 */
	int getRatingValueLength();
	
	/**
	 * return a value of 'rating_value_text'.
	 * @return
	 */
	MultiString getRatingValueText();
	
	/**
	 * set a value of 'abbrev_rating_value_text()'.
	 * @param text
	 */
	void setAbbrevRatingValueText(MultiString text);
	
	/**
	 * set a value of 'rating_value_text()'.
	 * @param text
	 */
	void setRatingValueText(MultiString text);
}
