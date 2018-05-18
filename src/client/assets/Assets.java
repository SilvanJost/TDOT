package client.assets;

import java.awt.image.BufferedImage;

public class Assets {

	private static ImageLoader loader;
	
	public static BufferedImage player, skylineBackground, skylineGroundStage,skylineHeavenStage;
	
	public static void init(){
		
		loader = new ImageLoader();
		
		player = loader.loadImage("player.png");
		
		//START skyline map
		
		skylineBackground = loader.loadImage("skylineBackground.png");
		
		skylineGroundStage = loader.loadImage("GroundStageGross.png");
		
		skylineHeavenStage = loader.loadImage("HeavenStageGross.png");
		
		//END skyline map
	}
	
}
