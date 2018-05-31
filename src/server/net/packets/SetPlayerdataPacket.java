package server.net.packets;

import server.game.entities.Appi;
import server.game.entities.Player;
import server.main.Game;
import server.net.Connection;

public class SetPlayerdataPacket extends Packet{

	public SetPlayerdataPacket(int packetID) {
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
		// TODO Auto-generated method stub
		
	}
	

	public void addPlayer(Player player){
				
		int playerID = 0;
		
		if(player instanceof Appi){
			playerID = Game.CHAR_APPLI;
		}
		
		data += playerID + "," + player.getLives() + "/";
	}
	
	public void clear(){
		data = "";
	}
}
