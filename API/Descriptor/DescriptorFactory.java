package API.Descriptor;

import Core.Descriptor.AC3_AudioImpl;
import Core.Descriptor.DescriptorImpl;
import Core.Descriptor.ISO_639_LanguageImpl;
/**
 * 
 */
import Core.Descriptor.ServiceLocationImpl;

/**
 * @author SungHun Park (dr.superchamp@gmail.com)
 *
 */
public class DescriptorFactory {
	/**
	 * create an instance of a 'Descriptor'.
	 * @param descriptor_tag
	 * @return Descriptor instance
	 */
	public static Descriptor createDescriptor(DescriptorTag descriptor_tag) {
		return new DescriptorImpl(descriptor_tag);
	}
	
	public static DC_ISO639Language createISO_639_Language() {
		return new ISO_639_LanguageImpl();
	}
	
	public static DC_AC3Audio createAC3Audio() {
		return new AC3_AudioImpl();
	}
	
	public static DC_ServiceLocation createServiceLocation() {
		return new ServiceLocationImpl();
	}
	
	
}
