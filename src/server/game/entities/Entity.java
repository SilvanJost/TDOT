package server.game.entities;

import server.geometrics.Hitbox;
import server.utils.Vector2;

public class Entity {

	private Vector2 position;
	
	private Hitbox hitbox;
	
	public Entity(Hitbox hitbox){
		
		this.hitbox = hitbox;
		position = new Vector2(0,0);
	}
	
	public Entity(){
		position = new Vector2(0,0);
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
}
