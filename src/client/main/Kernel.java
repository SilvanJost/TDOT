package client.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import client.net.ClientSocket;
import client.net.PacketHandler;
import client.net.packets.MessagePacket;
import client.net.packets.Packet;

public class Kernel {

	private ClientSocket socket;
	
	private BufferedReader reader;
	
	public Kernel(){
		
	}
	
	public static void main(String[] ags){
		
		Kernel kernel = new Kernel();
		kernel.start();
	}
	
	public void start(){
		
		socket = new ClientSocket();
		socket.connect("localhost", 8888);
		
		reader = new BufferedReader(new InputStreamReader(System.in));
		
		String line = null;
		
		PacketHandler.loadPackets();
		
		System.out.print("Message: ");
		
		while(true) {
		
			try {
				
				if((line = reader.readLine()) != null){
					
					Packet packet = PacketHandler.buildPacket(1, null, line);
					
					socket.send(packet);
					
					System.out.print("Message: ");
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
