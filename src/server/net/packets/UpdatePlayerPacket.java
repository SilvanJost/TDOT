package server.net.packets;

import server.utils.Vector2;

public class UpdatePlayerPacket extends Packet{

	private int playerID;
	
	private Vector2 position;
	
	public UpdatePlayerPacket(int packetID, String senderIP, String data) {
		super(packetID, senderIP, data);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Packet getAnswer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	 @Override
	public String buildMessage(){
		
		this.data = playerID + "," + position.getX() + "," + position.getY();
		
		return data;
	}
	 
	 public void setPosition(Vector2 position){
		 this.position = position;
	 }
	 
	 public void setPlayerID(int id){
		 this.playerID = id;
	 }
}
