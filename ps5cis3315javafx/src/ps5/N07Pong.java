package ps5;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * N07Pong.java Write a program that plays the game of pong.
 * A single-player game of pong, mind you.
 *
 * @author Marshall Ehlinger
 * 
 */
public class N07Pong extends Application {

    @Override
    public void start(Stage primaryStage) {
        N07PongPane pongPane = new N07PongPane();
       
        pongPane.setOnMouseClicked(e -> pongPane.reset());
        
        pongPane.setOnMouseMoved(e -> pongPane.paddleMove(e.getY()));
        
        
        Scene scene = new Scene(pongPane, 425, 400);
        scene.cursorProperty().setValue(Cursor.NONE);
        
        primaryStage.setTitle("PONG- by Marshall");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
