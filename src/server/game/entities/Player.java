package server.game.entities;

import java.util.List;

import server.geometrics.Hitbox;

public abstract class Player extends Entity{
	
	public static final int NONE = 0;
	public static final int IDLE = 1;
	public static final int RUN = 2;
	public static final int JUMP = 3;
	public static final int PUNCH = 4;
	public static final int PULL = 5;
	public static final int TOSS = 6;
	public static final int SUPER_CAST = 7;
	
	private int connectionId;
	
	protected int animationId;

	protected int health;
	protected int speed;
	
	protected long tossStart;
	
	protected Projectile throwable;
	
	protected boolean hasBueno = false;
	
	protected int lives = 3;
	
	public Player(int health, int speed){
		
		this.health = health;
		this.speed = speed;
	}
	
	public abstract void punch(List<Player> players);
	
	public abstract void toss(List<Player> players);
	
	public abstract void useSuper(List<Player> players);
	
	public abstract void tickAbilities(List<Entity> entities, List<Player> players);
	
	public void loadToss(){
		tossStart = System.currentTimeMillis();
	}
	
	public void collectBueno(){
		this.hasBueno = true;
	}

	public int getHealth() {
		return health;
	}

	public void dealDamage(int damage) {
		this.health -= damage;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}
	
	public int getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(int connectionId) {
		this.connectionId = connectionId;
	}
	
	public int getAnimationId() {
		return animationId;
	}

	public void setAnimationId(int animationId) {
		this.animationId = animationId;
	}
}
