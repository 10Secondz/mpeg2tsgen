/**
 * 
 */
package API.Descriptor;

import Core.ByteRepresentation;
import Core.XMLRepresentation;

/**
 * @author SungHun Park (dr.superchamp@gmail.com)
 *
 */
public interface DescriptorContent extends ByteRepresentation,
		XMLRepresentation {
	/**
	 * @return
	 */
	String getNameString();
}
