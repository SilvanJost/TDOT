package server.game.entities;

import java.util.List;

import server.geometrics.Collider;
import server.geometrics.Hitbox;
import server.utils.Vector2;
import server.utils.Vector2f;

public class Betriebler extends Player{

	private boolean canPunch = true;
	
	private int punchCooldown = (int) (0.7F * 1000);
	private int punchTimer = 0;
	
	private long now;
	private long last = System.currentTimeMillis();
	
	
	private Entity ticket;
	private int initialTicketDamage = 50;
	private int ticketDamage;
	private boolean isTicketActive;
	
	private Hitbox punchHitbox;
	
	public Betriebler() {
		super(115, 3, new Projectile(Projectile.PHONE, 20, 7, 30, 30));

		punchHitbox = new Hitbox(this, 75, 150, new Vector2(0, 0));
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
							player.setMovementX(-15);
							player.setMovementY(-15);
						}else{
							player.setMovementX(15);
							player.setMovementY(-15);
						}
					
					}
				}
			}
		}		
	}

	@Override
	public void useSuper(List<Player> players) {
		
		if(hasBueno){
			
			isTicketActive = true;
			
			ticket = new Entity();
			ticket.setPosition(new Vector2f(930, 0));
			
			ticketDamage = initialTicketDamage;
			
			hasBueno = false;
		}
	}

	@Override
	public void tickAbilities(List<Entity> entities, List<Player> players) {

		now = System.currentTimeMillis();
		
		throwable.tick(entities, players);
		
		if(position.getY() > 1080){
			dealDamage(999);
		}
		
		if(!canPunch){
			punchTimer += now-last;
			
			if(punchTimer > punchCooldown){
				canPunch = true;
			}
		}
		
		if(isTicketActive){
			
			if(ticket.getPosition().getY() < 1080){
				
				Vector2f position = ticket.getPosition();
				
				ticket.setPosition(new Vector2f(position.getX(), position.getX() + 5));
				
				for(Player player : players){
					if(player != this){
						if(Collider.getCollision(ticket.getHitbox(), player.getHitbox())){
						
							player.dealDamage(ticketDamage);
							ticketDamage = 0;
						}
					}
				}
				
			}
			
		}else{
			
			isTicketActive = false;
		}
		
		last = now;
	}
	
	public boolean isTicketActive(){
		return this.isTicketActive;
	}
	
	public Entity getTicket(){
		return this.ticket;
	}
}
