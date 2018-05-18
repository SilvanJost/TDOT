package client.assets;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Assets {

	private static ImageLoader loader;
	
	public static BufferedImage player, skylineBackground, menuBackground, menuTitle;
	
	public static ImageIcon cardAppli, cardSystemer, cardBetriebler;
	
	public static void init(){
		
		loader = new ImageLoader();
		
		player = loader.loadImage("player.png");
		
		//START skyline map
		
		skylineBackground = loader.loadImage("skylineBackground.png");
		
		//END skyline map
	}
}
