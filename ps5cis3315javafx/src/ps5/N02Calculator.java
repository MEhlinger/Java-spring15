package ps5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * N02Calculator Write a program that implements a simple business calculator.
 *
 * @author Marshall Ehlinger
 */
public class N02Calculator extends Application {

    GridPane gp = new GridPane();
    Button[][] btn = new Button[4][4];
    TextField tfResult;
    
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane bpane = new BorderPane();
        
        bpane.setCenter(gp);
        
        tfResult = new TextField(". . .");
        tfResult.setEditable(false);
        tfResult.setAlignment(Pos.BOTTOM_RIGHT);
        tfResult.setFont(Font.font("Monospace", 36));
        tfResult.setMinWidth(400);
        bpane.setTop(tfResult);
        
        bpane.setCenter(getButtonGridPane());
        
        Scene scene = new Scene(bpane);
        
        primaryStage.setTitle("MarshallCalc");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    protected GridPane getButtonGridPane() {
        gp = new GridPane();
        String [][] buttonNameArray = {
            {"7", "8", "9", "/"},
            {"4", "5", "6", "*"},
            {"1", "2", "3", "-"},
            {"0", ".", "=", "+"}
        };
        
        ButtonHandler bh = new ButtonHandler();
        for (int row = 0; row < buttonNameArray.length; row++) {
            for (int col = 0; col < buttonNameArray[0].length; col++) {
                btn[row][col] = new Button(buttonNameArray[row][col]);
                btn[row][col].setStyle("-fx-base: #ad319f; -fx-font-size: 36 monospace");
                btn[row][col].setMinSize(80,80);
                
                btn[row][col].setOnAction(bh);
                gp.add(btn[row][col], col, row);
            }
        }
        return gp;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    class ButtonHandler implements EventHandler<ActionEvent> {
          
        @Override
        public void handle(ActionEvent event) {
            System.out.println("Button Clicked.");
        }
    }

}
