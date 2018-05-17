package server.geometrics;

import server.utils.Vector2;

public class Hitbox {

    private int width;
    private int height;
    private Vector2 offset;
    
    public Hitbox(int width, int height,Vector2 offset) {
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
    
    
}
