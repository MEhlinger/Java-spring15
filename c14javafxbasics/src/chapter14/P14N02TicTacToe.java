
package chapter14;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Marshall Ehlinger
 */
public class P14N02TicTacToe extends Application {
    Button[] btn = new Button[9];
    int count = 1;
    @Override
    public void start(Stage primaryStage) {
        GridPane gpane = new GridPane();

        // Create buttons
        for (int i = 0; i < btn.length; i++) {
            btn[i] = new Button();
            btn[i].setText("");
            btn[i].setMinWidth(40);
            btn[i].setMinHeight(40);
            btn[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Button b = (Button) event.getSource();
                    b.setText(count++ % 2 == 0 ? "X" : "O");
                }
            });
        }

        // Place buttons on gridpane
        for (int row = 0; row < 3; row++){
            for (int col = 0; col < 3; col++) {
                gpane.add(btn[row * 3 + col], col, row);
            }
        }
        
//        Button btn00 = new Button();
//        btn00.setText("X");
//        btn00.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
//        
//        Button btn01 = new Button();
//        btn01.setText("O");
//        btn01.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
//        
//        
//        gpane.getChildren().add(btn00);
//        gpane.getChildren().add(btn01);
        
        Scene scene = new Scene(gpane, 300, 250);
        
        primaryStage.setTitle("Hello World!");
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
