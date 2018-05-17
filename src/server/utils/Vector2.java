package server.utils;

public class Vector2 {

	private int x, y;
	
	public Vector2(int x, int y){
		
		this.x = x;
		this.y = y;
	}
	
	public Vector2 add(Vector2 vec){
	
		Vector2 out = new Vector2(this.x + vec.x, this.y + vec.y);
		
		return out;
	}
	
	public Vector2 sub(Vector2 vec){
		
		Vector2 out = new Vector2(this.x - vec.x, this.y - vec.y);
		
		return out;
	}
	
	public Vector2 mul(Vector2 vec){
		
		Vector2 out = new Vector2(this.x * vec.x, this.y * vec.y);
		
		return out;
	}
	
	public Vector2 div(Vector2 vec){
		
		Vector2 out = new Vector2(this.x / vec.x, this.y / vec.y);
		
		return out;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
}
