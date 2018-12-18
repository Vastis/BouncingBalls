package boundsCollisionManagement;

import javafx.scene.shape.Path;
import simObjects.Ball;
import simObjects.Bounds;

public class BoundsCollisionManager {

    private Ball ball;
    private BoundsCollisionDetector boundsCollisionDetector;

    public BoundsCollisionManager(Ball ball, Bounds bounds){
        this.ball = ball;
        boundsCollisionDetector = new BoundsCollisionDetector(ball, bounds);
    }

    public Path computeTrajectory(){
        int collisionType = boundsCollisionDetector.detectBoundsCollision();

        switch (collisionType){
            //no collision
            case 0:
                return ball.getBallTrajectoryFactory().getTrajectory();
            //right collision
            case 1:
                return ball.getBallTrajectoryFactory().bounceLeft();
            //left collision
            case 2:
                return ball.getBallTrajectoryFactory().bounceRight();
            //lower collision
            case 3:
                return ball.getBallTrajectoryFactory().bounceUp();
            //upper collision
            case 4:
                return ball.getBallTrajectoryFactory().bounceDown();
        }

        return null;
    }
}
