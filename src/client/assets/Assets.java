package client.assets;

import java.awt.image.BufferedImage;

import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

import client.utils.Animation;

public class Assets {

	private static ImageLoader imageLoader;
	private static SoundLoader soundLoader;
	
	public static BufferedImage player, skylineBackground, menuBackground, menuTitle, skylineGroundStage, skylineHeavenStage, bueno;

	
	//APPI
	
	public static BufferedImage keyboard;
	public static BufferedImage appiRun0, appiRun1, appiRun2, appiRun3, appiRun4, appiRun5;
	public static BufferedImage appiIdle0, appiIdle1;
	public static BufferedImage appiJump0, appiJump1, appiJump2;
	public static BufferedImage appiPunch0, appiPunch1;
	public static BufferedImage appiSpecial0, appiSpecial1;
	public static BufferedImage appiBeam0, appiBeam1, appiBeam2, appiBeam3, appiBeam4, appiBeam5, appiBeam6, appiBeam7, appiBeam8, appiBeam9;

	public static Animation appiRun;
	public static Animation appiIdle;
	public static Animation appiJump;
	public static Animation appiPunch;
	public static Animation appiSuper;
	public static Animation appiBeam;
	
	
	// BETRIEBLER
	
	public static BufferedImage phone;
	public static BufferedImage betriebRun0, betriebRun1, betriebRun2, betriebRun3, betriebRun4, betriebRun5;
	public static BufferedImage betriebIdle0, betriebIdle1;
	public static BufferedImage betriebJump0, betriebJump1, betriebJump2;
	public static BufferedImage betriebPunch0, betriebPunch1;
	public static BufferedImage betriebSpecial0, betriebSpecial1;
	public static BufferedImage betriebTicket;
	
	public static Animation betriebRun;
	public static Animation betriebIdle;
	public static Animation betriebJump;
	public static Animation betriebPunch;
	public static Animation betriebSuper;
	
	//Systemer
	public static BufferedImage pc;
	public static BufferedImage sysRun0, sysRun1, sysRun2, sysRun3, sysRun4, sysRun5;
	public static BufferedImage sysIdle0, sysIdle1;
	public static BufferedImage sysJump0, sysJump1, sysJump2;
	public static BufferedImage sysPunch0, sysPunch1;
	public static BufferedImage sysSpecial0, sysSpecial1;
	public static BufferedImage sysTicket;
	
	public static Animation sysRun;
	public static Animation sysIdle;
	public static Animation sysJump;
	public static Animation sysPunch;
	public static Animation sysSuper;
	
	//GUI
	
	private static BufferedImage cardAppiImage, cardSystemerImage, cardBetrieblerImage;
	public static ImageIcon cardAppi, cardSystemer, cardBetriebler;
	
	
	//SOUNDS
	
