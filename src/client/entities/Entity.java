package client.entities;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import client.utils.Vector2;

public class Entity {

	private Vector2 position;
	private int width, height;
	
	private Vector2 lastPosition;
	
	private static final int LEFT = 0;
	private static final int RIGHT = 1;
	
	private int direction = RIGHT;
	
	private BufferedImage sprite;
	
	public Entity(BufferedImage sprite,int width, int height, int xPosition, int yPosition){
		
		this.sprite = sprite;
		
		position = new Vector2(xPosition, yPosition);
		lastPosition = new Vector2(0, 0);
		
		this.width = width;
		this.height = height;
	}
	
	public void render(Graphics2D g){
		
		if(lastPosition.getX() > position.getX()){
			
			direction = LEFT;
			
		}else{
			direction = RIGHT;
			
		}
		
		if(direction == RIGHT){
			g.drawImage(sprite, position.getX(), position.getY(), width, height, null);
		}else{
			g.drawImage(sprite, position.getX() + width, position.getY(), -width, height, null);
			//g2.drawImage(image, x + width, y, -width, height, null);
		}
	}
	
	public void setPosition(Vector2 position){
		this.position = position;
	}
	
	public Vector2 getPosition(){
		return this.position;
	}

	public Vector2 getLastPosition() {
		return lastPosition;
	}

	public void setLastPosition(Vector2 lastPosition) {
		this.lastPosition = lastPosition;
	}
}
