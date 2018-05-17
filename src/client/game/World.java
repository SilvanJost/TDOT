package client.game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import client.entities.Entity;

public class World {

	public static final int SKYLINE = 0;
	
	private String name;
	
	private BufferedImage background;
	
	public List<Entity> structures = new ArrayList<Entity>();
	
	public World(String name, BufferedImage background){
		
		this.name = name;
		this.background = background;
	}
	
	public void addStructure(Entity e){
		
		structures.add(e);
	}
	
	public List<Entity> getStructures(){
		
		return this.structures;
	}
	
	public void render(Graphics2D g){
		
		g.drawImage(background, 0, 0, null);
		
		for(Entity e : structures){
			
			e.render(g);
		}
	}
	
	public String getNmae(){
		return this.name;
	}
}
