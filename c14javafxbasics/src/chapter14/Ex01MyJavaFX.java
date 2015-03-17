package chapter14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Changed the button text and title.
 *
 * @author Marshall Ehlinger
 */
public class Ex01MyJavaFX extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a button and place it in the scene
        
        Button btUne = new Button("I Can't Let You Do That, Dave");
        Scene scene = new Scene(btUne, 500, 150);
        primaryStage.setTitle("Le Premiere Chose"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * The main method is only needed for the IDE with limited JavaFX support.
     * Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
