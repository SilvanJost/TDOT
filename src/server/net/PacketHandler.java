package server.net;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import server.net.packets.AddPlayerPacket;
import server.net.packets.KeyboardInputPacket;
import server.net.packets.Packet;
import server.net.packets.SelectCharacterPacket;
import server.net.packets.SetStatePacket;
import server.net.packets.SetWorldPacket;
import server.net.packets.UpdatePlayerPacket;

public class PacketHandler {

	public static final int PACKET_ADD_PLAYER = 1;
	public static final int PACKET_UPDATE_PLAYER = 2;
	public static final int PACKET_KEYBOARD_INPUT = 3;
	public static final int PACKET_SET_WORLD = 4;
	public static final int PACKET_SELECT_CHARACTER = 5;
	public static final int PACKET_SET_STATE = 6;
	
	public static Packet[] packets;
	
	public static void loadPackets(){
		
		packets = new Packet[32];
		
		packets[PACKET_ADD_PLAYER] = new AddPlayerPacket();
		packets[PACKET_UPDATE_PLAYER] = new UpdatePlayerPacket();
		packets[PACKET_KEYBOARD_INPUT] = new KeyboardInputPacket();
		packets[PACKET_SET_WORLD] = new SetWorldPacket();
		packets[PACKET_SELECT_CHARACTER] = new SelectCharacterPacket();
		packets[PACKET_SET_STATE] = new SetStatePacket();
	}
	
	public static Packet buildPacket(int id){
		Packet packet = packets[id];
		
		return packet;
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
		
		System.out.println("[" + time + "] " + "received package " + packet.getPacketID() + " containing " + packet.getData());
	}
}
