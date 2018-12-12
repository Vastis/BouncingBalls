package simObjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import movement.Gravity;
import movement.Vector;

public class Ball {

    private double  diameter,
                    mass;

    //beginX, beginY - current position
    //endX, endY - future position
    //moduleX, moduleY - "velocity"

    private Vector  definingVector;
    private Gravity gravity;

    private Paint   color;

    public Ball(double posX, double posY, Gravity gravity){
        this.gravity = gravity;

        this.diameter = 10;
        this.mass = 10;

        this.definingVector = new Vector(posX, posY, posX, posY);
        this.color = Paint.valueOf("red");
    }

    public void update(){
        gravity.gravitize(this);
        move();
    }
    public void draw(GraphicsContext gc){
        gc.setFill(color);
        gc.fillOval(definingVector.getBeginX(), definingVector.getBeginY(), diameter, diameter);
    }

    public void move(){
        definingVector.transfer();
    }
    public Vector getDefiningVector() {
        return definingVector;
    }
}
