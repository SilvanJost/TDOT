package server.main;

import java.util.ArrayList;
import java.util.List;

import server.game.entities.Entity;
import server.game.entities.Player;
import server.game.entities.Systemer;
import server.net.Connection;
import server.net.InputHandler;
import server.net.PacketHandler;
import server.net.packets.AddPlayerPacket;
import server.net.packets.Packet;
import server.net.packets.SetWorldPacket;
import server.net.packets.UpdatePlayerPacket;
import server.utils.Parser;
import server.utils.Vector2;
import server.utils.Vector2f;

public class Game {
	
	public static final int MAX_PLAYERS = 2;
	
	public static final int MENU_STATE = 0;
	public static final int IDLE_STATE = 0;
	public static final int SELECTION_STATE = 1;
	public static final int GAME_STATE = 2;
	
	public static final int CHAR_APPLI = 0;
	public static final int CHAR_SYSTEMER = 1;
	public static final int CHAR_BETRIEBLER = 2;
	
	private int state = GAME_STATE;
	
	private int gameID;
	
	public static final Vector2f GRAVITY = new Vector2f(0, 1.5F);
	public static final float FALLING_CAP = 16;
	
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
			
			Packet packet = PacketHandler.buildPacket(PacketHandler.PACKET_ADD_PLAYER);
			
			conn.send(packet);
		}
		
		SetWorldPacket packet = (SetWorldPacket) PacketHandler.buildPacket(PacketHandler.PACKET_SET_WORLD);
		packet.setWorld(1);
		System.out.println(packet.buildMessage());
		
		conn.send(packet);
	}
	
	public void addPlayer(Connection conn){
		
		Player player = new Systemer();
		player.setPosition(new Vector2f(500,400));
		players.add(player);
		
		conn.setPlayerID(players.indexOf(player));
		player.setConnectionId(connections.indexOf(conn));
		
		AddPlayerPacket packet = (AddPlayerPacket) PacketHandler.buildPacket(PacketHandler.PACKET_ADD_PLAYER);
		
		for(Connection connection : connections){
			connection.send(packet);
		}
	}
	
	public void tick(){
		
		if(state == IDLE_STATE){
			
			if(connections.size() == MAX_PLAYERS){
				
				state = SELECTION_STATE;
			}
			
		}else if(state == SELECTION_STATE){
			
			boolean picked = true;
			
			for(Connection conn : connections){
				if(conn.getCharacter() == 0){
					picked = false;
				}
				
				if(!conn.isActive()){
					end();
				}
			}
			
			if(picked){
				
				state = GAME_STATE;
				
			}
			
		}else if(state == GAME_STATE){
			
			for(Connection conn : connections){
				
				InputHandler handler = conn.getInputHandler();
				
				players.get(conn.getPlayerID()).setMovementX(0);
				
				if(handler.isLeftPressed()){
					
					players.get(conn.getPlayerID()).move(-7);
				}
				
				if(handler.isRightPressed()){
					
					players.get(conn.getPlayerID()).move(7);
					
				}
				
				if(handler.isUpPressed()){
					players.get(conn.getPlayerID()).jump();
					handler.setUpPressed(false);
				}
				
				if(handler.isPunchPressed()){
					players.get(conn.getPlayerID()).punch(players);
					handler.setPunchPressed(false);
				}
			}
			
			List<Entity> entities = Parser.parsePlayerList(players);
			
			for(Player player : players){
				player.tick(WorldHandler.getWorld(WorldHandler.SKYLINE).getStructures());
				player.tickAbilities(WorldHandler.getWorld(WorldHandler.SKYLINE).getStructures(), players);
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
				
					
				packet.setAnimation(player.getAnimationId());
					
				player.setAnimationId(Player.NONE);
				
				packet.setHealth(player.getHealth());
				
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
	
	public void end(){
		
		for(Connection conn : connections){
			
			Packet packet = PacketHandler.buildPacket(6, null, MENU_STATE+"");
			conn.send(packet);
		}
		
	}
}
