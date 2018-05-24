package client.net.packets;

import client.game.WorldHandler;
import client.net.PacketHandler;

public class SetWorldPacket extends Packet{

	public SetWorldPacket() {
		super(PacketHandler.PACKET_SET_WORLD);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		
		WorldHandler.setWorld(Integer.parseInt(data));
	}

}
