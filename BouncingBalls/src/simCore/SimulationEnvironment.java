package simCore;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import movement.Gravity;
import random.Generator;
import random.RangeException;
import simObjects.Ball;
import simObjects.Bounds;

import java.util.ArrayList;

public class SimulationEnvironment {

    private Canvas canvas;
    private SimulationParameters simParams;
    private Generator generator;

    private ArrayList<Ball> balls;
    private Bounds bounds;
    private Gravity gravity;


    public SimulationEnvironment(Canvas canvas, SimulationParameters simParams){
        this.canvas = canvas;
        this.simParams = simParams;
        prepareEnvironment();
    }

    private void prepareEnvironment(){
        initialize();
        try {
            setBounds();
            generateBalls();
        } catch (RangeException e){}
    }

    private void initialize(){
        this.generator = new Generator();
        this.balls = new ArrayList<>();
        this.gravity = new Gravity(simParams.getGravity());
    }
    private void setBounds() throws RangeException {
        double bounceCoefficient = generator.nextDouble(0.8, 1.0);
        this.bounds = new Bounds(canvas, bounceCoefficient);
    }
    private void generateBalls(){
        for(int i = 0; i < simParams.getLeftBalls(); i++){

        }
        for(int i = 0; i < simParams.getRightBalls(); i++){

        }

        balls.add(new Ball(300, 0, bounds, gravity));
    }

    public void update(){
        for(Ball ball : balls){
            ball.update();
        }
    }

    public void draw(GraphicsContext gc){
        for(Ball ball : balls){
            ball.draw(gc);
        }
    }

    public ArrayList<Ball> getBalls(){
        return balls;
    }
    public Bounds getBounds() {
        return bounds;
    }
    public Gravity getGravity() {
        return gravity;
    }
}
