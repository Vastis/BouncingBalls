package simCore;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import main.Main;


/**
 * Simulation core.
 */

public class SimulationManager {

    private SimulationEnvironment simEnvironment;

    public SimulationManager(AnchorPane drawingPanel, Rectangle bounds, SimulationParameters simParams){
        this.simEnvironment = new SimulationEnvironment(drawingPanel, bounds, simParams);
    }

    public void runSimulation() {
        new Thread(() -> simulationLoop()).start();
    }

    private void simulationLoop() {
        double fps = 10.0;
        long lastTime = System.nanoTime();
        final double ns = 1000000000.0 / fps;
        double delta = 0;

        while (Main.running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                update();
                delta--;
            }
        }
    }

    private void update(){
        simEnvironment.update();
    }




}
