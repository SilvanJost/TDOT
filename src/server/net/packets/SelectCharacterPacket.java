package server.net.packets;

import server.net.Connection;

public class SelectCharacterPacket extends Packet{

	public SelectCharacterPacket(int packetID, String senderIP, String data) {
		super(packetID, senderIP, data);
		
	}

	@Override
	public Packet getAnswer() {
		
		return null;
	}

	@Override
	public void execute(Connection conn) {

		conn.setCharacter(Integer.parseInt(data));
	}
	
}
