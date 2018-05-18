package server.game.entities;

import java.util.List;

import server.geometrics.Collider;
import server.geometrics.Hitbox;
import server.main.Game;
import server.utils.Vector2;

public class Entity {
	
	private Vector2 position;
	
	private Vector2 movement;
	
	private Hitbox hitbox;
	
	public Entity(){
		
		position = new Vector2(0,0);
	}
	
	public void tick(List<Entity> entities){
		
		boolean hasCollided = false;
		
		if(movement.getY() >= Game.GRAVITY.getY()){
			movement.setY(movement.getY() - Game.GRAVITY.getY());
			
			if(movement.getY() < Game.GRAVITY.getY()){
				movement.setY(Game.GRAVITY.getY());
			}
		}
		
		for(Entity e : entities){
			if(Collider.getCollision(hitbox, e.getHitbox())){
				hasCollided = true;
			}
		}
		
		if(hasCollided){
			position.sub(movement);
		}
	}
	
	public Vector2 getPosition(){
		return this.position;
	}
	
	public Hitbox getHitbox(){
		return this.hitbox;
	}
	
	public void setPosition(Vector2 position){
		this.position = position;
	}
	
	public void setMovement(Vector2 movement){
		this.movement = movement;
	}

    public void setHitbox(Hitbox hitbox) {
        this.hitbox = hitbox;
    }
	
	
}
