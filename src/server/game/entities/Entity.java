package server.game.entities;

import java.util.List;

import server.geometrics.Collider;
import server.geometrics.Hitbox;
import server.main.Game;
import server.utils.Vector2;
import server.utils.Vector2f;

public class Entity {
	
	protected static final int LEFT = 0;
	protected static final int RIGHT = 1;
	
	protected int direction = LEFT;
	
	private Vector2f position;
	
	private Vector2f movement;
	
	private Hitbox hitbox;
	
	private boolean inAir = true;
	private boolean doubleJump = true;
	
	public Entity(){
		
		position = new Vector2f(0,0);
		movement = new Vector2f(0,0);
		
		hitbox = new Hitbox(this, 75, 150, new Vector2(0, 0));
	}
	
	public void tick(List<Entity> entities){

		boolean hasCollided = false;
		
		if(movement.getY() <= Game.FALLING_CAP){
			
			movement.setY(movement.getY() + Game.GRAVITY.getY());
			
			if(movement.getY() > Game.FALLING_CAP){
				movement.setY(Game.FALLING_CAP);
			}
		}
		
		//Move X
		
		position.setX(position.getX() + movement.getX());
		
		for(Entity e : entities){
			if(Collider.getCollision(hitbox, e.getHitbox())){
				hasCollided = true;
				
			}
		}
		
		if(hasCollided){
			position.setX(position.getX() - movement.getX());
		}
		
		//Move Y
		
		hasCollided = false;
		
		position.setY(position.getY() + movement.getY());
		
		for(Entity e : entities){
			if(Collider.getCollision(hitbox, e.getHitbox())){
				hasCollided = true;
				
				if(e.getPosition().getY() > this.position.getY()){
					
					float difference = e.getPosition().getY() - this.position.getY() - hitbox.getHeight() - hitbox.getOffset().getY();
					this.position.setY(this.position.getY()+difference);
					hasCollided = false;
					
					inAir = false;
					doubleJump = true;
					
				}else{
					
					float difference = e.getPosition().getY() + e.getHitbox().getHeight() - (this.getPosition().getY() + hitbox.getOffset().getY());
					this.position.setY(this.position.getY()+difference);
					hasCollided = false;
				}
			}
		}
		
		if(hasCollided){
			position.setY(position.getY() - movement.getY());
		}
	}
	
	public void jump(){
		if(inAir){
			if(doubleJump){
				
				movement.setY(-25);
				
				doubleJump = false;
			}
		}else{
			
			movement.setY(-20);
			
			inAir = true;
		}
	}
	
	public void move(float value){
		
		movement.setX(value);
	}
	
	public Vector2f getPosition(){
		return this.position;
	}
	
	public Hitbox getHitbox(){
		return this.hitbox;
	}
	
	public void setPosition(Vector2f position){
		this.position = position;
	}
	
	public void setMovementX(int value){
		this.movement.setX(value);
	}
	
	public void setMovementY(int value){
		this.movement.setY(value);
	}

    public void setHitbox(Hitbox hitbox) {
        this.hitbox = hitbox;
    }
}
