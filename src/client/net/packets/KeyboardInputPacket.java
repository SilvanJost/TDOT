package client.net.packets;

public class KeyboardInputPacket extends Packet{

	public KeyboardInputPacket(int packetID, String senderIP, String data) {
		super(packetID, senderIP, data);
		
	}

	@Override
	public void execute() {
		
		
	}
}
