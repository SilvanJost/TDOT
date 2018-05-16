package server.utils;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animation {

	private BufferedImage[] frames;
	
	private int frameCount;
	
	private int duration;
	private int frameDuration;
	
	private int currentFrame;
	
	private int timePassed;
	private int timePassedTotal;
	
	private long timeNow;
	private long timeLast;
	
	public Animation(int duration, int frames){
		
		this.duration = duration * 1000;
		this.frameDuration = this.duration / frames;
		
		this.frameCount = frames;
	}
	
	public Animation(BufferedImage[] frames){
		
		this.frames = frames;
	}
	
	public void tick(){
		
		if(timePassedTotal >= duration){
			timeNow = System.currentTimeMillis();
		
			if(timePassed >= frameDuration){
			
				timePassedTotal += timePassed;
				timePassed = 0;
			
				currentFrame += 1;
				currentFrame = currentFrame % frameCount;
			}
		
			timePassed += timeNow - timePassed;
			timeLast = timeNow;
		}
	}
	
	public void render(Graphics g, int x, int y){
		
		g.drawImage(frames[currentFrame], x, y, null);
	}
	
	public void render(Graphics g, int x, int y, int width, int height){
		
		g.drawImage(frames[currentFrame], x, y, width, height, null);
	}
	
	public void setCurrentFrame(int frame){
		this.currentFrame = frame;
	}
	
	public int getCurrentFrame(){
		return this.currentFrame;
	}
}
