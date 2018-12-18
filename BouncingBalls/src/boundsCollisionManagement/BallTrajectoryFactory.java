package boundsCollisionManagement;

import javafx.animation.PathTransition;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.util.Duration;
import simObjects.Ball;
import simObjects.Bounds;

/**
 * Computes ball's movement trajectory according to the ball's defining vector.
 */
/*
    x,y - destination coordinates
    p,q - vertex coordinates
    a - parabola's coefficient

    y = a(x-p)^2 + q    (canonical quadratic form)
    a = (y-q)/((x-p)^2)
    x = ((y-q)/a)^(-1)

    y = (speedY/speedX^2)(x-posX)^2 + posY
*/
public class BallTrajectoryFactory {

    private Ball ball;
    private Bounds bounds;
    private Path trajectory;

    public BallTrajectoryFactory(Ball ball, Bounds bounds) {
        this.ball = ball;
        this.bounds = bounds;
    }

    private Path generateBallTrajectory(){
        double quadCoefficient = ball.getDefiningVector().getModuleY() / (ball.getDefiningVector().getModuleX() * ball.getDefiningVector().getModuleX());
        double controlX = ball.getDefiningVector().getBeginX() + ball.getDefiningVector().getModuleX() / 2;
        double controlY = quadCoefficient * ball.getDefiningVector().getModuleX() / 2 * ball.getDefiningVector().getModuleX() / 2 + ball.getDefiningVector().getBeginY();
        Path path = new Path();
        path.getElements().add(new MoveTo(ball.getDefiningVector().getBeginX(), ball.getDefiningVector().getBeginY()));
        path.getElements().add(new QuadCurveTo(controlX, controlY, ball.getDefiningVector().getEndX(), ball.getDefiningVector().getEndY()));

        return path;
    }
    public void newTrajectory(){
        this.trajectory = generateBallTrajectory();
    }

    public Path bounceLeft(){
        double quadCoefficient = computeQuadCoefficient();
        double bounceX = bounds.getRightBound();
        double bounceY = quadCoefficient * (bounceX - ball.getDefiningVector().getBeginX()) / 2 * (bounceX - ball.getDefiningVector().getBeginX()) / 2 + ball.getDefiningVector().getBeginY();

        Path bouncedTrajectory = computeBouncePath(quadCoefficient, bounceX, bounceY);

        ball.getDefiningVector().reflectByY();
        bouncedTrajectory.getElements().addAll(generateBallTrajectory().getElements());

        return bouncedTrajectory;
    }
    public Path bounceRight(){
        double quadCoefficient = computeQuadCoefficient();
        double bounceX = bounds.getLeftBound();
        double bounceY = quadCoefficient * (bounceX - ball.getDefiningVector().getBeginX()) / 2 * (bounceX - ball.getDefiningVector().getBeginX()) / 2 + ball.getDefiningVector().getBeginY();

        Path bouncedTrajectory = computeBouncePath(quadCoefficient, bounceX, bounceY);

        ball.getDefiningVector().reflectByY();
        bouncedTrajectory.getElements().addAll(generateBallTrajectory().getElements());

        return bouncedTrajectory;
    }
    public Path bounceUp(){
        double quadCoefficient = computeQuadCoefficient();
        double bounceY = bounds.getLowerBound();
        double bounceX = Math.signum(ball.getDefiningVector().getModuleX()) * Math.sqrt((bounceY - ball.getDefiningVector().getBeginY())/quadCoefficient) + ball.getDefiningVector().getBeginX();

        Path bouncedTrajectory = computeBouncePath(quadCoefficient, bounceX, bounceY);

        ball.getDefiningVector().reflectByX();
        bouncedTrajectory.getElements().addAll(generateBallTrajectory().getElements());

        return bouncedTrajectory;
    }
    public Path bounceDown(){
        double quadCoefficient = computeQuadCoefficient();
        double bounceY = bounds.getUpperBound();
        double bounceX = Math.signum(ball.getDefiningVector().getModuleX()) * Math.sqrt((bounceY - ball.getDefiningVector().getBeginY())/quadCoefficient) + ball.getDefiningVector().getBeginX();

        Path bouncedTrajectory = computeBouncePath(quadCoefficient, bounceX, bounceY);

        ball.getDefiningVector().reflectByX();
        bouncedTrajectory.getElements().addAll(generateBallTrajectory().getElements());

        return bouncedTrajectory;
    }

    private double computeQuadCoefficient(){
        return ball.getDefiningVector().getModuleY() / (ball.getDefiningVector().getModuleX() * ball.getDefiningVector().getModuleX());
    }
    public Path computeBouncePath(double quadCoefficient, double bounceX, double bounceY){
        double controlX = (bounceX + ball.getDefiningVector().getBeginX()) / 2;
        double controlY = quadCoefficient * (controlX - ball.getDefiningVector().getBeginX()) / 2 * (controlX - ball.getDefiningVector().getBeginX()) / 2 + ball.getDefiningVector().getBeginY();

        Path bouncedTrajectory = new Path();
        bouncedTrajectory.getElements().add(new MoveTo(ball.getDefiningVector().getBeginX(), ball.getDefiningVector().getBeginY()));
        bouncedTrajectory.getElements().add(new QuadCurveTo(controlX, controlY, bounceX, bounceY));

        ball.getDefiningVector().transfer(bounceX, bounceY);
        ball.getDefiningVector().multiply(bounds.getBounceCoefficient());

        return bouncedTrajectory;
    }

    public PathTransition getTransition(Path path){
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(100));
        pathTransition.setPath(path);
        pathTransition.setNode(ball.getBall());
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);

        return pathTransition;
    }

    public Path getTrajectory(){
        return this.trajectory;
    }
}
