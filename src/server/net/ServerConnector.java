package server.net;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import server.exceptions.ExceptionHandler;
import server.main.GameHandler;
import server.net.packets.AddPlayerPacket;

public class ServerConnector extends Thread{

	private ServerSocket socket;
	private String ip;
	private int port;
	
	private boolean accepting;
	
	
	public ServerConnector(int port){
		this.port = port;
	}

	public void run(){
		openConnection();
	}
	
	public void openConnection(){
		
		try {
			
			socket = new ServerSocket(8888);
			
			accepting = true;
			
			System.out.println("Bound Socket on Interface "+ip);
			
			while(accepting){
				Socket client = socket.accept();
				
				System.out.println(client.getInetAddress() + " has Joined");
				
				Connection conn = new Connection(client);
				conn.listen();
				
				GameHandler.join(conn);
			}
			
			
		} catch (IOException e) {
			
			ExceptionHandler.handle(e);
		}
	}
	
	public void close(){
		
		try {
			this.socket.close();
			
		} catch (IOException e) {
			ExceptionHandler.handle(e);
		}
	}
}
