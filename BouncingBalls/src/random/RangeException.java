package random;

import javafx.scene.control.Alert;

/**
 * Exception thrown when invalid arguments are passed whilst calling methods from Generator class.
 */
public class RangeException extends Exception {
    public RangeException(){
        new Alert(Alert.AlertType.WARNING, "Generator's method input arguments invalid").show();
    }
}
