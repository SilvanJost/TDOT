package server.utils;

public class Side {

	public static final int SERVER = 0;
	public static final int CLIENT = 1;
	
	private static int currentSide = CLIENT;
	
	public static int getCurrentSite(){
		return currentSide;
	}
}
