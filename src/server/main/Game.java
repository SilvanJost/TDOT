package server.main;

import java.util.ArrayList;
import java.util.List;

import server.game.entities.Player;
import server.net.Connection;
import server.net.InputHandler;
import server.net.PacketHandler;
import server.net.packets.AddPlayerPacket;
import server.net.packets.SetWorldPacket;
import server.net.packets.UpdatePlayerPacket;
import server.utils.Vector2;

public class Game {
	
	public static final int MAX_PLAYERS = 2;
	
	private static final int IDLE_STATE = 0;
	private static final int SELECTION_STATE = 1;
	private static final int GAME_STATE = 2;
	
	public static final int CHAR_APPLI = 0;
	public static final int CHAR_SYSTEMER = 1;
	public static final int CHAR_BETRIEBLER = 2;
	
	private int state = GAME_STATE;
	
	private int gameID;
	
	public static final Vector2 GRAVITY = new Vector2(0, 3);
	
	private List<Connection> connections = new ArrayList<Connection>();
	
	private List<Player> players = new ArrayList<Player>();
	
	
	
	public Game(){
		
	}
	
	/*
	 * When a connection joins, it gets all information sent
	 */
	public void join(Connection conn){
		
		connections.add(conn);
		
		for(Player player : players){
			
			AddPlayerPacket packet = (AddPlayerPacket) PacketHandler.buildPacket(01, null, null);
			
			conn.send(packet);
		}
		
		SetWorldPacket packet = (SetWorldPacket) PacketHandler.buildPacket(4, null, "1");
		conn.send(packet);
	}
	
	public void addPlayer(){
		
		Player player = new Player();
		players.add(player);
		
		AddPlayerPacket packet = (AddPlayerPacket) PacketHandler.buildPacket(01, null, null);
		
		for(Connection connection : connections){
			connection.send(packet);
		}
	}
	
	public void tick(){
		
		/* 
		 * testing script, that moves the players, so the client can see, he's getting updates
		 */
		
		if(state == IDLE_STATE){
			
			if(connections.size() == MAX_PLAYERS){
				
			}
			
		}else if(state == SELECTION_STATE){
			
		}else if(state == GAME_STATE){
			
			for(Player player : players){
				Vector2 position = player.getPosition();
				position.setX(position.getX() + 1);
				
				player.setPosition(position);
			}
			
		}
	}
	
	/*
	 * Synchronizes the clients with the Server
	 */
	public void update(){
		
		for(Connection conn : connections){
			
			for(int i=0;i<players.size();i++){
				
				Player player = players.get(i);
				
				UpdatePlayerPacket packet = (UpdatePlayerPacket) PacketHandler.buildPacket(02, null, null);
				packet.setPosition(player.getPosition());
				packet.setPlayerID(i);
				
				conn.send(packet);
				
			}
		}
	}
	
	public int getPlayerCount(){
		return this.connections.size();
	}
	
	public Player getPlayer(int id){
		return players.get(id);
	}
}
