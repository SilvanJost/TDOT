package server.game.entities;

import java.util.List;

import server.geometrics.Collider;
import server.geometrics.Hitbox;
import server.main.Game;
import server.utils.Vector2;
import server.utils.Vector2f;

public class Projectile extends Entity{

	public static final int PHONE = 1;
	public static final int KEYBOARD = 2;
	public static final int PC = 3;
	
	private int id;
	
	private float damage;
	
	private int pullTime;
	
	private Player player;
	
	private boolean active = false;
	
	private Hitbox hitbox;
	
	public Projectile(int id, int damage, int speed, int width, int height){
		
		this.id = id;
		this.damage = damage;
		this.hitbox = new Hitbox(this, width, height, new Vector2(0, 0));
	}
	
	public void toss(Player player, long pullTime){
		
		this.position = new Vector2f(player.getPosition().getX(), player.getPosition().getY());
		this.player = player;
		
		if(pullTime > 2000){
			pullTime = 2000;
		}
		
		this.pullTime = (int) pullTime;
		
		if(player.direction == Player.LEFT){
			this.movement = new Vector2f(-player.speed*5, -5);
		}else{
			this.movement = new Vector2f(player.speed*5, -5);
		}
		
		create();
	}
	
	private void create(){
		active = true;
	}
	
	private void destroy(){
		active = false;
	}
	
	public void tick(List<Entity> entities, List<Player> players){
		
		if(active){
			
			boolean hasCollided = false;
			
			if(movement.getY() <= Game.FALLING_CAP){
				
				movement.setY(movement.getY() + (Game.GRAVITY.getY() * (1.1F - pullTime / 2000)));
				//System.out.println(Game.GRAVITY.getY() * (1 - pullTime / 2000));
				System.out.println(1 -pullTime / 2000);
				
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
			
			movement.setX(movement.getX() / 10 * (9.5F + (pullTime / 4000F)));
			
			if(hasCollided){
				destroy();
			}
			
			for(Player player : players){
				if(player != this.player){
					if(Collider.getCollision(hitbox, player.getHitbox())){
						
						player.dealDamage((int) (damage * (pullTime / 2000F)));
						
						if(player.getPosition().getX() < position.getX()){
							player.setMovementX(-16);
							player.setMovementY(-16);
						}else{
							player.setMovementX(16);
							player.setMovementY(-16);
						}
						
						destroy();
						
					}
				}
			}
		}
		
		
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Vector2f getMovement() {
		return movement;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
