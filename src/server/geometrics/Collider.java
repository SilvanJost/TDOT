package server.geometrics;

public class Collider {

    public static boolean getCollision(Hitbox box1, Hitbox box2) {
        
        int box1Left = (int) (box1.getOffset().getX() + box1.getPosition().getX());
        int box1Right = (int) (box1.getOffset().getX() + box1.getPosition().getX() + box1.getWidth());
        int box1Up = (int) (box1.getOffset().getY() + box1.getPosition().getY());
        int box1Down = (int) (box1.getOffset().getY() + box1.getPosition().getY() + box1.getHeight());
        
        
        int box2Left = (int) (box2.getOffset().getX() + box2.getPosition().getX());
        int box2Right = (int) (box2.getOffset().getX() + box2.getPosition().getX() + box2.getWidth());
        int box2Up = (int) (box2.getOffset().getY() + box2.getPosition().getY());
        int box2Down = (int) (box2.getOffset().getY() + box2.getPosition().getY() + box2.getHeight());

        boolean xCollision = ((box1Down > box2Up) && (box1Down < box2Down))
                || ((box1Up > box2Up) && (box1Up < box2Down));

        boolean yCollision = ((box1Right > box2Left) && (box1Right < box2Right))
                || ((box1Left > box2Left) && (box1Left < box2Right));

        if (xCollision && yCollision) {
            return true;
        }
        return false;
        
    }
}
