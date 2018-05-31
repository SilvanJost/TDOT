package client.entities;

import java.awt.Graphics2D;

import client.assets.Assets;
import client.utils.Animation;

public class Betriebler extends Player{

	
	private Animation beamAnimation = Assets.appiBeam;
	
	public Betriebler(int xPosition, int yPosition) {
		super(xPosition, yPosition);

		idle = Assets.betriebIdle;
	    run = Assets.betriebRun;
	    jump = Assets.betriebJump;
	    punch = Assets.betriebPunch;
	    superCast = Assets.betriebSuper;
	}

	@Override
	public void tickAbilities() {
		
		beamAnimation.tick();
		
	}

	@Override
	public void renderAbilities(Graphics2D g) {

		
	}

	@Override
	public void castSuper() {

		this.currentAnimation = superCast;
		currentAnimation.run();
		
	}

}
