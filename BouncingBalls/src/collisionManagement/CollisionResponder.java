package collisionManagement;

import simObjects.Ball;
import simObjects.Bounds;

public class CollisionResponder {

    private Ball ball;
    private Bounds bounds;

    public CollisionResponder(Ball ball, Bounds bounds){
        this.ball = ball;
        this.bounds = bounds;
    }

    public void lowerBounce() {
        ball.getDefiningVector().reverse();
        ball.getDefiningVector().multiply(bounds.getBounceCoefficient());
    }
}
