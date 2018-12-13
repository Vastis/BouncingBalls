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

    public void verticalBounce() {
        ball.getDefiningVector().reverse();
        ball.getDefiningVector().multiply(bounds.getBounceCoefficient());
        ball.getDefiningVector().reflectByY();
    }

    public void horizontalBounce(){
        ball.getDefiningVector().reverse();
        ball.getDefiningVector().multiply(bounds.getBounceCoefficient());
        ball.getDefiningVector().reflectByX();
    }
}
