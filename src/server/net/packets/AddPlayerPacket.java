package server.net.packets;

import server.net.Connection;
import server.net.PacketHandler;

public class AddPlayerPacket extends Packet{

	private int playerID;
	private String username;
	
	public AddPlayerPacket() {
		super(PacketHandler.PACKET_ADD_PLAYER);
	}

	@Override
	public Packet getAnswer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void execute(Connection conn) {
		// TODO Auto-generated method stub
		
	}

	public String buildPacket(){
		
		data = playerID+","+username;
		
		return this.packetID + data;
	}
	
	public void setID(int id){
		this.playerID = id;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
}
