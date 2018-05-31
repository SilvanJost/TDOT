package server.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import server.game.entities.Entity;
import server.game.entities.Player;
import server.geometrics.Collider;
import server.geometrics.Hitbox;
import server.game.entities.Appi;
import server.game.entities.Betriebler;
import server.net.Connection;
import server.net.InputHandler;
import server.net.PacketHandler;
import server.net.packets.AddPlayerPacket;
import server.net.packets.Packet;
import server.net.packets.SetStatePacket;
import server.net.packets.SetWorldPacket;
import server.net.packets.UpdateEntityPacket;
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
	public static final int OVERVIEW_STATE = 3;
	
	public static final int CHAR_APPLI = 1;
	public static final int CHAR_SYSTEMER = 2;
	public static final int CHAR_BETRIEBLER = 3;
	
	public static final int ENTITY_BUENO = 4;
	public static final int ENTITY_TICKET = 5;
	
	private boolean running;
	
	private int state = IDLE_STATE;
	
	private Random random;
	
	private int buenoChance = 15 * 60;
	
	private int gameID;
	
	public static final Vector2f GRAVITY = new Vector2f(0, 1.4F);
	public static final float FALLING_CAP = 16;
	
	private List<Connection> connections = new ArrayList<Connection>();
	
	private List<Player> players = new ArrayList<Player>();
	
	private List<Entity> buenos = new ArrayList<Entity>();
	
	
	public Game(){
		
		random = new Random();
		
		running = true;
	}
	
	/*
	 * When a connection joins, it gets all information sent
	 */
	public void join(Connection c){
		
		connections.add(c);
		
		SetWorldPacket packet = (SetWorldPacket) PacketHandler.buildPacket(PacketHandler.PACKET_SET_WORLD);
		packet.setWorld(1);
		System.out.println(packet.buildMessage());
		
		c.send(packet);
	}
	
	public void initPlayers(){
		
		for(Connection conn : connections){
			
			Player player = null;
			
			switch(conn.getCharacter()){
				case CHAR_APPLI:
					player = new Appi();
					break;
				case CHAR_SYSTEMER:
					
					break;
				default:
					player = new Betriebler();
					break;
			}
			
			player.setPosition(new Vector2f(500,400));
			players.add(player);
			
			conn.setPlayerID(players.indexOf(player));
			player.setConnectionId(connections.indexOf(conn));
			
			AddPlayerPacket packet = (AddPlayerPacket) PacketHandler.buildPacket(PacketHandler.PACKET_ADD_PLAYER);
			packet.setID(conn.getCharacter());
			packet.setUsername(conn.getUsername());
			
			for(Connection connection : connections){
				connection.send(packet);
			}
		}
	}
	
	public synchronized void tick(){
		
		try{
		
			if(state == IDLE_STATE){
				
				if(connections.size() == MAX_PLAYERS){
					
					state = SELECTION_STATE;
					
					SetStatePacket setStatePacket = (SetStatePacket) PacketHandler.buildPacket(PacketHandler.PACKET_SET_STATE);
					setStatePacket.setData(SELECTION_STATE+"");
					
					for(Connection conn : connections){
						
						conn.send(setStatePacket);
						
					}
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
					
					initPlayers();
					
					state = GAME_STATE;
					System.out.println("Starting Game "+gameID);
					
					SetStatePacket setStatePacket = (SetStatePacket) PacketHandler.buildPacket(PacketHandler.PACKET_SET_STATE);
					setStatePacket.setData(GAME_STATE+"");
					
					for(Connection conn : connections){
						
						conn.send(setStatePacket);
						
					}
				}
				
			}else if(state == GAME_STATE){
				
				
				for(Connection conn : connections){
					
					InputHandler handler = conn.getInputHandler();
					
					//players.get(conn.getPlayerID()).setMovementX(0);
					
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
					
					if(handler.isThrowPressed()){
						players.get(conn.getPlayerID()).loadToss();
					}else{
						players.get(conn.getPlayerID()).toss();
					}
					
					if(handler.isSpecialPressed()){
						players.get(conn.getPlayerID()).useSuper(players);
					}
				}
				
				List<Entity> entities = Parser.parsePlayerList(players);
				
				List<Entity> toRemove = new ArrayList<Entity>();
				
				for(Entity bueno : buenos){
					bueno.tick(WorldHandler.getWorld(WorldHandler.SKYLINE).getStructures());
					
					if(bueno.getPosition().getY() > 1080){
	
						toRemove.add(bueno);
					}
				}
				
				for(Entity e : toRemove){
					
					buenos.remove(e);
					
				}
				
				toRemove.clear();
				
				int deaths = 0;
				
				for(Player player : players){
					player.tick(WorldHandler.getWorld(WorldHandler.SKYLINE).getStructures());
					player.tickAbilities(WorldHandler.getWorld(WorldHandler.SKYLINE).getStructures(), players);
					
					for(Entity bueno : buenos){
						if(Collider.getCollision(player.getHitbox(), bueno.getHitbox())){
							
							player.collectBueno();
							
							toRemove.add(bueno);
						}
					}
					
					for(Entity e : toRemove){
						
						buenos.remove(e);
						
					}
					
					if(player.getLives() < 1){
						deaths ++;
					}
				}
				
				if(deaths >= players.size() - 1){
					end();
				}
				
				if(random.nextInt(buenoChance) == 0){
					Entity bueno = new Entity();
					bueno.setPosition(new Vector2f(random.nextInt(1920), 50));
					bueno.setHitbox(new Hitbox(bueno, 60, 60, new Vector2(0, 0)));
					buenos.add(bueno);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			end();
		}
	}
	
	/*
	 * Synchronizes the clients with the Server
	 */
	public void update(){
		
		try{
		
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
					
					 //UPDATES ENTITIES----------------------------------------------------------------------------
					UpdateEntityPacket entityPacket = (UpdateEntityPacket) PacketHandler.buildPacket(PacketHandler.PACKET_UPDATE_ENTITY);
					
					if(player.getThrowable().isActive()){
						
						entityPacket.addEntity(player.getThrowable().getId(), player.getThrowable().getPosition());
					}
					
					for(Player p : players){
						if(p instanceof Betriebler){
							
							Betriebler b = (Betriebler) p;
							
							if(b.isTicketActive()){
								entityPacket.addEntity(ENTITY_TICKET, b.getTicket().getPosition());
							}
						}
					}
					
					for(Entity bueno : buenos){
						
						entityPacket.addEntity(ENTITY_BUENO, bueno.getPosition());
					}
					if(entityPacket.getLength() > 0){
						conn.send(entityPacket);
					}
					
					entityPacket.clear();
					//----------------------------------------------------------------------------------------------
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("An Error has occured");
			end();
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
		System.out.println("Stopped Game "+gameID);
		
		running = false;
	}
	
	public void setGameID(int gameID){
		this.gameID = gameID;
	}
	
	public boolean isRunning(){
		return this.running;
	}
}
