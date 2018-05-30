package client.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import client.assets.Assets;
import client.utils.Animation;

public class Player extends Entity{

    private static final int HEIGHT = 150;
    private static final int WIDTH = 75;
    
    public static final int IDLE = 1;
    public static final int RUN = 2;
    public static final int JUMP = 3;
    public static final int PUNCH = 4;
    public static final int PULL = 5;
    public static final int TOSS = 6;
    public static final int SUPER_CAST = 7;
    
    private float maxHealth = 150;
    private float health = 60;
    
    private Animation idle = Assets.appiIdle;
    private Animation run = Assets.appiRun;
    private Animation jump = Assets.appiJump;
    private Animation punch = Assets.appiPunch;
    private Animation toss;
    private Animation superCast = Assets.appiSuper;
    
    private Animation currentAnimation = run;
    
    private Animation beamAnimation = Assets.appiBeam;
    
	public Player(int xPosition, int yPosition) {
		super(Assets.player,WIDTH,HEIGHT,xPosition,yPosition);

	}
	
	@Override
	public void tick(){
		
		if(!currentAnimation.isActive() || currentAnimation.isAtLast()){
			
			if(!currentAnimation.isStayAtLast()){
				currentAnimation = idle;
			}
			
			if(lastPosition.getX() != position.getX()){
				currentAnimation = run;
			}
			
			if(lastPosition.getY() > position.getY()){
				currentAnimation = jump;
			}
			
			if(!currentAnimation.isActive()){
				if(!(currentAnimation.isStayAtLast() && currentAnimation.isAtLast())){
					currentAnimation.run();
				}
			}
		}
		currentAnimation.tick();
		beamAnimation.tick();
		
		currentAnimation.setX(position.getX());
		currentAnimation.setY(position.getY());
		
		this.sprite = currentAnimation.getFrame();
	}
	
	@Override
	public void render(Graphics2D g){
		
		if(lastPosition.getX() > position.getX()){
			
			direction = LEFT;
			
		}
		
		if(lastPosition.getX() < position.getX()){
			direction = RIGHT;
			
		}
		
		if(direction == RIGHT){
			g.drawImage(sprite, position.getX(), position.getY(), width, height, null);
		}else{
			g.drawImage(sprite, position.getX() + width, position.getY(), -width, height, null);
		}
		
		
		if(beamAnimation.isActive()){
			if(direction == RIGHT){
				g.drawImage(beamAnimation.getFrame(), beamAnimation.getX(), beamAnimation.getY(), beamAnimation.getWidth(), beamAnimation.getHeight(), null);
			}else{
				g.drawImage(beamAnimation.getFrame(), beamAnimation.getX() + beamAnimation.getWidth(), beamAnimation.getY(), -beamAnimation.getWidth(), beamAnimation.getHeight(), null);
			}
		}
		
		g.setColor(Color.RED);
		g.fillRect(this.position.getX()-20, this.position.getY()-50, 150, 5);
		
		g.setColor(Color.GREEN);
		g.fillRect(this.position.getX()-20, this.position.getY()-50, (int) (health / maxHealth * 150F), 5);
	}
	
	public void punch(){
		this.currentAnimation = punch;
		currentAnimation.run();
	}
	
	public void castSuper(){
		System.out.println("reeee");
		this.currentAnimation = superCast;
		currentAnimation.run();
		
		beamAnimation.run();
		
		beamAnimation.setX(position.getX());
		beamAnimation.setY(position.getY());
	}
	
	public void setHealth(int health){
		this.health = health;
	}
}
