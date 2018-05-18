package client.entities;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import client.utils.Vector2;

public class Entity {

	private Vector2 position;
	private int width, height;
	
	private BufferedImage sprite;
	
	public Entity(BufferedImage sprite,int width, int height, int xPosition, int yPosition){
		
		this.sprite = sprite;
		
		position = new Vector2(xPosition, yPosition);
		
		this.width = width;
		this.height = height;
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
