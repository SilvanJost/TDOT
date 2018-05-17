package server.net;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import server.net.packets.AddPlayerPacket;
import server.net.packets.Packet;
import server.net.packets.UpdatePlayerPacket;

public class PacketHandler {

	public static Packet[] packets;
	
	public static void loadPackets(){
		
		packets = new Packet[32];
		
		packets[1] = new AddPlayerPacket(01, null, null);
		packets[2] = new UpdatePlayerPacket(02, null, null);
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
