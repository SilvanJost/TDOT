package client.main;

import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import client.assets.Assets;
import client.entities.Entity;
import client.entities.Player;
import client.game.WorldHandler;
import client.gui.CharSelectContext;
import client.gui.Context;
import client.gui.DisplayManager;
import client.gui.MenuContext;
import client.input.InputHandler;
import client.net.ClientSocket;
import client.net.PacketHandler;
import client.net.packets.Packet;
import client.net.packets.SelectCharacterPacket;
import client.utils.Vector2;

public class ClientKernel {

	private static final int MENU_STATE = 0;
	private static final int SELECTION_STATE = 1;
	private static final int GAME_STATE = 2;
	
	public static final int CHAR_APPLI = 1;
	public static final int CHAR_SYSTEMER = 2;
	public static final int CHAR_BETRIEBLER = 3;
	
	public static final int THROWABLE_PHONE = 1;
	public static final int THROWABLE_KEYBOARD = 2;
	public static final int THROWABLE_COMPUTER = 3;
	public static final int ENTITY_BUENO = 4;
	
	public static final Vector2 RESOLUTION = new Vector2(1920, 1080);
	
	private static int state = MENU_STATE;
	
	private static Context context = new MenuContext();
	
	private static ClientSocket socket;
	
	private BufferStrategy bs;
	private Graphics2D g;
	
	private static InputHandler inputHandler;
	
	private int ticks = 0;
	
	private static List<Player> players = new ArrayList<Player>();
	private static List<Entity> entities = new ArrayList<Entity>();
	
	private boolean running;
	
	private static final int FPS = 20;
	
	public ClientKernel(){
		
	}
	
	public static void main(String[] ags){
		
		ClientKernel kernel = new ClientKernel();
		kernel.start();
	}
	
	/*
	 * Initiates a connection to the server
	 * 
	 * Creates a Display
	 * 
	 * Starts the gameloop
	 * 
	 * Stops clean afterwards
	 */
	public void start(){
		
		running = true;
		
		Assets.init();
		WorldHandler.init();
		PacketHandler.loadPackets();
		
		
		context.init();
		
		/*
		inputHandler = new InputHandler();
		DisplayManager.addKeyListener(inputHandler);*/
		
		float duration = 1000 / FPS;
		float delta = 0;
		
		double last = System.currentTimeMillis();
		double now;
		
		while(running){
			
			now = System.currentTimeMillis();
			
			delta += now - last;

			if(delta >= duration){
				ticks++;
				System.out.println(1);
				if(state == GAME_STATE){
					System.out.println(2);
					tick();
					System.out.println(3);
					render();
				}
				
				delta = 0;
			}
		}
		
		stop();
	}
	
	public void tick(){
		
		for(Player player : players){
			player.tick();
		}
		
		context.tick();
	}
	
	/*
	 * Central render loop
	 * 
	 * Creates a BufferStrategy and draws everything to the screen with its Graphics object
	 */
	public synchronized void render(){

		try{
			if(bs == null){
				DisplayManager.getCanvas().createBufferStrategy(2);
				bs = DisplayManager.getCanvas().getBufferStrategy();
					
			}
				
			g = (Graphics2D) bs.getDrawGraphics();
		
			DisplayManager.clearDisplay(g);
			if(state == GAME_STATE){
				if(WorldHandler.getCurrentWorld() != 0){
					WorldHandler.render(g);
				}
				
				for(Player player : players){
					player.render(g);
				}
				
				List<Entity> renderEntities = new ArrayList<Entity>();
				renderEntities.addAll(entities);
				for(Entity e : renderEntities){
					e.render(g);
				}
			}
			
			context.render(g);
			
			bs.show();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/*
	 * Stops the program and cleans up
	 */
	public void stop(){
		
		DisplayManager.destroyDispaly();
	}
	
	public static void selectCharacter(int character){
		
		SelectCharacterPacket packet = (SelectCharacterPacket) PacketHandler.buildPacket(PacketHandler.PACKET_SELECT_CHARACTER, null, null);
		packet.setCharacter(character);
		socket.send(packet);
	}
	
	public static void joinGame(){
		
		socket = new ClientSocket();
		socket.connect("localhost", 8888);
		
		socket.listen();
	}
	
	public static void exitToMenu(){
		
	}
	
	public static ClientSocket getClientSocket(){
		return socket;
	}
	
	public static void addPlayer(Player player){
		
		players.add(player);
	}
	
	public static void movePlayer(int playerID, Vector2 position){
		
		Player player = players.get(playerID);
		
		player.setLastPosition(player.getPosition());
		player.setPosition(position);
	}
	
	public static Player getPlayer(int playerID){
		return players.get(playerID);
	}
	
	public synchronized static void setState(int s){
		
		state = s;
		
		switch(state) {
			case SELECTION_STATE:
				
				context = new CharSelectContext();
				context.init();
				break;
			case GAME_STATE:
				
				System.out.println("SAAAS");
				DisplayManager.clearPanel();
				DisplayManager.removePanel();
				DisplayManager.initCanvas();
				
				inputHandler = new InputHandler();
				DisplayManager.addKeyListener(inputHandler);
				
				System.out.println("frame reinitialied");
				break;
		}
	}
	
	public synchronized static void addEntity(Entity e){
		entities.add(e);
	}
	
	public synchronized static void clearEntities(){
		entities.clear();
	}
	
	public static Entity getEntity(int entityId){
		return entities.get(entityId);
	}
}