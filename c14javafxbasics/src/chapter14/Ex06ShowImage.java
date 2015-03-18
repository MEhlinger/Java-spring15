package chapter14;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Experimented with ImageView. Tried displaying 3 random playing cards.
 *
 * @author Marshall Ehlinger
 */
public class Ex06ShowImage extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a pane to hold the image views
        Pane pane = new HBox(10);
        pane.setPadding(new Insets(5, 5, 5, 5));
        Image image = new Image("image/card/21.png");
        //Image image = new Image("http://www.cs.armstrong.edu/liang/image/us.gif");
        pane.getChildren().add(new ImageView(image));

        Image image2 = new Image("image/card/13.png");
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitHeight(100);
        imageView2.setFitWidth(100);
        pane.getChildren().add(imageView2);

        Image image3 = new Image("image/card/44.png");
        ImageView imageView3 = new ImageView(image3);
        imageView3.setRotate(90);
        pane.getChildren().add(imageView3);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("ShowImage"); // Set the stage title
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
