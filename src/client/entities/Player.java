package client.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import client.assets.Assets;
import client.utils.Animation;

public abstract class Player extends Entity{

    private static final int HEIGHT = 150;
    private static final int WIDTH = 75;
    
    public static final int IDLE = 1;
    public static final int RUN = 2;
    public static final int JUMP = 3;
    public static final int PUNCH = 4;
    public static final int PULL = 5;
    public static final int TOSS = 6;
    public static final int SUPER_CAST = 7;
    
    private String username;

	private float maxHealth = 150;
    private float health = 60;
    
    protected Animation idle = Assets.appiIdle;
    protected Animation run;
    protected Animation jump;
    protected Animation punch;
    protected Animation toss;
    protected Animation superCast;
    
    protected Animation currentAnimation = run;
    
	public Player(int xPosition, int yPosition) {
		super(Assets.player,WIDTH,HEIGHT,xPosition,yPosition);
		
		currentAnimation = idle;

	}
	
	public abstract void tickAbilities();
	
	public abstract void renderAbilities(Graphics2D g);
	
	
	public abstract void castSuper();
	
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
		
		currentAnimation.setX(position.getX());
		currentAnimation.setY(position.getY());
		
		this.sprite = currentAnimation.getFrame();
	}
	
	@Override
	public void render(Graphics2D g){
		
		// DRAW PLAYER ---------------------------------------------------------------------------------------------
		
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
		
		// DRAW HEALTHBAR --------------------------------------------------------------------------------------------
		
		g.setColor(Color.RED);
		g.fillRect(this.position.getX()-20, this.position.getY()-50, 150, 5);
		
		g.setColor(Color.GREEN);
		g.fillRect(this.position.getX()-20, this.position.getY()-50, (int) (health / maxHealth * 150F), 5);
		
		// DRAW USERNAME ----------------------------------------------------------------------------------------------
		
		g.setColor(Color.WHITE);
		if(username != null){
			
		}
		g.drawString(username, position.getX(), position.getY() + 100);
	}
	
	public void punch(){
		this.currentAnimation = punch;
		currentAnimation.run();
	};
	
	public void setHealth(int health){
		this.health = health;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
}
