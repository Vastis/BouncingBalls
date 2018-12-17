package movement;

import simObjects.Ball;

public class Gravity {

    private Vector gravityVector;
    private double gravityCoefficient;

    public Gravity(double gravityCoefficient){
        this.gravityCoefficient = gravityCoefficient;
        this.gravityVector = new Vector(0,0,0, gravityCoefficient);
    }

    public void gravitize(Ball ball){
        ball.getDefiningVector().add(gravityVector);
    }
}
