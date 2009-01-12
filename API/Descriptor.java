package API;

import Core.ByteRepresentation;
/**
 * 
 */
import Core.XMLRepresentation;

/**
 * @author SungHun Park (dr.superchamp@gmail.com)
 *
 */
public interface Descriptor extends ByteRepresentation, XMLRepresentation {
	/**
	 * return descriptor tag.
	 * @return DescriptorTag 
	 */
	DescriptorTag getDescriptorTag();
	
	/**
	 * return a value of 'descriptor_length field'.
	 * @return descriptor_length
	 */
	int getDescriptorLength();
}
