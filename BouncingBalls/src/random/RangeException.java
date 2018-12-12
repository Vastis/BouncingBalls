package random;

import javafx.scene.control.Alert;

public class RangeException extends Exception {
    public RangeException(){
        new Alert(Alert.AlertType.WARNING, "Generator's method input arguments invalid").show();
    }
}
