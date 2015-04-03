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

    private GridPane gp = new GridPane();
    private Button[][] btn = new Button[4][4];
    
    private TextField tfResult;
    
    private int calculationStep = 1;
    private double num1 , num2;
    private String operator, lastKeyPressed;
    
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane bpane = new BorderPane();
                
        tfResult = new TextField();
        tfResult.setEditable(false);
        tfResult.setAlignment(Pos.BOTTOM_RIGHT);
        tfResult.setFont(Font.font("Monospace", 36));
        tfResult.setMinWidth(400);
        bpane.setTop(tfResult);
        
        bpane.setCenter(getButtonGridPane());
        gp.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(bpane, 400, 500);
        
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
                btn[row][col].setStyle("-fx-base: #666666; -fx-font-size: 36 monospace");
                btn[row][col].setMinSize(80,80);
                
                btn[row][col].setOnAction(bh);
                gp.add(btn[row][col], col, row);
            }
        }
        return gp;
    }
    
    class ButtonHandler implements EventHandler<ActionEvent> {
          
        @Override
        public void handle(ActionEvent event) {
            
            
            Button b = (Button) event.getSource();
            System.out.println("Button Clicked is " + b.getText());
            switch (b.getText()) {
                case "/" : 
                case "*" : 
                case "+" : 
                case "-" : 
                    if (calculationStep == 2) {
                        calculate();
                    }
                    operator = b.getText();
                    tfResult.setText("");
                    calculationStep = 2;
                    break;
                case "=" :
                    if (lastKeyPressed.equals("=")) {
                        tfResult.setText("");
                        calculationStep = 1;
                        num1 = num2 = 0;
                    } else {
                        calculate();

                    }
                    break;
                default:
                    tfResult.setText(tfResult.getText() + b.getText());
                    if (calculationStep == 1) {
                        num1 = Double.parseDouble(tfResult.getText());
                    } else if (calculationStep == 2) {
                        num2 = Double.parseDouble(tfResult.getText());
                    }
            }
            lastKeyPressed = b.getText();

        }
        
        void calculate() {
            if (calculationStep == 2) {
                switch (operator) {
                    case "+": num1 = num1+num2;
                        break;
                    case "-": num1 = num1-num2;
                        break;
                    case "/": num1 = num1/num2;
                        break;
                    case "*": num1 = num1*num2;
                        break;
                }
                tfResult.setText("" + num1);
                calculationStep = 1;
                num2 = 0;
                operator = "";
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }



}
