package simCore;

import javafx.scene.canvas.GraphicsContext;
import movement.Gravity;
import random.Generator;
import random.RangeException;
import simObjects.Ball;
import simObjects.Floor;

import java.util.ArrayList;

public class SimulationEnvironment {

    private SimulationParameters simParams;
    private Generator generator;

    private ArrayList<Ball> balls;
    private Floor floor;
    private Gravity gravity;


    public SimulationEnvironment(SimulationParameters simParams){
        this.simParams = simParams;
        prepareEnvironment();
    }

    private void prepareEnvironment(){
        initialize();
        try {
            generateFloor();
            generateBalls();
        } catch (RangeException e){}
    }

    private void initialize(){
        this.generator = new Generator();
        this.balls = new ArrayList<>();
        this.gravity = new Gravity(simParams.getGravity());
    }
    private void generateFloor() throws RangeException {
        double debounceCoefficient = generator.nextDouble(0.1, 0.3);
        this.floor = new Floor(debounceCoefficient);
    }
    private void generateBalls(){
        for(int i = 0; i < simParams.getLeftBalls(); i++){

        }
        for(int i = 0; i < simParams.getRightBalls(); i++){

        }

        balls.add(new Ball(300, 0, gravity));
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
    public Floor getFloor() {
        return floor;
    }
    public Gravity getGravity() {
        return gravity;
    }
}
