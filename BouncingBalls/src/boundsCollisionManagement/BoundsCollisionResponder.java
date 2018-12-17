package boundsCollisionManagement;

import javafx.scene.shape.Path;
import simObjects.Ball;
import simObjects.Bounds;

public class BoundsCollisionResponder {

    private Ball ball;
    private Bounds bounds;

    public BoundsCollisionResponder(Ball ball, Bounds bounds){
        this.ball = ball;
        this.bounds = bounds;
    }

    public Path lowerBounce() {
        return ball.getBallTrajectoryFactory().bounceTrajectory(bounds.getLowerBound(),false);
    }
    public Path upperBounce() {
        return ball.getBallTrajectoryFactory().bounceTrajectory(bounds.getUpperBound(),false);
    }
    public Path rightBounce(){
        return ball.getBallTrajectoryFactory().bounceTrajectory(bounds.getRightBound(),true);
    }
    public Path leftBounce(){
        return ball.getBallTrajectoryFactory().bounceTrajectory(bounds.getLeftBound(),true);
    }
}
