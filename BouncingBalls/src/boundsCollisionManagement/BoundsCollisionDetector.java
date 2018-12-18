package boundsCollisionManagement;

import simObjects.Ball;
import simObjects.Bounds;

public class BoundsCollisionDetector {

    private Ball ball;
    private Bounds bounds;

    public BoundsCollisionDetector(Ball ball, Bounds bounds){
        this.ball = ball;
        this.bounds = bounds;
    }

    public int detectBoundsCollision(){
        int collisionType = 0;

        //x-axis perspective
        //if ball moves along x-axis
        if(ball.getDefiningVector().getModuleX() != 0){
            //if ball goes right check if it's gonna collide with right bound
            if(ball.getDefiningVector().getModuleX() > 0){
                if(ball.getDefiningVector().getEndX() + ball.getBall().getRadiusX() >= bounds.getRightBound())
                    collisionType = 1;
            }
            //if ball goes left check if it's gonna collide with left bound
            else {
                if(ball.getDefiningVector().getEndX() <= bounds.getLeftBound())
                    collisionType = 2;
            }
        }

        //y-axis perspective
        //if ball moves along y-axis
        if(ball.getDefiningVector().getModuleY() != 0){
            //if ball goes down check if it's gonna collide with lower bound
            if(ball.getDefiningVector().getModuleY() > 0){
                if(ball.getDefiningVector().getEndY() + ball.getBall().getRadiusY() >= bounds.getLowerBound())
                    collisionType = 3;
            }
            //if ball goes up check if it's gonna collide with upper bound
            else {
                if(ball.getDefiningVector().getEndY() <= bounds.getUpperBound())
                    collisionType = 4;
            }
        }

        return collisionType;
    }
}
