package client.entities;

import java.awt.Graphics2D;

import client.assets.Assets;
import client.utils.Animation;

public class Appli extends Player{

	
	private Animation beamAnimation = Assets.appiBeam;
	
	public Appli(int xPosition, int yPosition) {
		super(xPosition, yPosition);

		idle = Assets.appiIdle;
	    run = Assets.appiRun;
	    jump = Assets.appiJump;
	    punch = Assets.appiPunch;
	    superCast = Assets.appiSuper;
	}

	@Override
	public void tickAbilities() {
		
		beamAnimation.tick();
		
	}

	@Override
	public void renderAbilities(Graphics2D g) {

		if(beamAnimation.isActive()){
			if(direction == RIGHT){
				g.drawImage(beamAnimation.getFrame(), beamAnimation.getX(), beamAnimation.getY(), beamAnimation.getWidth(), beamAnimation.getHeight(), null);
			}else{
				g.drawImage(beamAnimation.getFrame(), beamAnimation.getX() + beamAnimation.getWidth(), beamAnimation.getY(), -beamAnimation.getWidth(), beamAnimation.getHeight(), null);
			}
		}
	}

	@Override
	public void castSuper() {

		this.currentAnimation = superCast;
		currentAnimation.run();
		
		beamAnimation.run();
		
		beamAnimation.setX(position.getX());
		beamAnimation.setY(position.getY());
	}

}
