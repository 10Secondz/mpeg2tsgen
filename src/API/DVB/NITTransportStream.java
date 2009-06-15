/**
 * 
 */
package API.DVB;

import API.Descriptor.DescriptorMethod;
import Core.ByteRepresentation;
import Core.XMLRepresentation;

/**
 * @author SungHun Park (dr.superchamp@gmail.com)
 *
 */
public interface NITTransportStream extends ByteRepresentation,
		XMLRepresentation, DescriptorMethod {
	
	/**
	 * @return
	 */
	int getTransportStreamId();
	
	/**
	 * @return
	 */
	int getOrgNetworkId();
	
	/**
	 * @param ts_id
	 */
	void setTransportStreamId(int ts_id);
	
	/**
	 * @param org_net_id
	 */
	void setOrgNetworkId(int org_net_id);
}
