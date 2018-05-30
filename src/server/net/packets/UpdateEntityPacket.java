package server.net.packets;

import server.net.Connection;
import server.net.PacketHandler;
import server.utils.Vector2;
import server.utils.Vector2f;

public class UpdateEntityPacket extends Packet{

	private int entityID;
	
	private int entities;
	
	private Vector2f position;
	
	public UpdateEntityPacket() {
		super(PacketHandler.PACKET_UPDATE_ENTITY);
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
	 
	 public void addEntity(int entityID, Vector2f position){
		 
		 if(data == null){
			 data = "";
		 }
		 
		 data += entityID + "," + position.getX() + "," + position.getY()+"/";
		 entities ++;
	 }
	 
	 public int getLength(){
		 return this.entities;
	 }
	 
	 public void clear(){
		 data = "";
		 entities = 0;
	 }
}
