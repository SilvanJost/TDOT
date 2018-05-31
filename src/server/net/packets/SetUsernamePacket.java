package server.net.packets;

import server.net.Connection;
import server.net.PacketHandler;

public class SetUsernamePacket extends Packet{

	public SetUsernamePacket() {
		super(PacketHandler.PACKET_SET_USERNAME);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Packet getAnswer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void execute(Connection conn) {

		conn.setUsername(data);
		
	}

	
}
