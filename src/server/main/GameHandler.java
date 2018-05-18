package server.main;

import java.util.ArrayList;
import java.util.List;

import client.entities.Player;
import client.gui.DisplayManager;
import server.net.Connection;

public class GameHandler {

	public static final int MAX_GAMES = 3;
	
	private static boolean running;
	
	private static List<Game> games = new ArrayList<Game>();
	
	public GameHandler(){
		
	}
	
	/**
	 * Adds the connected person to a existing game or creates a new one if no slots are aviable
	 * @param conn - the connection that joins
	 */
	public static synchronized void join(Connection conn){
		
		
		for(int i=0;i < games.size();i++){
			
			if(games.get(i).getPlayerCount() < Game.MAX_PLAYERS){
				
				games.get(i).join(conn);
				games.get(i).addPlayer();
				return;
			}
		}
		
		if(games.size() < MAX_GAMES){
			
			Game game = new Game();
			game.join(conn);
			game.addPlayer();
			
			games.add(game);
			
			System.out.println("Created new Game");
		}
	}
	
	public static synchronized void tick(){
		
		for(Game game : games){
			game.tick();
		}
	}
	
	public static synchronized void update(){
		
		for(Game game : games){
			game.update();
		}
	}
	
	public void stop(){
		running = false;
	}
	
	public Game getGame(int id){
		return games.get(id);
	}
}
