package animations;

import javafx.animation.PathTransition;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.util.Duration;
import simObjects.Ball;

public class BallTrajectoryFactory {

    private Ball ball;

    public BallTrajectoryFactory(Ball ball) {
        this.ball = ball;
    }
    /*
        x,y - destination coordinates
        p,q - vertex coordinates
        a - parabola's coefficient

        y = a(x-p)^2 + q    (canonical quadratic form)
        a = (y-q)/((x-p)^2)

        y = (speedY/speedX^2)(x-posX)^2 + posY
    */
    public Path getTrajectory(){
        double quadCoefficient = ball.getDefiningVector().getModuleY()/(ball.getDefiningVector().getModuleX() * ball.getDefiningVector().getModuleX());
        double controlX = ball.getDefiningVector().getBeginX() + ball.getDefiningVector().getModuleX()/2;
        double controlY = quadCoefficient * ball.getDefiningVector().getModuleX()/2 * ball.getDefiningVector().getModuleX()/2 + ball.getDefiningVector().getBeginY();

        Path path = new Path();
        path.getElements().add(new MoveTo(ball.getDefiningVector().getBeginX(), ball.getDefiningVector().getBeginY()));
        path.getElements().add(new QuadCurveTo(controlX, controlY, ball.getDefiningVector().getEndX(), ball.getDefiningVector().getEndY()));

        return path;
    }

    public PathTransition getTransition(Path path){
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(100));
        pathTransition.setPath(path);
        pathTransition.setNode(ball.getBall());
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);

        return pathTransition;
    }
}