	public static Clip jumpSound;
	
	
	
	
	public static void init(){
		
		imageLoader = new ImageLoader();
		
		player = imageLoader.loadImage("player.png");
		
		bueno = imageLoader.loadImage("bueno.png");
		
		//START GUI-----------------------------------------------------------------------------
		
		cardAppiImage = imageLoader.loadImage("CardAppi.png");
		cardSystemerImage = imageLoader.loadImage("CardSys.png");
		cardBetrieblerImage = imageLoader.loadImage("CardBetrieb.png");
		
		cardAppi = new ImageIcon(cardAppiImage);
		cardSystemer = new ImageIcon(cardSystemerImage);
		cardBetriebler = new ImageIcon(cardBetrieblerImage);
		
		//END GUI--------------------------------------------------------------------------------
		
		//START skyline map----------------------------------------------------------------------
		
		skylineBackground = imageLoader.loadImage("skylineBackground.png");
		
		skylineGroundStage = imageLoader.loadImage("GroundStageGross.png");
		
		skylineHeavenStage = imageLoader.loadImage("HeavenStageGross.png");
		
		//END skyline map-------------------------------------------------------------------------
		
		
		//START APPI------------------------------------------------------------------------------
		
		keyboard = imageLoader.loadImage("Keyboard.png");
		
		appiRun0 = imageLoader.loadImage("Appi_Run_0.png");
		appiRun1 = imageLoader.loadImage("Appi_Run_1.png");
		appiRun2 = imageLoader.loadImage("Appi_Run_2.png");
		appiRun3 = imageLoader.loadImage("Appi_Run_3.png");
		appiRun4 = imageLoader.loadImage("Appi_Run_4.png");
		appiRun5 = imageLoader.loadImage("Appi_Run_5.png");
		
		BufferedImage[] appiRunImages = new BufferedImage[6];
		appiRunImages[0] = appiRun0;
		appiRunImages[1] = appiRun1;
		appiRunImages[2] = appiRun2;
		appiRunImages[3] = appiRun3;
		appiRunImages[4] = appiRun4;
		appiRunImages[5] = appiRun5;
		
		appiRun = new Animation(appiRunImages, 0.7F, 75, 150);
		
		appiIdle0 = imageLoader.loadImage("Appi_Idle_0.png");
		appiIdle1 = imageLoader.loadImage("Appi_Idle_1.png");
		
		BufferedImage[] appiIdleImages = new BufferedImage[2];
		appiIdleImages[0] = appiIdle0;
		appiIdleImages[1] = appiIdle1;
		
		appiIdle = new Animation(appiIdleImages, 0.5F, 75, 150);
		
		appiJump0 = imageLoader.loadImage("Appi_Jump_0.png");
		appiJump1 = imageLoader.loadImage("Appi_Jump_1.png");
		appiJump2 = imageLoader.loadImage("Appi_Jump_2.png");
		
		BufferedImage[] appiJumpImages = new BufferedImage[3];
		appiJumpImages[0] = appiJump0;
		appiJumpImages[1] = appiJump1;
		appiJumpImages[2] = appiJump2;
		
		appiJump = new Animation(appiJumpImages, 0.5F, 75, 150);
		appiJump.setUntilFinished(true);
		appiJump.setStayAtLast(true);
		
		appiPunch0 = imageLoader.loadImage("Appi_Punch_0.png");
		appiPunch1 = imageLoader.loadImage("Appi_Punch_1.png");
		
		BufferedImage[] appiPunchImages = new BufferedImage[2];
		appiPunchImages[0] = appiPunch0;
		appiPunchImages[1] = appiPunch1;
		
		appiPunch = new Animation(appiPunchImages, 0.15F, 75, 100);
		appiPunch.setUntilFinished(true);
		
		appiSpecial0 = imageLoader.loadImage("Appi_Special_0.png");
		appiSpecial1 = imageLoader.loadImage("Appi_Special_1.png");
		
		BufferedImage[] appiSpecialImages = new BufferedImage[2];
		appiSpecialImages[0] = appiSpecial0;
		appiSpecialImages[1] = appiSpecial1;
		
		appiSuper = new Animation(appiSpecialImages, 1.5F, 75, 150);
		appiSuper.setStayAtLast(true);
		
		appiBeam0 = imageLoader.loadImage("Appi_Beam_0.png");
		appiBeam1 = imageLoader.loadImage("Appi_Beam_1.png");
		appiBeam2 = imageLoader.loadImage("Appi_Beam_2.png");
		appiBeam3 = imageLoader.loadImage("Appi_Beam_3.png");
		appiBeam4 = imageLoader.loadImage("Appi_Beam_4.png");
		appiBeam5 = imageLoader.loadImage("Appi_Beam_5.png");
		appiBeam6 = imageLoader.loadImage("Appi_Beam_6.png");
		appiBeam7 = imageLoader.loadImage("Appi_Beam_7.png");
		appiBeam8 = imageLoader.loadImage("Appi_Beam_8.png");
		appiBeam9 = imageLoader.loadImage("Appi_Beam_9.png");
		
		BufferedImage[] appiBeamImages = new BufferedImage[10];
		appiBeamImages[0] = appiBeam0;
		appiBeamImages[1] = appiBeam1;
		appiBeamImages[2] = appiBeam2;
		appiBeamImages[3] = appiBeam3;
		appiBeamImages[4] = appiBeam4;
		appiBeamImages[5] = appiBeam5;
		appiBeamImages[6] = appiBeam6;
		appiBeamImages[7] = appiBeam7;
		appiBeamImages[8] = appiBeam8;
		appiBeamImages[9] = appiBeam9;
		
		appiBeam = new Animation(appiBeamImages, 1.5F, 2000, 75);
		
		//END APPI-----------------------------------------------------------------------
		
		//START BETRIEBLER---------------------------------------------------------------
		
		phone = imageLoader.loadImage("Phone.png");
		
		betriebRun0 = imageLoader.loadImage("Betr_Run_0.png");
		betriebRun1 = imageLoader.loadImage("Betr_Run_1.png");
		betriebRun2 = imageLoader.loadImage("Betr_Run_2.png");
		betriebRun3 = imageLoader.loadImage("Betr_Run_3.png");
		betriebRun4 = imageLoader.loadImage("Betr_Run_4.png");
		betriebRun5 = imageLoader.loadImage("Betr_Run_5.png");
		
		BufferedImage[] betriebRunImages = new BufferedImage[6];
		betriebRunImages[0] = betriebRun0;
		betriebRunImages[1] = betriebRun1;
		betriebRunImages[2] = betriebRun2;
		betriebRunImages[3] = betriebRun3;
		betriebRunImages[4] = betriebRun4;
		betriebRunImages[5] = betriebRun5;
		
		betriebRun = new Animation(betriebRunImages, 0.7F, 75, 150);
		
		betriebIdle0 = imageLoader.loadImage("Betr_Idle_0.png");
		betriebIdle1 = imageLoader.loadImage("Betr_Idle_1.png");
		
		BufferedImage[] betriebIdleImages = new BufferedImage[2];
		betriebIdleImages[0] = betriebIdle0;
		betriebIdleImages[1] = betriebIdle1;
		
		betriebIdle = new Animation(betriebIdleImages, 0.5F, 75, 150);
		
		betriebJump0 = imageLoader.loadImage("Betr_Jump_0.png");
		betriebJump1 = imageLoader.loadImage("Betr_Jump_1.png");
		betriebJump2 = imageLoader.loadImage("Betr_Jump_2.png");
		
		BufferedImage[] betriebJumpImages = new BufferedImage[3];
		betriebJumpImages[0] = betriebJump0;
		betriebJumpImages[1] = betriebJump1;
		betriebJumpImages[2] = betriebJump2;
		
		betriebJump = new Animation(betriebJumpImages, 0.5F, 75, 150);
		betriebJump.setUntilFinished(true);
		betriebJump.setStayAtLast(true);
		
		betriebPunch0 = imageLoader.loadImage("Betr_Punch_0.png");
		betriebPunch1 = imageLoader.loadImage("Betr_Punch_1.png");
		
		BufferedImage[] betriebPunchImages = new BufferedImage[2];
		betriebPunchImages[0] = betriebPunch0;
		betriebPunchImages[1] = betriebPunch1;
		
		betriebPunch = new Animation(betriebPunchImages, 0.15F, 75, 100);
		betriebPunch.setUntilFinished(true);
		
		betriebSpecial0 = imageLoader.loadImage("Betr_Special_0.png");
		betriebSpecial1 = imageLoader.loadImage("Betr_Special_1.png");
		
		BufferedImage[] betriebSpecialImages = new BufferedImage[2];
		betriebSpecialImages[0] = betriebSpecial0;
		betriebSpecialImages[1] = betriebSpecial1;
		
		betriebSuper = new Animation(betriebSpecialImages, 1.5F, 75, 150);
		betriebSuper.setStayAtLast(true);
		
		//END BETRIEBLER-----------------------------------------------------------------
		
		//START SYSTEMER-----------------------------------------------------------------
		pc = imageLoader.loadImage("Desktop.png");
		
		sysRun0 = imageLoader.loadImage("Sys_Run_0.png");
		sysRun1 = imageLoader.loadImage("Sys_Run_1.png");
		sysRun2 = imageLoader.loadImage("Sys_Run_2.png");
		sysRun3 = imageLoader.loadImage("Sys_Run_3.png");
		sysRun4 = imageLoader.loadImage("Sys_Run_4.png");
		sysRun5 = imageLoader.loadImage("Sys_Run_5.png");
		
		BufferedImage[] sysRunImages = new BufferedImage[6];
		sysRunImages[0] = sysRun0;
		sysRunImages[1] = sysRun1;
		sysRunImages[2] = sysRun2;
		sysRunImages[3] = sysRun3;
		sysRunImages[4] = sysRun4;
		sysRunImages[5] = sysRun5;
		
		sysRun = new Animation(sysRunImages, 0.7F, 75, 150);
		
		sysIdle0 = imageLoader.loadImage("Sys_Idle_0.png");
		sysIdle1 = imageLoader.loadImage("Sys_Idle_1.png");
		
		BufferedImage[] sysIdleImages = new BufferedImage[2];
		sysIdleImages[0] = sysIdle0;
		sysIdleImages[1] = sysIdle1;
		
		sysIdle = new Animation(sysIdleImages, 0.5F, 75, 150);
		
		sysJump0 = imageLoader.loadImage("Sys_Jump_0.png");
		sysJump1 = imageLoader.loadImage("Sys_Jump_1.png");
		sysJump2 = imageLoader.loadImage("Sys_Jump_2.png");
		
		BufferedImage[] sysJumpImages = new BufferedImage[3];
		sysJumpImages[0] = sysJump0;
		sysJumpImages[1] = sysJump1;
		sysJumpImages[2] = sysJump2;
		
		sysJump = new Animation(sysJumpImages, 0.5F, 75, 150);
		sysJump.setUntilFinished(true);
		sysJump.setStayAtLast(true);
		
		sysPunch0 = imageLoader.loadImage("Sys_Punch_0.png");
		sysPunch1 = imageLoader.loadImage("Sys_Punch_1.png");
		
		BufferedImage[] sysPunchImages = new BufferedImage[2];
		sysPunchImages[0] = sysPunch0;
		sysPunchImages[1] = sysPunch1;
		
		sysPunch = new Animation(sysPunchImages, 0.15F, 75, 100);
		sysPunch.setUntilFinished(true);
		
		sysSpecial0 = imageLoader.loadImage("Sys_Special_0.png");
		sysSpecial1 = imageLoader.loadImage("Sys_Special_1.png");
		
		BufferedImage[] sysSpecialImages = new BufferedImage[2];
		sysSpecialImages[0] = sysSpecial0;
		sysSpecialImages[1] = sysSpecial1;
		
		sysSuper = new Animation(sysSpecialImages, 1.5F, 75, 150);
		sysSuper.setStayAtLast(true);
		//END SYSTEMER-------------------------------------------------------------------
		/*START SOUNDS
		
		jumpSound = soundLoader.loadSound("jump.mp3");
		
		END SOUNDS*/
	}
	
}
