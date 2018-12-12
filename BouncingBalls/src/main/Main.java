package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Main ( is there any need to write anything else? ;) )
 */

public class Main extends Application {

    public static boolean running = true;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
        primaryStage.setOnCloseRequest((e) -> running = false);
        primaryStage.setTitle("");
        primaryStage.setResizable(false);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("main/mainWindow.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
