package main;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import simCore.SimulationManager;
import simCore.SimulationParameters;


/**
 * JavaFX controller, associated with mainWindow (mainWindow.fxml).
 */

public class MainWindowController {

    @FXML
    private Canvas mainCanvas;
    @FXML
    private AnchorPane managementPanel;
    @FXML
    private TextField   leftSideBallsTextField,
                        rightSideBallsTextField,
                        gravityTextField,
                        initBallsSpeedTextField;
    @FXML
    private Button startButton;

    public MainWindowController(){ }
    @FXML
    protected void initialize(){
        mainCanvas.getGraphicsContext2D().setFill(Paint.valueOf("black"));
        mainCanvas.getGraphicsContext2D().fillRect(0,0, mainCanvas.getWidth(), mainCanvas.getHeight());
    }

    @FXML
    private void start(){
        try {
            SimulationParameters simParams = new SimulationParameters(
                    Integer.parseInt(leftSideBallsTextField.getText()),
                    Integer.parseInt(rightSideBallsTextField.getText()),
                    Double.parseDouble(gravityTextField.getText().replace(',', '.')),
                    Double.parseDouble(initBallsSpeedTextField.getText().replace(',', '.'))
            );
            ////////tmp//////////
            simParams.printParams();
            /////////////////////
            startButton.setDisable(true);

            SimulationManager simManager = new SimulationManager(mainCanvas, simParams);
            simManager.runSimulation();

        } catch(NumberFormatException e) {
            new Alert(Alert.AlertType.WARNING, "Invalid input data!").show();
        }
    }

}
