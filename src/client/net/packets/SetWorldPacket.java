package client.net.packets;

import client.game.WorldHandler;

public class SetWorldPacket extends Packet{

	public SetWorldPacket(int packetID, String senderIP, String data) {
		super(packetID, senderIP, data);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		
		WorldHandler.setWorld(Integer.parseInt(data));
	}

}
