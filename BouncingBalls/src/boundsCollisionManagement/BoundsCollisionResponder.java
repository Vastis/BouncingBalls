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

    public Path verticalBounce(Path trajectory) {
        ball.getDefiningVector().reverse();
        ball.getDefiningVector().multiply(bounds.getBounceCoefficient());
        ball.getDefiningVector().reflectByY();

        return null;
    }

    public Path horizontalBounce(Path trajectory){
        ball.getDefiningVector().reverse();
        ball.getDefiningVector().multiply(bounds.getBounceCoefficient());
        ball.getDefiningVector().reflectByX();

        return null;
    }
}
