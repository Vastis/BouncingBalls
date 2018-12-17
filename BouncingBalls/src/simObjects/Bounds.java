package simObjects;

import javafx.scene.shape.Rectangle;

public class Bounds {

    private Rectangle bounds;
    private double  bounceCoefficient;

    public Bounds(Rectangle bounds, double bounceCoefficient){
        this.bounds = bounds;
        this.bounceCoefficient = bounceCoefficient;
    }

    public Rectangle getBounds() {
        return bounds;
    }
    public double getBounceCoefficient() {
        return bounceCoefficient;
    }
    public double getRightBound(){
        return this.bounds.getWidth();
    }
    public double getLeftBound(){
        return 0;
    }
    public double getLowerBound(){
        return this.bounds.getHeight();
    }
    public double getUpperBound(){
        return 0;
    }
}
