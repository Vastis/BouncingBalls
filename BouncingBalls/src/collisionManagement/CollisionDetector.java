package collisionManagement;

import simObjects.Ball;
import simObjects.Bounds;

public class CollisionDetector {

    private Ball ball;
    private Bounds bounds;

    public CollisionDetector(Ball ball, Bounds bounds){
        this.ball = ball;
        this.bounds = bounds;
    }

    public int detectBoundsCollision(){
        int pX = 0, pY = 0;
        //x-axis perspective
        //if ball moves along x-axis
        if(ball.getDefiningVector().getModuleX() != 0){
            //if ball goes right check if it's gonna collide with right bound
            if(ball.getDefiningVector().getModuleX() > 0){
                if(ball.getDefiningVector().getEndX() >= bounds.getRightBound())
                    pX = 1;
            }
            //if ball goes left check if it's gonna collide with left bound
            else {
                if(ball.getDefiningVector().getEndX() <= bounds.getLeftBound())
                    pX = 1;
            }
        }

        //y-axis perspective
        //if ball moves along y-axis
        if(ball.getDefiningVector().getModuleY() != 0){
            //if ball goes down check if it's gonna collide with lower bound
            if(ball.getDefiningVector().getModuleY() > 0){
                if(ball.getDefiningVector().getEndY() >= bounds.getLowerBound())
                    pY = 2;
            }
            //if ball goes up check if it's gonna collide with upper bound
            else {
                if(ball.getDefiningVector().getEndY() <= bounds.getUpperBound())
                    pY = 2;
            }
        }

        return pX + pY;
    }
}
