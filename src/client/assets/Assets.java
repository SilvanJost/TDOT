package client.assets;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import client.utils.Animation;

public class Assets {

	private static ImageLoader loader;
	
	public static BufferedImage player, skylineBackground, menuBackground, menuTitle, skylineGroundStage, skylineHeavenStage;

	public static BufferedImage appiRun0, appiRun1, appiRun2, appiRun3, appiRun4, appiRun5;
	public static BufferedImage appiIdle0, appiIdle1;
	public static BufferedImage appiJump0, appiJump1, appiJump2;
	public static BufferedImage appiPunch0, appiPunch1;

	public static Animation appiRun;
	public static Animation appiIdle;
	public static Animation appiJump;
	public static Animation appiPunch;
	
	public static ImageIcon cardAppli, cardSystemer, cardBetriebler;
	
	public static void init(){
		
		loader = new ImageLoader();
		
		player = loader.loadImage("player.png");
		
		//START skyline map
		
		skylineBackground = loader.loadImage("skylineBackground.png");
		
		skylineGroundStage = loader.loadImage("GroundStageGross.png");
		
		skylineHeavenStage = loader.loadImage("HeavenStageGross.png");
		
		//END skyline map
		
		//START APPI
		
		appiRun0 = loader.loadImage("Appi_Run_0.png");
		appiRun1 = loader.loadImage("Appi_Run_1.png");
		appiRun2 = loader.loadImage("Appi_Run_2.png");
		appiRun3 = loader.loadImage("Appi_Run_3.png");
		appiRun4 = loader.loadImage("Appi_Run_4.png");
		appiRun5 = loader.loadImage("Appi_Run_5.png");
		
		BufferedImage[] runImages = new BufferedImage[6];
		runImages[0] = appiRun0;
		runImages[1] = appiRun1;
		runImages[2] = appiRun2;
		runImages[3] = appiRun3;
		runImages[4] = appiRun4;
		runImages[5] = appiRun5;
		
		appiRun = new Animation(runImages, 0.7F, 75, 150);
		
		appiIdle0 = loader.loadImage("Appi_Idle_0.png");
		appiIdle1 = loader.loadImage("Appi_Idle_1.png");
		
		BufferedImage[] idleImages = new BufferedImage[2];
		idleImages[0] = appiIdle0;
		idleImages[1] = appiIdle1;
		
		appiIdle = new Animation(idleImages, 0.5F, 75, 150);
		
		
		appiJump0 = loader.loadImage("Appi_Jump_0.png");
		appiJump1 = loader.loadImage("Appi_Jump_1.png");
		appiJump2 = loader.loadImage("Appi_Jump_2.png");
		
		BufferedImage[] jumpImages = new BufferedImage[3];
		jumpImages[0] = appiJump0;
		jumpImages[1] = appiJump1;
		jumpImages[2] = appiJump2;
		
		appiJump = new Animation(jumpImages, 0.5F, 75, 150);
		appiJump.setUntilFinished(true);
		appiJump.setStayAtLast(true);
		
		appiPunch0 = loader.loadImage("Appi_Punch_0.png");
		appiPunch1 = loader.loadImage("Appi_Punch_1.png");
		
		BufferedImage[] punchImages = new BufferedImage[2];
		punchImages[0] = appiPunch0;
		punchImages[1] = appiPunch1;
		
		appiPunch = new Animation(punchImages, 0.15F, 75, 100);
		appiPunch.setUntilFinished(true);
		//END APPI
	}
	
}
