package chapter14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Experimented with values and colors. Added a rectangle.
 * 
 * @author Marshall Ehlinger
 */
public class Ex03ShowCircle extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a circle and set its properties
        Circle circle = new Circle();
        circle.setCenterX(100);
        circle.setCenterY(100);
        circle.setRadius(50);
        circle.setStroke(Color.BLUE);
        circle.setFill(Color.ALICEBLUE);
        
        Circle circle2 = new Circle();
        circle2.setCenterX(100);
        circle2.setCenterY(200);
        circle2.setRadius(50);
        circle2.setStroke(Color.BLACK);
        circle2.setFill(Color.LIGHTGOLDENRODYELLOW);
        
        Rectangle rect = new Rectangle();
        rect.setX(150);
        rect.setY(100);
        
        rect.setWidth(400);
        rect.setHeight(100);
        
        rect.setArcHeight(30);
        rect.setArcWidth(30);
        
        rect.setStroke(Color.RED);
        rect.setFill(Color.BISQUE);

        // Create a pane to hold the circle 
        Pane pane = new Pane();
        pane.getChildren().add(circle);
        pane.getChildren().add(circle2);
        pane.getChildren().add(rect);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Sometimes shapes are just shapes."); // Set the stage title
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
