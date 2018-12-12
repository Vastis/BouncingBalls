package simCore;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import main.Main;

/**
 * Simulation core.
 */

public class SimulationManager {

    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private SimulationParameters simParams;

    private CanvasCleaner canvasCleaner;
    private SimulationEnvironment simEnvironment;

    public SimulationManager(Canvas canvas, SimulationParameters simParams){
        this.canvas = canvas;
        this.graphicsContext = canvas.getGraphicsContext2D();
        this.simParams = simParams;

        this.simEnvironment = new SimulationEnvironment(simParams);
        this.canvasCleaner = new CanvasCleaner(canvas);
    }

    public void runSimulation() {
        new Thread(() -> simulationLoop()).start();
    }

    private void simulationLoop() {
        double fps = 60.0;
        long lastTime = System.nanoTime();
        final double ns = 1000000000.0 / fps;
        double delta = 0;

        while (Main.running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                update();
                draw();
                delta--;
            }
        }
    }

    private void update(){
        simEnvironment.update();
    }
    private void draw(){
        canvasCleaner.refresh();
        simEnvironment.draw(graphicsContext);
    }




}
