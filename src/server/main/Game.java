package server.main;

import java.util.ArrayList;
import java.util.List;

import server.game.entities.Player;
import server.net.Connection;
import server.net.PacketHandler;
import server.net.packets.AddPlayerPacket;
import server.net.packets.SetWorldPacket;
import server.net.packets.UpdatePlayerPacket;
import server.utils.Vector2;

public class Game {
	
	public static final int MAX_PLAYERS = 5;
	
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
		player.setPosition(new Vector2(0,800));
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
		
		
		
		for(Player player : players){
			Vector2 position = player.getPosition();
			position.setX(position.getX() + 1);
			
			player.setPosition(position);
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
}
