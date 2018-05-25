package server.game.entities;

import java.util.List;

import server.geometrics.Collider;
import server.geometrics.Hitbox;
import server.main.Game;
import server.utils.Vector2f;

public class Projectile{

	private int damage;
	private Vector2f movement;
	private Vector2f position;
	
	private boolean active = false;
	
	private Hitbox hitbox;
	
	public Projectile(int damage, int speed){
		
	}
	
	public void toss(Player player){
		
		this.position = new Vector2f(player.getPosition().getX(), player.getPosition().getY());
		
		if(player.direction == player.LEFT){
			this.movement = new Vector2f(-player.speed, -2);
		}else{
			this.movement = new Vector2f(player.speed, -2);
		}
		
		create();
	}
	
	private void create(){
		active = true;
		//TODO send Packet
	}
	
	private void destroy(){
		active = false;
		//TODO send Packet
	}
	
	public void tick(List<Entity> entities, List<Player> players){
		
		if(active){
			
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
				destroy();
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
						
						
					}else{
						
						float difference = e.getPosition().getY() + e.getHitbox().getHeight() - (this.position.getY() + hitbox.getOffset().getY());
						this.position.setY(this.position.getY()+difference);
						hasCollided = false;
					}
				}
			}
			
			if(hasCollided){
				destroy();
			}
		}
	}
}
