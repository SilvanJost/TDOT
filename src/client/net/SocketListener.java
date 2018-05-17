package client.net;

import java.io.BufferedReader;
import java.io.IOException;

import client.net.packets.Packet;

public class SocketListener implements Runnable{

	private boolean running;
	
	private BufferedReader reader;
	
	private String targetIP;
	
	public SocketListener(BufferedReader reader, String targetIP){
		
		this.reader = reader;
	}

	@Override
	public void run() {
		
		running = true;
		listen();
	}
	
	private void listen(){
		
		try{
			String line;
			while(running){
				
				line = reader.readLine();
				if(line != null){
					
					int packetID = Integer.parseInt(line.substring(0, 1));
					String data = line.substring(1);
					
					Packet packet = PacketHandler.buildPacket(packetID, targetIP, data);
					
					packet.execute();
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void stop(){
		running = false;
	}
}
