package client.assets;

import java.awt.image.BufferedImage;

public class Assets {

	private static ImageLoader loader;
	
	public static BufferedImage player, skylineBackground;
	
	public static void init(){
		
		loader = new ImageLoader();
		
		player = loader.loadImage("player.png");
		
		//START skyline map
		
		skylineBackground = loader.loadImage("skylineBackground.png");
		
		//END skyline map
	}
}
