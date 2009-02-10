package Core;

import API.Section;
/**
 * 
 */

/**
 * @author SungHun Park (dr.superchamp@gmail.com)
 *
 */
public interface SectionRepresentation {
	/**
	 * check whether a table is multisection or not. 
	 * @return
	 */
	boolean isMultiSection();

	/**
	 * return total section number
	 * @return
	 */
	int getTotalSectionNumber();

	/**
	 * generate section from a table.
	 * @return
	 */
	Section[] toSection();
}

