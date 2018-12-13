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
            //right & left collision
            case 1:
                collisionResponder.horizontalBounce();
                break;
            //lower & upper collision
            case 2:
                collisionResponder.verticalBounce();
                break;
            case 3:
                //possible?
                break;
        }
    }
}
