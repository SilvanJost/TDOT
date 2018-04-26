package client.entities;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import client.utils.Vector2;

public abstract class Entity {

	private Vector2 position;
	private int width, height;
	
	private BufferedImage sprite;
	
	private int health;
	
	public Entity(BufferedImage sprite){
		
		this.sprite = sprite;
		
		position = new Vector2(100, 100);
		
		width = 100;
		height = 200;
	}
	
	public void render(Graphics2D g){
		
		g.drawImage(sprite, position.getX(), position.getY(), width, height, null);
	}
	
	public void setPosition(Vector2 position){
		this.position = position;
	}
	
	public Vector2 getPosition(){
		return this.position;
	}
}
