package client.net.packets;

import client.assets.Assets;
import client.entities.Entity;
import client.main.ClientKernel;
import client.net.PacketHandler;
import client.utils.Vector2;

public class UpdateEntityPacket extends Packet{

	public UpdateEntityPacket() {
		super(PacketHandler.PACKET_UPDATE_ENTITY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
			String[] args = data.split(",");
				
			int entityId = Integer.parseInt(args[0]);
				
			int x = (int) Float.parseFloat(args[1]);
			int y = (int) Float.parseFloat(args[2]);
				
			Entity e;
				
			switch(entityId){
				case ClientKernel.ENTITY_BUENO:
					e = new Entity(Assets.bueno, 60, 60, x, y);
				default:
					e = new Entity(Assets.keyboard, 60, 30, x, y);
			}
				
			ClientKernel.addEntity(e);
	}
	
}
