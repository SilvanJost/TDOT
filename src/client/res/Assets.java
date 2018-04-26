package client.res;

import java.awt.image.BufferedImage;

public class Assets {

	private static ImageLoader loader;
	
	public static BufferedImage player;
	
	public static void init(){
		
		loader = new ImageLoader();
		
		player = loader.loadImage("player.png");
	}
}
