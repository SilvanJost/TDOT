package client.net.packets;

import client.entities.Player;
import client.main.ClientKernel;
import client.net.PacketHandler;
import client.utils.Vector2;

public class UpdatePlayerPacket extends Packet{

	public UpdatePlayerPacket() {
		super(PacketHandler.PACKET_UPDATE_PLAYER);
	}

	@Override
	public void execute() {
		
		String[] args = data.split(",");
		
		int playerID = Integer.parseInt(args[0]);
		
		int x = (int) Float.parseFloat(args[1]);
		int y = (int) Float.parseFloat(args[2]);
		int animation = Integer.parseInt(args[3]);
		int health = Integer.parseInt(args[4]);
		
		Vector2 position = new Vector2(x, y);
		
		Player player = ClientKernel.getPlayer(playerID);
		
		if(animation != 0){
			
			if(animation == Player.PUNCH){
				player.punch();
			}
		}
		
		ClientKernel.movePlayer(playerID, position);	
		
		player.setHealth(health);
	}

}
