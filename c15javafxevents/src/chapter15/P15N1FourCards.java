package chapter15;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * P15N1FourCards.java Write a program that lets the user click the Refresh button to
 display four cards from a deck of 52 cards.
 *
 * @author Marshall Ehlinger
 */
public class P15N1FourCards extends Application {

    /*@Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }*/
    
    @Override
    public void start(Stage primaryStage) {
        CardPane cPane = new CardPane();
        
        Button refresh = new Button();
        refresh.setText("REFRESH");
        
        refresh.setOnAction((ActionEvent e) -> { cPane.newCards(); });
        cPane.getChildren().add(refresh);
        
        Scene scene = new Scene(cPane, 500, 500);
        
        primaryStage.setTitle("CARDLIFE");
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