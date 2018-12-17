package simCore;

/**
 * Class containing User- and non-User-defined simulation parameters.
 */

public class SimulationParameters {

    private int leftBalls, rightBalls;
    private double gravity, initSpeed;

    public SimulationParameters(int leftBalls, int rightBalls, double gravity, double initSpeed){
        this.leftBalls = leftBalls;
        this.rightBalls = rightBalls;
        this.gravity = gravity;
        this.initSpeed = initSpeed;
    }

    public int getLeftBalls() {
        return leftBalls;
    }
    public int getRightBalls() {
        return rightBalls;
    }
    public double getGravity() {
        return gravity;
    }
    public double getInitSpeed() {
        return initSpeed;
    }
}
