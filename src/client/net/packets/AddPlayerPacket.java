package client.net.packets;

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
		
		ClientKernel.addPlayer(new Player(0,800));
		
	}

}
