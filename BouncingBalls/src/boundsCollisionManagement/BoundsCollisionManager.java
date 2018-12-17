package boundsCollisionManagement;

import javafx.scene.shape.Path;
import simObjects.Ball;
import simObjects.Bounds;

public class BoundsCollisionManager {

    private Ball ball;
    private BoundsCollisionDetector boundsCollisionDetector;
    private BoundsCollisionResponder boundsCollisionResponder;

    public BoundsCollisionManager(Ball ball, Bounds bounds){
        this.ball = ball;
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

    public Path adjustTrajectory(){
        int collisionType = boundsCollisionDetector.detectBoundsCollision();

        //TODO
        switch (collisionType){
            //no collision
            case 0:
                return ball.getBallTrajectoryFactory().getTrajectory();
            //right & left collision
            case 1:
                return boundsCollisionResponder.rightBounce();
            case 2:
                return boundsCollisionResponder.leftBounce();
            //lower & upper collision
            case 3:
                return boundsCollisionResponder.lowerBounce();
            case 4:
                return boundsCollisionResponder.upperBounce();
        }
        return null;
    }
}
