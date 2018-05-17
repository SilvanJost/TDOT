package server.main;

import client.gui.DisplayManager;
import server.net.PacketHandler;
import server.net.ServerConnector;

public class Kernel { 
	
	private static boolean running;
	
	public static void main(String[] args){
		
		PacketHandler.loadPackets();
		
		ServerConnector conn = new ServerConnector(8888);
		conn.start();
			
		running = true;
			
		float duration = 1000 / 60;
		float delta = 0;
			
		double last = System.currentTimeMillis();
		double now;
			
			
		while(running){
				
			now = System.currentTimeMillis();
				
			delta += now - last;
				
			if(delta >= duration){
					
				GameHandler.tick();
				GameHandler.update();
					
				delta = 0;
			}
			
			last = now;
		}
	}
}
