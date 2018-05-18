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

	public static Packet[] packets;
	
	public static void loadPackets(){
		
		packets = new Packet[32];
		
		packets[1] = new AddPlayerPacket(1, null, null);
		packets[2] = new UpdatePlayerPacket(2, null, null);
		packets[3] = new KeyboardInputPacket(3, null, null);
		packets[4] = new SetWorldPacket(4, null, null);
		packets[5] = new SelectCharacterPacket(5, null, null);
		packets[6] = new SetStatePacket(6, null, null);
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
