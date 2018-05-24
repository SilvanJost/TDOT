package server.net.packets;

import server.main.Game;
import server.net.Connection;
import server.net.PacketHandler;

public class SetStatePacket extends Packet{

	public SetStatePacket() {
		super(PacketHandler.PACKET_SET_STATE);
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
