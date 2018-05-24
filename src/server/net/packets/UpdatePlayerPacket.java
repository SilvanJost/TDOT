package server.net.packets;

import server.net.Connection;
import server.net.PacketHandler;
import server.utils.Vector2;

public class UpdatePlayerPacket extends Packet{

	private int playerID;
	
	private Vector2 position;
	
	public UpdatePlayerPacket() {
		super(PacketHandler.PACKET_UPDATE_PLAYER);
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
		
		String message = packetID + "" + playerID + "," + position.getX() + "," + position.getY();
		
		return message;
	}
	 
	 public void setPosition(Vector2 position){
		 this.position = position;
	 }
	 
	 public void setPlayerID(int id){
		 this.playerID = id;
	 }
}
