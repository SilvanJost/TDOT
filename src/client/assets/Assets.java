package client.assets;

import java.awt.image.BufferedImage;

import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

import client.utils.Animation;

public class Assets {

	private static ImageLoader imageLoader;
	private static SoundLoader soundimageLoader;
	
	public static BufferedImage player, skylineBackground, menuBackground, menuTitle, skylineGroundStage, skylineHeavenStage, bueno;

	public static BufferedImage keyboard;
	public static BufferedImage appiRun0, appiRun1, appiRun2, appiRun3, appiRun4, appiRun5;
	public static BufferedImage appiIdle0, appiIdle1;
	public static BufferedImage appiJump0, appiJump1, appiJump2;
	public static BufferedImage appiPunch0, appiPunch1;
	public static BufferedImage appiBeam0, appiBeam1, appiBeam2, appiBeam3, appiBeam4, appiBeam5, appiBeam6, appiBeam7, appiBeam8, appiBeam9;

	public static Animation appiRun;
	public static Animation appiIdle;
	public static Animation appiJump;
	public static Animation appiPunch;
	public static Animation appiSuper;
	public static Animation appiBeam;
	
	public static ImageIcon cardAppli, cardSystemer, cardBetriebler;
	
	public static Clip jumpSound;
	
	public static void init(){
		
		imageLoader = new ImageLoader();
		
		player = imageLoader.loadImage("player.png");
		
		bueno = imageLoader.loadImage("bueno.png");
		
		//START skyline map
		
		skylineBackground = imageLoader.loadImage("skylineBackground.png");
		
		skylineGroundStage = imageLoader.loadImage("GroundStageGross.png");
		
		skylineHeavenStage = imageLoader.loadImage("HeavenStageGross.png");
		
		//END skyline map
		
		//START APPI
		
		keyboard = imageLoader.loadImage("Keyboard.png");
		
		appiRun0 = imageLoader.loadImage("Appi_Run_0.png");
		appiRun1 = imageLoader.loadImage("Appi_Run_1.png");
		appiRun2 = imageLoader.loadImage("Appi_Run_2.png");
		appiRun3 = imageLoader.loadImage("Appi_Run_3.png");
		appiRun4 = imageLoader.loadImage("Appi_Run_4.png");
		appiRun5 = imageLoader.loadImage("Appi_Run_5.png");
		
		BufferedImage[] runImages = new BufferedImage[6];
		runImages[0] = appiRun0;
		runImages[1] = appiRun1;
		runImages[2] = appiRun2;
		runImages[3] = appiRun3;
		runImages[4] = appiRun4;
		runImages[5] = appiRun5;
		
		appiRun = new Animation(runImages, 0.7F, 75, 150);
		
		appiIdle0 = imageLoader.loadImage("Appi_Idle_0.png");
		appiIdle1 = imageLoader.loadImage("Appi_Idle_1.png");
		
		BufferedImage[] idleImages = new BufferedImage[2];
		idleImages[0] = appiIdle0;
		idleImages[1] = appiIdle1;
		
		appiIdle = new Animation(idleImages, 0.5F, 75, 150);
		
		appiJump0 = imageLoader.loadImage("Appi_Jump_0.png");
		appiJump1 = imageLoader.loadImage("Appi_Jump_1.png");
		appiJump2 = imageLoader.loadImage("Appi_Jump_2.png");
		
		BufferedImage[] jumpImages = new BufferedImage[3];
		jumpImages[0] = appiJump0;
		jumpImages[1] = appiJump1;
		jumpImages[2] = appiJump2;
		
		appiJump = new Animation(jumpImages, 0.5F, 75, 150);
		appiJump.setUntilFinished(true);
		appiJump.setStayAtLast(true);
		
		appiPunch0 = imageLoader.loadImage("Appi_Punch_0.png");
		appiPunch1 = imageLoader.loadImage("Appi_Punch_1.png");
		
		BufferedImage[] punchImages = new BufferedImage[2];
		punchImages[0] = appiPunch0;
		punchImages[1] = appiPunch1;
		
		appiPunch = new Animation(punchImages, 0.15F, 75, 100);
		appiPunch.setUntilFinished(true);
		//END APPI
	}
	
}
