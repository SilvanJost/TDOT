package server.net.packets;

import server.net.Connection;
import server.net.PacketHandler;

public class SetWorldPacket extends Packet{

	private int worldId;
	
	public SetWorldPacket() {
		super(PacketHandler.PACKET_SET_WORLD);
		// TODO Auto-generated constructor stub
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
		
		data = worldId+"";
		
		return this.packetID + data;
	}
	
	public void setWorld(int worldId){
		
		this.worldId = worldId;
	}

}
