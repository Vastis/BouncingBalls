package boundsCollisionManagement;

import javafx.scene.shape.Path;
import simObjects.Ball;
import simObjects.Bounds;

public class BoundsCollisionManager {

    private BoundsCollisionDetector boundsCollisionDetector;
    private BoundsCollisionResponder boundsCollisionResponder;

    public BoundsCollisionManager(Ball ball, Bounds bounds){
        boundsCollisionDetector = new BoundsCollisionDetector(ball, bounds);
        boundsCollisionResponder = new BoundsCollisionResponder(ball, bounds);
    }

    /*public void checkCollision(Path trajectory){
        int collisionType = boundsCollisionDetector.detectBoundsCollision();

        //TODO
        switch (collisionType){
            //no collision
            case 0:
                break;
            //right & left collision
            case 1: case 2:
                boundsCollisionResponder.horizontalBounce(trajectory);
                break;
            //lower & upper collision
            case 3: case 4:
                boundsCollisionResponder.verticalBounce(trajectory);
                break;
        }
    }*/

    public Path adjustTrajectory(Path trajectory){
        Path adjustedTrajectory = null;
        int collisionType = boundsCollisionDetector.detectBoundsCollision();

        //TODO
        switch (collisionType){
            //no collision
            case 0:
                adjustedTrajectory = trajectory;
                break;
            //right & left collision
            case 1: case 2:
                adjustedTrajectory = boundsCollisionResponder.horizontalBounce(trajectory);
                break;
            //lower & upper collision
            case 3: case 4:
                adjustedTrajectory = boundsCollisionResponder.verticalBounce(trajectory);
                break;
        }

        return adjustedTrajectory;
    }
}
