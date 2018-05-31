package client.net;

import java.util.Calendar;

import client.net.packets.AddPlayerPacket;
import client.net.packets.KeyboardInputPacket;
import client.net.packets.Packet;
import client.net.packets.SelectCharacterPacket;
import client.net.packets.SetStatePacket;
import client.net.packets.SetUsernamePacket;
import client.net.packets.SetWorldPacket;
import client.net.packets.UpdateEntityPacket;
import client.net.packets.UpdatePlayerPacket;

public class PacketHandler {

	public static final int PACKET_ADD_PLAYER = 1;
	public static final int PACKET_UPDATE_PLAYER = 2;
	public static final int PACKET_KEYBOARD_INPUT = 3;
	public static final int PACKET_SET_WORLD = 4;
	public static final int PACKET_SELECT_CHARACTER = 5;
	public static final int PACKET_SET_STATE = 6;
	public static final int PACKET_UPDATE_ENTITY = 7;
	public static final int PACKET_SET_USERNAME = 8;
	
	public static Packet[] packets = new Packet[32];
	
	public static void loadPackets(){
		packets[PACKET_ADD_PLAYER] = new AddPlayerPacket();
		packets[PACKET_UPDATE_PLAYER] = new UpdatePlayerPacket();
		packets[PACKET_KEYBOARD_INPUT] = new KeyboardInputPacket();
		packets[PACKET_SET_WORLD] = new SetWorldPacket();
		packets[PACKET_SELECT_CHARACTER] = new SelectCharacterPacket();
		packets[PACKET_SET_STATE] = new SetStatePacket();
		packets[PACKET_UPDATE_ENTITY] = new UpdateEntityPacket();
		packets[PACKET_SET_USERNAME] = new SetUsernamePacket();
	}
	
	public static Packet buildPacket(int id, String senderIP, String data){
		Packet packet = packets[id];
		packet.setSenderIP(senderIP);
		packet.setData(data);
		
		return packet;
	}
	
	public static void log(Packet packet){
		
		Calendar date = Calendar.getInstance();
		int hours = date.HOUR_OF_DAY;
		int minutes = date.MINUTE;
		int seconds = date.SECOND;
		
		String time = hours+":"+minutes+":"+seconds;
		
		System.out.println("[" + time + "] " + "package " + packet.getPacketID() + " containing " + packet.getData());
	}
}
