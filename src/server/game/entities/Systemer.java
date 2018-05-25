package server.game.entities;

import java.util.List;

import server.geometrics.Collider;
import server.geometrics.Hitbox;
import server.utils.Vector2;

public class Systemer extends Player{

	private boolean hasFirewall = false;
	
	private boolean canPunch = true;
	
	private int punchCooldown = (int) (0.7F * 1000);
	private int punchTimer = 0;
	
	private long now;
	private long last = System.currentTimeMillis();
	
	private Hitbox punchHitbox;
	
	public Systemer() {
		super(150, 5);
		
		punchHitbox = new Hitbox(this, 35, 60, new Vector2(100, 50));
	}

	@Override
	public void tickAbilities(List<Entity> entities, List<Player> players) {
		now = System.currentTimeMillis();
		
		//throwable.tick(entities, players);
		
		if(!canPunch){
			punchTimer += now-last;
			
			if(punchTimer > punchCooldown){
				canPunch = true;
			}
		}
		
		
		last = now;
	}
	
	@Override
	public void punch(List<Player> players) {
		if(canPunch){
			
			this.animationId = Player.PUNCH;
			System.out.println("punch");
			for(Player player : players){
			
				if(Collider.getCollision(player.getHitbox(), punchHitbox)){
				
					player.dealDamage(5);
				
				}
			}
			
			canPunch = false;
		}
	}
	
	@Override
	public void toss(List<Player> players) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void useSuper(List<Player> players) {
		// TODO Auto-generated method stub
		
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
