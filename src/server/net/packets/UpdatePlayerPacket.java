package server.net.packets;

import server.net.Connection;
import server.net.PacketHandler;
import server.utils.Vector2;
import server.utils.Vector2f;

public class UpdatePlayerPacket extends Packet{

	private int playerID;
	
	private Vector2f position;
	private int animation;
	private int health;
	
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
		
		String message = packetID + "" + playerID + "," + position.getX() + "," + position.getY() + "," + animation + "," + health;
		
		return message;
	}
	 
	 public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAnimation() {
		return animation;
	}

	public void setAnimation(int animation) {
		this.animation = animation;
	}

	public void setPosition(Vector2f vector2f){
		 this.position = vector2f;
	 }
	 
	 public void setPlayerID(int id){
		 this.playerID = id;
	 }
}
