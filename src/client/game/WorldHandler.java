package client.game;

import java.awt.Graphics2D;

import client.assets.Assets;

public class WorldHandler {

	private static int currentWorld;
	
	private static World[] worlds;
	
	public static void init(){
		
		worlds = new World[4];
		
		worlds[1] = new World("Skyline", Assets.skylineBackground);
	}
	
	public static int getCurrentWorld(){
		return currentWorld;
	}
	
	public static void setWorld(int world){
		
		currentWorld = world;
	}
	
	public static void render(Graphics2D g){
		worlds[currentWorld].render(g);
	}
}
