package client.net.packets;

import client.entities.Appli;
import client.entities.Betriebler;
import client.entities.Player;
import client.main.ClientKernel;
import client.net.PacketHandler;

public class AddPlayerPacket extends Packet{

	public AddPlayerPacket() {
		super(PacketHandler.PACKET_ADD_PLAYER);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		
		String[] args = data.split(",");
		
		int charID = Integer.parseInt(args[0]);
		String username = args[1];
		
		Player player = null;
		
		if(charID == ClientKernel.CHAR_APPLI){
			
			player = new Appli(0, 0);
			
		}else if(charID == ClientKernel.CHAR_SYSTEMER){
			
		}else{
			
			player = new Betriebler(0, 0);
			
		}
		
		player.setUsername(username);
		
		ClientKernel.addPlayer(player);
	}

}
