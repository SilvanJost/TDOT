package client.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import client.net.packets.Packet;

public class ClientSocket {

	private static Socket socket;
	
	private Thread listenerThread;
	
	private SocketListener listener;
	
	private BufferedReader reader;
	private PrintWriter writer;
	
	public ClientSocket(){
		
		this.socket = new Socket();
	}
	
	public void connect(String targetIP, int port){
		
		/*boolean connected = false;;
		
		while(!connected){*/
			try {
				
				socket.connect(new InetSocketAddress("localhost", 8888));
				
				writer = new PrintWriter(socket.getOutputStream());
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				//connected = true;
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		//}
	}
	
	public void listen(){
		
		listener = new SocketListener(reader, socket.getRemoteSocketAddress().toString());
		listenerThread = new Thread(listener);
		listenerThread.start();
	}
	
	public void close(){
		
		listener.stop();
		
		try {
			
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void send(Packet packet){
		
		String message = packet.buildMessage();
		writer.println(message);
		
		writer.flush();
	}
}
