package client.utils;

public class Side {

	public static final int SERVER = 0;
	public static final int CLIENT = 1;
	
	private static int currentSide = SERVER;
	
	public static int getCurrentSite(){
		return currentSide;
	}
}
