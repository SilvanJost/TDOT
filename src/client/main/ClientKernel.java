package client.main;

import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import client.assets.Assets;
import client.entities.Player;
import client.game.WorldHandler;
import client.gui.DisplayManager;
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
	
	public static final int CHAR_APPLI = 0;
	public static final int CHAR_SYSTEMER = 1;
	public static final int CHAR_BETRIEBLER = 2;
	
	public static final Vector2 RESOLUTION = new Vector2(1920, 1080);
	
	private static int state = MENU_STATE;
	
	private static ClientSocket socket;
	
	private BufferStrategy bs;
	private Graphics2D g;
	
	private InputHandler inputHandler;
	
	private static List<Player> players = new ArrayList<Player>();
	
	private boolean running;
	
	private static final int FPS = 60;
	
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
		
		inputHandler = new InputHandler();
		
		socket = new ClientSocket();
		socket.connect("localhost", 8888);
		
		socket.listen();
		
		
		float duration = 1000 / FPS;
		float delta = 0;
		
		double last = System.currentTimeMillis();
		double now;
		
		DisplayManager.createDisplay(new Vector2(1920, 1080));
		DisplayManager.addKeyListener(inputHandler);
		
		while(running){
			
			now = System.currentTimeMillis();
			
			delta += now - last;
			
			if(delta >= duration){
				
				tick();
				render();
				
				delta = 0;
			}
		}
		
		stop();
	}
	
	public void tick(){
		for(Player player : players){
			player.tick();
		}
	}
	
	/*
	 * Central render loop
	 * 
	 * Creates a BufferStrategy and draws everything to the screen with its Graphics object
	 */
	public void render(){
		if(bs == null){
			DisplayManager.getCanvas().createBufferStrategy(2);
			bs = DisplayManager.getCanvas().getBufferStrategy();
			
		}
		
		g = (Graphics2D) bs.getDrawGraphics();

		DisplayManager.clearDisplay(g);
		
		if(WorldHandler.getCurrentWorld() != 0){
			WorldHandler.render(g);
		}
		
		for(Player player : players){
			player.render(g);
		}
		
		bs.show();
	}
	/*
	 * Stops the program and cleans up
	 */
	public void stop(){
		
		DisplayManager.destroyDispaly();
	}
	
	public static void selectCharacter(int character){
		
		if(state == SELECTION_STATE){
			
			Packet packet = PacketHandler.buildPacket(PacketHandler.PACKET_SELECT_CHARACTER, null, character+"");
			socket.send(packet);
		}
	}
	
	public static void joinGame(){
		
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
	
	public static void setState(int s){
		
		state = s;
	}
}