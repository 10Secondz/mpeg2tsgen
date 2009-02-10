package API;

import Core.MPEGTransportPacketImpl;
/**
 * 
 */

/**
 * @author SungHun Park (dr.superchamp@gmail.com)
 *
 */
public class TransportPacketFactory {
	public static TransportPacket createMPEGPacket(int pid) {
		TransportPacket packet = new MPEGTransportPacketImpl();
		packet.setSyncByte(0x47); // 0100 0111
		packet.setTransportErrorIndicator(0);
		packet.setPayloadUnitStartIndicator(0);
		packet.setTransportPriority(0);
		packet.setPID(pid);
		packet.setTransportScramblingControl(0);
		packet.setAdaptationFieldControl(1); // no adaptation
		packet.setContinuityCounter(0); // I don't know what it does..
		return packet;
	}

	public static TransportPacket createMPEGStartPacket(int pid) {
		TransportPacket packet = createMPEGPacket(pid);
		packet.setPayloadUnitStartIndicator(1);
		return packet;
	}
	
	public static TransportPacket createMPEGNullPacket() {
		TransportPacket packet = new MPEGTransportPacketImpl();
		packet.setSyncByte(0x47); // 0100 0111
		packet.setPayloadUnitStartIndicator(0);
		packet.setPID(0x1FFF);
		packet.setTransportScramblingControl(0);
		packet.setAdaptationFieldControl(1);
		return packet;
	}
}
