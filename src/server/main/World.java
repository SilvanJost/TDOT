package server.main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import server.game.entities.Entity;

public class World {

    private String name;

    public List<Entity> structures = new ArrayList<Entity>();

    public World(String name) {

        this.name = name;
    }

    public void addStructure(Entity e) {

        structures.add(e);
    }

    public List<Entity> getStructures() {

        return this.structures;
    }

    public String getName() {
        return this.name;
    }
}
