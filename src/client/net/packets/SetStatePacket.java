package client.net.packets;

import client.main.ClientKernel;
import client.net.PacketHandler;

public class SetStatePacket extends Packet{

	public SetStatePacket() {
		super(PacketHandler.PACKET_SET_STATE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		ClientKernel.setState(Integer.parseInt(data));
	}

}
