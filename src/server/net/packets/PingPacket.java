package server.net.packets;

public class PingPacket extends Packet{

	public PingPacket(int packetID, String senderIP, String data) {
		super(packetID, senderIP, data);
	}

	@Override
	public Packet getAnswer() {
		return null;
		
	}

	@Override
	public void execute() {
		System.out.println("Ping");
		
	}

}
