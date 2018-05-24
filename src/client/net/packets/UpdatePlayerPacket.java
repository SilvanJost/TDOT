package client.net.packets;

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
		
		int x = Integer.parseInt(args[1]);
		int y = Integer.parseInt(args[2]);
		
		Vector2 position = new Vector2(x, y);
		
		ClientKernel.movePlayer(playerID, position);	
	}

}
