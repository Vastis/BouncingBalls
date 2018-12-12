package movement;

import simObjects.Ball;

public class Gravity {

    private Vector gravityVector;

    public Gravity(double gravityCoefficient){
        this.gravityVector = new Vector(0,0,0,gravityCoefficient);
    }

    public void gravitize(Ball ball){
        ball.getDefiningVector().add(gravityVector);
    }
}
