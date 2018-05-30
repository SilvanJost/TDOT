package server.game.entities;

import java.util.List;

import server.geometrics.Collider;
import server.geometrics.Hitbox;
import server.net.PacketHandler;
import server.net.packets.UpdateEntityPacket;
import server.utils.Vector2;

public class Appi extends Player{

	private boolean hasFirewall = false;
	
	private boolean canPunch = true;
	
	private int punchCooldown = (int) (0.7F * 1000);
	private int punchTimer = 0;
	
	private long now;
	private long last = System.currentTimeMillis();
	
	private boolean isSuperActive;
	
	private int superDamage = 50;
	
	private long superStart;
	private long superDuration = (int) (1.5F * 1000);
	
	private Hitbox punchHitbox;
	private Hitbox beamHitboxRight;
	private Hitbox beamHitboxLeft;
	
	public Appi() {
		super(150, 3, new Projectile(Projectile.KEYBOARD, 25, 7, 60, 30));
		
		punchHitbox = new Hitbox(this, 75, 150, new Vector2(0, 0));
		beamHitboxRight = new Hitbox(this, 2000, 75, new Vector2(75, 50));
		beamHitboxLeft = new Hitbox(this, -2000, 75, new Vector2(0, 50));
	}

	@Override
	public void tickAbilities(List<Entity> entities, List<Player> players) {
		now = System.currentTimeMillis();
		
		throwable.tick(entities, players);
		
		if(!canPunch){
			punchTimer += now-last;
			
			if(punchTimer > punchCooldown){
				canPunch = true;
			}
		}
		
		if(isSuperActive){
			
			Hitbox beamHitbox;
			
			if(direction == RIGHT){
				beamHitbox = beamHitboxRight;
			}else{
				beamHitbox = beamHitboxLeft;
			}
			
			if(now - superStart < superDuration){
				
				for(Player player : players){
					if(player != this){
						if(Collider.getCollision(beamHitbox, player.getHitbox())){
							
							player.dealDamage(superDamage);
							isSuperActive = false;
						}
					}
				}
				
			}else{
				isSuperActive = false;
			}
		}else{
			canMove = true;
		}
		
		last = now;
	}
	
	@Override
	public void punch(List<Player> players) {
		if(canPunch){
			
			this.animationId = Player.PUNCH;
						
			for(Player player : players){
				if(player != this){
					
					if(Collider.getCollision(player.getHitbox(), punchHitbox)){
						
						player.dealDamage(5);
						if(player.getPosition().getX() < position.getX()){
							player.setMovementX(-16);
							player.setMovementY(-16);
						}else{
							player.setMovementX(16);
							player.setMovementY(-16);
						}
					
					}
				}
			}
			
			canPunch = false;
		}
	}

	@Override
	public void useSuper(List<Player> players) {
		
		if(hasBueno){
			
			animationId = SUPER_CAST;
			
			superStart = System.currentTimeMillis();
			isSuperActive = true;
			canMove = false;
			
			hasBueno = false;
		}
	}

	@Override
	public void dealDamage(int damage) {
		
		if(hasFirewall){
			
			this.health -= (int) (damage / 2);
			
		}else{
			
			this.health -= damage;
		}
	}

	
}
