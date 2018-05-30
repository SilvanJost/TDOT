package server.net.packets;

import client.net.PacketHandler;
import server.net.Connection;

public class SelectCharacterPacket extends Packet{

	public SelectCharacterPacket() {
		super(PacketHandler.PACKET_SELECT_CHARACTER);
		
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
