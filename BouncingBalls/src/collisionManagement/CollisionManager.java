package collisionManagement;

import simObjects.Ball;
import simObjects.Bounds;

public class CollisionManager {

    private CollisionDetector collisionDetector;
    private CollisionResponder collisionResponder;

    public CollisionManager(Ball ball, Bounds bounds){
        collisionDetector = new CollisionDetector(ball, bounds);
        collisionResponder = new CollisionResponder(ball, bounds);
    }

    public void checkCollision(){
        int collisionType = collisionDetector.detectBoundsCollision();

        //TODO
        switch (collisionType){
            //no collision
            case 0:
                break;
            //right collision
            case 1:
                break;
            //left collision
            case 2:
                break;
            //lower collision
            case 10:
                collisionResponder.lowerBounce();
                break;
            //upper collision
            case 20:
                break;
            //right-lower collision
            case 11:
                break;
            //left-lower collision
            case 12:
                break;
            //right-upper collision
            case 21:
                break;
            //left-upper collision
            case 22:
                break;
        }
    }
}
