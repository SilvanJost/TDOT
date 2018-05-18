package client.net.packets;

import client.main.ClientKernel;

public class SetStatePacket extends Packet{

	public SetStatePacket(int packetID, String senderIP, String data) {
		super(packetID, senderIP, data);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		ClientKernel.setState(Integer.parseInt(data));
	}

}
