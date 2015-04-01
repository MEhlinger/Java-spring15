package ps5;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * P15N1FourCards.java Write a program that lets the user click the Refresh button to
 display four cards from a deck of 52 cards.
 *
 * @author Marshall Ehlinger
 */
public class N03FourCards extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        BorderPane wrapper = new BorderPane();
        CardPane cPane = new CardPane();
        wrapper.setBottom(cPane);
        
        Button refresh = new Button();
        refresh.setText("REFRESH");
        
        refresh.setOnAction((ActionEvent e) -> { cPane.newCards(); });
        wrapper.setTop(refresh);
        
        Label label = new Label("Press refresh for new cards");
        label.setFont(Font.font("MONOSPACE", FontWeight.BOLD, 20));
        wrapper.setCenter(label);
        
        BorderPane.setAlignment(refresh, Pos.CENTER);
        BorderPane.setAlignment(label, Pos.CENTER);
        
        Scene scene = new Scene(wrapper, 500, 400);
        
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