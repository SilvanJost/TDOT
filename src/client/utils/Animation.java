package client.utils;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import client.entities.Entity;

public class Animation {

	private BufferedImage[] images;
	
	private int currentFrame;
	
	private int frameDuration;
	
	private int currentFrameTime;
	
	private boolean active;
	
	private boolean stayAtLast = false;
	private boolean atLast = false;
	
	private boolean untilFinished = false;
	
	public boolean isUntilFinished() {
		return untilFinished;
	}

	public void setUntilFinished(boolean untilFinished) {
		this.untilFinished = untilFinished;
	}

	private long now;
	private long last = System.currentTimeMillis();
	
	private int x, y;
	private int width, height;
	
	public Animation(BufferedImage[] images, float duration, int width, int height){
		this.images = images;
		
		this.frameDuration = (int) (duration*1000 / (images.length-1));
		
		this.width = width;
		this.height = height;
	}
	
	public Animation(BufferedImage[] images, float duration, int x, int y, int width, int height){
		this.images = images;
		
		this.frameDuration = (int) (duration*1000 / (images.length-1));
		
		this.x = x;
		this.y = y;
		
		this.width = width;
		this.height = height;
	}
	
	public void tick(){
		if(active){
			
			now = System.currentTimeMillis();
			
			currentFrameTime += now-last;
			
			if(currentFrameTime > frameDuration){
				
				currentFrame ++;
				
				currentFrameTime = 0;
				
				if(currentFrame >= images.length){
					active = false;
					currentFrame = images.length-1;
					atLast = true;
				}
			}
			
			last = now;
		}
	}
	
	public boolean isAtLast() {
		return atLast;
	}

	public void setAtLast(boolean atLast) {
		this.atLast = atLast;
	}

	public void run(){
		currentFrame = 0;
		atLast = false;
		
		active = true;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public boolean isActive(){
		return this.active;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public BufferedImage getFrame(){
		return this.images[currentFrame];
	}
	
	public boolean isStayAtLast() {
		return stayAtLast;
	}

	public void setStayAtLast(boolean stayAtLast) {
		this.stayAtLast = stayAtLast;
	}
}
