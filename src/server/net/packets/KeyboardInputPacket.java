package server.net.packets;

import server.net.Connection;

public class KeyboardInputPacket extends Packet{
	
	public KeyboardInputPacket(int packetID, String senderIP, String data) {
		super(packetID, senderIP, data);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public Packet getAnswer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void execute(Connection conn) {

		
		
		
		
	}

}
