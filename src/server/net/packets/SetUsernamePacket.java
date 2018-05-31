package server.net.packets;

import server.net.Connection;

public class SetUsernamePacket extends Packet{

	public SetUsernamePacket(int packetID) {
		super(packetID);
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
