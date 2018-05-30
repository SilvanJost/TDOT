package server.net.packets;

import server.net.Connection;
import server.net.PacketHandler;
import server.utils.Vector2;
import server.utils.Vector2f;

public class UpdateEntityPacket extends Packet{

	private int entityID;
	
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

	 @Override
	public String buildMessage(){
		
		String message = packetID + "" + entityID + "," + position.getX() + "," + position.getY();
		
		return message;
	}
	 
	public void setPosition(Vector2f vector2f){
		 this.position = vector2f;
	 }
	 
	 public void setEntityID(int id){
		 this.entityID = id;
	 }
}
