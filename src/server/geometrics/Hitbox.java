package server.geometrics;

import server.game.entities.Entity;
import server.utils.Vector2;
import server.utils.Vector2f;

public class Hitbox {

	private Entity e;
	
    private int width;
    private int height;
    private Vector2 offset;
    
    public Hitbox(Entity e, int width, int height, Vector2 offset) {
    	this.e = e;
        this.width = width;
        this.height = height;
        this.offset = offset;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Vector2 getOffset() {
        return offset;
    }
    
    public Vector2f getPosition(){
    	return e.getPosition();
    }
}
