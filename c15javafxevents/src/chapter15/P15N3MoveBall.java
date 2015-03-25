package chapter15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

/**
 * P15N3MoveBall.java Write a program that moves the ball in a pane. You should
 * define a pane class for displaying the ball and provide the methods for
 * moving the ball left, right, up, and down. Check the boundary to prevent the
 * ball from moving out of sight completely.
 *
 * @author Marshall Ehlinger
 */
public class P15N3MoveBall extends Application {
    
        @Override
        public void start(Stage primaryStage) {
            BallControlPane bPane = new BallControlPane();
            
            bPane.setOnKeyPressed(e ->  {
                if (e.getCode() == KeyCode.UP) {
                    bPane.keyUp();
                } else if (e.getCode() == KeyCode.DOWN) {
                    bPane.keyDown();
                } else if (e.getCode() == KeyCode.LEFT) {
                    bPane.keyLeft();
                } else if (e.getCode() == KeyCode.RIGHT) {
                    bPane.keyRight();
                } else if (e.getCode() == KeyCode.SPACE) {
                    bPane.brake();
                }
            });
                        
            Scene scene = new Scene(bPane, 500, 500);
            primaryStage.setTitle("Move Tha' Ball");
            primaryStage.setScene(scene);
            primaryStage.show();
            
            bPane.requestFocus();
            
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
