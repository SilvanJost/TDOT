package client.input;

import java.io.BufferedReader;
import java.io.IOException;

import client.main.ClientKernel;
import client.net.PacketHandler;
import client.net.packets.Packet;

public class ConsoleListener implements Runnable{

	private ClientKernel kernel;
	
	private BufferedReader reader;
	
	private boolean running;
	
	@Override
	public void run() {
		
		String line;
		
		System.out.print("Message: ");
		
		while(running) {
		
			try {
				
				if((line = reader.readLine()) != null){
					
					Packet packet = PacketHandler.buildPacket(1, null, line);
					
					kernel.getClientSocket().send(packet);
					
					System.out.print("Message: ");
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void stop(){
		
		running = false;
	}
}
