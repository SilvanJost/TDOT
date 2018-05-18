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
        
        Entity heavenStage1 = new Entity();
        heavenStage1.setPosition(new Vector2(460, 725));
        heavenStage1.setHitbox(new Hitbox(heavenStage1, 450, 45, new Vector2(0, 0)));
        skyline.addStructure(heavenStage1);
        
        Entity heavenStage2 = new Entity();
        heavenStage2.setPosition(new Vector2(1125, 725));
        heavenStage2.setHitbox(new Hitbox(heavenStage2, 450, 45, new Vector2(0, 0)));
        skyline.addStructure(heavenStage2);
        
        Entity heavenStage3 = new Entity();
        heavenStage3.setPosition(new Vector2(792, 480));
        heavenStage3.setHitbox(new Hitbox(heavenStage3, 450, 45, new Vector2(0, 0)));
        skyline.addStructure(heavenStage3);
        
        
        
        
        allWorlds.add(skyline);

    }

    public static int getRandom() {

        Random random = new Random();

        return random.nextInt(allWorlds.size());
    }
}
