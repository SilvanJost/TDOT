package client.net.packets;

import client.entities.Player;
import client.main.ClientKernel;

public class AddPlayerPacket extends Packet{

	public AddPlayerPacket(int packetID, String senderIP, String data) {
		super(packetID, senderIP, data);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		
		ClientKernel.addPlayer(new Player(0,800));
		
	}

}
