package simCore;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class CanvasCleaner {

    private Canvas canvas;
    private GraphicsContext context;

    public CanvasCleaner(Canvas canvas){
        this.canvas = canvas;
        this.context = canvas.getGraphicsContext2D();
    }

    public void refresh(){
        context.clearRect(0,0, canvas.getWidth(), canvas.getHeight());
        context.setFill(Paint.valueOf("black"));
        context.fillRect(0,0, canvas.getWidth(), canvas.getHeight());
    }
}
