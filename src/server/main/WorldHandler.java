package server.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import server.game.entities.Entity;
import server.geometrics.Hitbox;
import server.utils.Vector2;

public class WorldHandler {

    private static List<World> allWorlds;

    public static final int SKYLINE = 0;
    public static final int BEACH = 1;

    public static void init() {
        /*
         * create World Skyline
         */
        
        allWorlds = new ArrayList<World>();
        
        World skyline = new World("Skyline");
        Entity groundStage = new Entity();
        groundStage.setPosition(new Vector2(182, 971));
        groundStage.setHitbox(new Hitbox(groundStage, 1556, 109, new Vector2(0, 0)));
        skyline.addStructure(groundStage);
        
        
        
        allWorlds.add(skyline);

    }

    public static int getRandom() {

        Random random = new Random();

        return random.nextInt(allWorlds.size());
    }
}
