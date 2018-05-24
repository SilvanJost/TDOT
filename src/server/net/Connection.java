package server.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import server.exceptions.ExceptionHandler;
import server.net.packets.Packet;

public class Connection {

	private Socket client;
	
	private boolean isActive;
	
	private PrintWriter writer;
	private BufferedReader reader;
	
	private SocketListener listener;
	
	private Thread listenerThread;
	
	private InputHandler handler;
	
	private int selectedCharacter;
	
	private int gameID;
	private int playerID;
	
	public Connection(Socket client){
		this.client = client;
		
		isActive = true;
		
		handler = new InputHandler();
		/*
		 * Creating a Reader and Writer for Packet transfer 
		 * using the given Socket's Input/Output Streams
		 */
		
		try {
			
			writer = new PrintWriter(client.getOutputStream());
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
		
		} catch (IOException e) {
			ExceptionHandler.handle(e);
		}
		
		listener = new SocketListener(this, reader, client.getInetAddress().toString());
	}
	
	public void listen(){
		
		listenerThread = new Thread(listener);
		listenerThread.start();
	}
	
	public void close(){
		listener.stop();
		
		try {
			client.close();
		} catch (IOException e) {
			ExceptionHandler.handle(e);
		}
	}
	
	public void send(Packet packet){
		String message = packet.buildMessage();
		writer.println(message);
		
		writer.flush();
	}
	
	public void setGameID(int gameID){
		this.gameID = gameID;
	}
	
	public void setPlayerID(int playerID){
		this.playerID = playerID;
	}
	
	public InputHandler getInputHandler(){
		return this.handler;
	}
	
	public void setCharacter(int character){
		this.selectedCharacter = character;
	}
	
	public int getCharacter(){
		return this.selectedCharacter;
	}
	
	public void terminate(){
		isActive = false;
	}
	
	public boolean isActive(){
		return this.isActive;
	}
	
	public int getPlayerID(){
		return this.playerID;
	}
}

