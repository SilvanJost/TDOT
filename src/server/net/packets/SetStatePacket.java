package server.net.packets;

import server.main.Game;
import server.net.Connection;

public class SetStatePacket extends Packet{

	public SetStatePacket(int packetID, String senderIP, String data) {
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

		if(Integer.parseInt(data) == Game.MENU_STATE){
			
			
			
		}
	}

}
