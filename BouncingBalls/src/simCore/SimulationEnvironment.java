package simCore;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import movement.Gravity;
import random.Generator;
import random.RangeException;
import simObjects.Ball;
import simObjects.Bounds;

import java.util.ArrayList;

public class SimulationEnvironment {

    private AnchorPane drawingPanel;
    private SimulationParameters simParams;
    private Generator generator;

    private ArrayList<Ball> balls;
    private Bounds bounds;
    private Gravity gravity;


    public SimulationEnvironment(AnchorPane drawingPanel, Rectangle bounds, SimulationParameters simParams){
        this.drawingPanel = drawingPanel;
        this.simParams = simParams;
        prepareEnvironment(bounds);
    }

    private void prepareEnvironment(Rectangle bounds){
        initialize();
        try {
            setBounds(bounds);
            generateBalls();
        } catch (RangeException e){}
    }

    private void initialize(){
        this.generator = new Generator();
        this.balls = new ArrayList<>();
        this.gravity = new Gravity(simParams.getGravity());
    }
    private void setBounds(Rectangle bounds) throws RangeException {
        double bounceCoefficient = generator.nextDouble(0.8, 0.99);
        this.bounds = new Bounds(bounds, bounceCoefficient);
    }
    private void generateBalls(){
        for(int i = 0; i < simParams.getLeftBalls(); i++){
            balls.add(new Ball(false, simParams.getInitSpeed(), bounds, gravity));
        }
        for(int i = 0; i < simParams.getRightBalls(); i++){
            balls.add(new Ball(true, simParams.getInitSpeed(), bounds, gravity));
        }
        for(Ball ball : balls)
            drawingPanel.getChildren().add(ball.getBall());
    }

    public void update(){
        for(Ball ball : balls){
            ball.update();
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
