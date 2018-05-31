package client.net.packets;

import client.net.PacketHandler;

public class SetUsernamePacket extends Packet{

	public SetUsernamePacket() {
		super(PacketHandler.PACKET_SET_USERNAME);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
	
	public void setUsername(String username){
		
		data = username;
	}
}
