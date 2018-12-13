package simObjects;

import collisionManagement.CollisionManager;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import movement.Gravity;
import movement.Vector;
import random.Generator;
import random.RangeException;

public class Ball {

    private final Paint[] colors = {
            Paint.valueOf("red"),
            Paint.valueOf("blue"),
            Paint.valueOf("gray"),
            Paint.valueOf("yellow"),
            Paint.valueOf("green")
    };

    private double  diameter,
                    mass;

    //beginX, beginY - current position
    //endX, endY - future position
    //moduleX, moduleY - "velocity"
    private Vector  definingVector;
    private CollisionManager collisionManager;

    private Bounds bounds;
    private Gravity gravity;

    private Paint   color;

    public Ball(boolean startingRight, double initSpeedParam, Bounds bounds, Gravity gravity){
        this.bounds = bounds;
        this.gravity = gravity;
        this.collisionManager = new CollisionManager(this, bounds);

        setLookParams();
        setMovementParams(startingRight, initSpeedParam);
    }

    private void setLookParams(){
        Generator generator = new Generator();
        try {
            this.diameter = generator.nextDouble(5.0,20.0);
            this.color = colors[generator.nextInt(colors.length)];
        } catch (RangeException e) {
            e.printStackTrace();
        }
    }

    private void setMovementParams(boolean startingRight, double initSpeedParam){
        Generator generator = new Generator();
        double posX, posY = 0, initSpeed = 0;

        if(startingRight)
            posX = bounds.getRightBound();
        else
            posX = bounds.getLeftBound() - diameter;

        this.mass = this.diameter;

        try {
            posY = generator.nextDouble(bounds.getUpperBound(), bounds.getLowerBound());
            initSpeed = generator.nextDouble(initSpeedParam - 1.0, initSpeedParam + 1.0);
        } catch (RangeException e) {
            e.printStackTrace();
        }

        this.definingVector = new Vector(posX, posY, posX + initSpeed, posY);
    }

    public void update(){
        gravity.gravitize(this);
        collisionManager.checkCollision();
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
