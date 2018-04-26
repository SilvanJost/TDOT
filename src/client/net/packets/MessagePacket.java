package client.net.packets;

public class MessagePacket extends Packet{

	public MessagePacket(int packetID, String senderIP, String data) {
		super(packetID, senderIP, data);
	}	

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
