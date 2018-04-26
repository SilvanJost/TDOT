package server.game.entities;

import server.utils.Vector2;

public class Entity {

	private int health;
	private Vector2 position;
	
	public Entity(){
		
		position = new Vector2(0, 200);
	}
	
	public Vector2 getPosition(){
		return this.position;
	}
	
	public void setPosition(Vector2 position){
		this.position = position;
	}
}
