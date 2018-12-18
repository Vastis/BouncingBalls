package simObjects;

import boundsCollisionManagement.BallTrajectoryFactory;
import boundsCollisionManagement.BoundsCollisionManager;
import javafx.animation.PathTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Path;
import movement.Gravity;
import movement.Vector;
import random.Generator;
import random.RangeException;

/**
 * Simulation object within simulation bounds.
 */
public class Ball {

    private final Color[] colors = {
            Color.RED,
            Color.BLUE,
            Color.BEIGE,
            Color.DARKGREEN,
            Color.ORANGE
    };

    private Ellipse                 ball;
    private Vector                  definingVector,
                                    lastDefiningVector;
    private Bounds                  bounds;
    private Gravity                 gravity;
    private double                  mass;
    private BallTrajectoryFactory   ballTrajectoryFactory;
    private BoundsCollisionManager  boundsCollisionManager;

    public Ball(boolean startingRight, double initSpeedParam, Bounds bounds, Gravity gravity){
        this.bounds = bounds;
        this.gravity = gravity;
        this.boundsCollisionManager = new BoundsCollisionManager(this, bounds);

        initializeBall();
        setMovementParams(startingRight, initSpeedParam);
    }

    private void initializeBall(){
        Generator generator = new Generator();
        try {
            double radius = generator.nextDouble(5.0, 10.0);
            int colorNo = generator.nextInt(colors.length);
            this.ball = new Ellipse();
            this.ball.setRadiusX(radius);
            this.ball.setRadiusY(radius);
            this.ball.setFill(colors[colorNo]);
        } catch (RangeException e) {
            e.printStackTrace();
        }
    }
    private void setMovementParams(boolean startingRight, double initSpeedParam){
        Generator generator = new Generator();
        double posX = 0, posY = 0, initSpeed = 0;

        try {
            posY = generator.nextDouble(bounds.getUpperBound() + 10.0, bounds.getLowerBound());
            initSpeed = generator.nextDouble(initSpeedParam - 10.0, initSpeedParam + 10.0);

            if(startingRight) {
                posX = bounds.getRightBound() - ball.getRadiusX();
                initSpeed = -initSpeed;
            }
            else
                posX = bounds.getLeftBound() + ball.getRadiusX();

        } catch (RangeException e) {
            e.printStackTrace();
        }

        this.ball.setCenterX(posX);
        this.ball.setCenterY(posY);
        this.mass = ball.getRadiusX();

        this.definingVector = new Vector(posX, posY, posX + initSpeed, posY);
        this.ballTrajectoryFactory = new BallTrajectoryFactory(this, bounds);
        this.lastDefiningVector = new Vector(posX, posY, posX, posY);
    }

    public void update(){
        gravity.gravitize(this);
        ballTrajectoryFactory.newTrajectory();

        Path trajectory = boundsCollisionManager.computeTrajectory();
        move(trajectory);
    }

    public void move(Path trajectory){
        PathTransition transition = ballTrajectoryFactory.getTransition(trajectory);
        transition.play();
        lastDefiningVector = definingVector.copy();
        definingVector.transfer();
    }

    public Vector getDefiningVector() {
        return definingVector;
    }
    public Vector getLastDefiningVector() {
        return lastDefiningVector;
    }
    public Ellipse getBall() {
        return ball;
    }
    public BallTrajectoryFactory getBallTrajectoryFactory() {
        return ballTrajectoryFactory;
    }
    public double getMass() {
        return mass;
    }
}
