package main;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import simCore.SimulationManager;
import simCore.SimulationParameters;


/**
 * JavaFX controller, associated with mainWindow (mainWindow.fxml).
 */

public class MainWindowController {

    @FXML
    private AnchorPane drawingPanel;
    @FXML
    private Rectangle bounds;
    @FXML
    private TextField   leftSideBallsTextField,
                        rightSideBallsTextField,
                        gravityTextField,
                        initBallsSpeedTextField;
    @FXML
    private Button startButton;

    @FXML
    protected void initialize(){
        bounds.setFill(Color.BLACK);
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
            startButton.setDisable(true);

            SimulationManager simManager = new SimulationManager(drawingPanel, bounds, simParams);
            simManager.runSimulation();

        } catch(NumberFormatException e) {
            new Alert(Alert.AlertType.WARNING, "Invalid input data!").show();
        }
    }

}
