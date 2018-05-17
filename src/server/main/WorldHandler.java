package server.main;

import java.util.Random;

public class WorldHandler {

	private static final int worlds = 1;
	
	public static final int SKYLINE = 0;
	public static final int BEACH = 1;
	
	public static int getRandom(){
		
		Random random = new Random();
		
		return random.nextInt(worlds);
	}
}
