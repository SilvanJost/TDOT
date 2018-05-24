package server.utils;

public class Vector2f {

	private float x, y;
	
	public Vector2f(float x, float y){
		
		this.x = x;
		this.y = y;

	}
	
	public Vector2f add(Vector2f vec){
	
		Vector2f out = new Vector2f(this.x + vec.x, this.y + vec.y);
		
		return out;
	}
	
	public Vector2f sub(Vector2f vec){
		
		Vector2f out = new Vector2f(this.x - vec.x, this.y - vec.y);
		
		return out;
	}
	
	public Vector2f mul(Vector2f vec){
		
		Vector2f out = new Vector2f(this.x * vec.x, this.y * vec.y);
		
		return out;
	}
	
	public Vector2f div(Vector2f vec){
		
		Vector2f out = new Vector2f(this.x / vec.x, this.y / vec.y);
		
		return out;
	}
	
	public float getX(){
		return this.x;
	}
	
	public float getY(){
		return this.y;
	}
	
	public void setX(float x){
		this.x = x;
	}
	
	public void setY(float y){
		this.y = y;
	}
}
