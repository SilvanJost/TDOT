package server.net.packets;

public class SetWorldPacket extends Packet{

	public SetWorldPacket(int packetID, String senderIP, String data) {
		super(packetID, senderIP, data);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Packet getAnswer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
