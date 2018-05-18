package server.net.packets;

import server.net.Connection;

public class PingPacket extends Packet{

	public PingPacket(int packetID, String senderIP, String data) {
		super(packetID, senderIP, data);
	}

	@Override
	public Packet getAnswer() {
		return null;
		
	}

	@Override
	public void execute(Connection conn) {
		System.out.println("Ping");
		
	}

}
