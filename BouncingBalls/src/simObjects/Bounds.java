package simObjects;

import javafx.scene.canvas.Canvas;

public class Bounds {

    private double  upperBound,
                    lowerBound,
                    leftBound,
                    rightBound;
    private double  bounceCoefficient;

    public Bounds(Canvas canvas, double bounceCoefficient){
        this.upperBound = 1;
        this.lowerBound = canvas.getHeight() - 1;
        this.leftBound = 1;
        this.rightBound = canvas.getWidth() - 1;
        this.bounceCoefficient = bounceCoefficient;
    }

    public double getUpperBound() {
        return upperBound;
    }
    public double getLowerBound() {
        return lowerBound;
    }
    public double getLeftBound() {
        return leftBound;
    }
    public double getRightBound() {
        return rightBound;
    }
    public double getBounceCoefficient() {
        return bounceCoefficient;
    }
}
