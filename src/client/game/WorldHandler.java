package client.game;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import client.assets.Assets;
import client.entities.Entity;
import client.utils.Vector2;

public class WorldHandler {

    private static int currentWorld;

    private static List<World> worlds;

    public static void init() {

        worlds = new ArrayList<World>();

        World skyline = new World("Skyline", Assets.skylineBackground);
        Entity groundStage = new Entity(Assets.skylineGroundStage,1556,109);
        groundStage.setPosition(new Vector2(182, 971));
        skyline.addStructure(groundStage);
        
        worlds.add(new World(null, null));
        worlds.add(skyline);
    }

    public static int getCurrentWorld() {
        return currentWorld;
    }

    public static void setWorld(int world) {

        currentWorld = world;
    }

    public static void render(Graphics2D g) {
        worlds.get(currentWorld).render(g);
    }
}
