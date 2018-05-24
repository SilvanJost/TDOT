package server.net;

import java.io.BufferedReader;
import java.io.IOException;

import server.exceptions.ExceptionHandler;
import server.exceptions.SocketReadingException;
import server.net.packets.Packet;

public class SocketListener implements Runnable{

	private Connection connection;
	
	private BufferedReader reader;
	private String targetIP;
	private boolean running;
	
	public SocketListener(Connection connection, BufferedReader reader, String targetIP){
		this.connection = connection;
		this.reader = reader;
		this.targetIP = targetIP;
	}
	
	@Override
	public void run(){
		running = true;
		listen();
	}
	
	public void stop(){
		running = false;
	}
	
	private void listen(){
		try{
			String line;
			while(running){
				if(reader.ready()){

					
					line = reader.readLine();
					int packetID = Integer.parseInt(line.substring(0, 2));
					String data = line.substring(2);
					
					Packet packet = PacketHandler.buildPacket(packetID, targetIP, data);
					
					packet.execute(connection);
					Packet answer = packet.getAnswer();
					if(answer != null){
						
					}
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
