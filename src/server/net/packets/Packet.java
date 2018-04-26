package server.net.packets;

public abstract class Packet {

	protected int packetID;
	protected String senderIP;
	protected String data;
	
	public Packet(int packetID, String senderIP, String data){
		
		this.packetID = packetID;
		this.senderIP = senderIP;
		this.data = data;
	}
	
	public abstract Packet getAnswer();
	
	public abstract void execute();
	
	public String buildMessage(){
		String message = this.packetID + this.data;
		
		return message;
	}
	
	public void setData(String data){
		this.data = data;
	}
	
	public void setSenderIP(String senderIP){
		this.senderIP = senderIP;
	}
	
	public int getPacketID(){
		return this.packetID;
	}
	
	public String getData(){
		return this.data;
	}
	
	public String getSenderIP(){
		return this.senderIP;
	}
}
