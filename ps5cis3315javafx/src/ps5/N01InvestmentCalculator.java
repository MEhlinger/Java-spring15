package ps5;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * P15N5InvestmentCalculator Write a program that calculates the future value of
 * an investment at a given interest rate for a specified number of years. 
 *
 * @author Marshall Ehlinger
 */
public class N01InvestmentCalculator extends Application {
 
    private TextField tfInitInvest = new TextField("100");
    private TextField tfInterestRate = new TextField(".05");
    private TextField tfNumYears = new TextField("15");
    private Button calcB = new Button();

    
    @Override
    public void start(Stage primaryStage) {
        
        BorderPane wrapper = new BorderPane();
        GridPane pane = new GridPane();
        
        wrapper.setCenter(pane);
        
        
        pane.setHgap(20);
        pane.setVgap(5);
        
        Label title = new Label("INVESTMENT CALCULATOR");
        title.setFont(Font.font("Monospace", FontWeight.BOLD, 25));
        wrapper.setTop(title);
        
        pane.add(new Label("Initial Investment: "), 0, 0);
        pane.add(tfInitInvest, 1, 0);
        pane.add(new Label("Interest Rate: "), 0, 1);
        pane.add(tfInterestRate, 1, 1);
        pane.add(new Label("Number of Years: "), 0, 2);
        pane.add(tfNumYears, 1, 2);
        
        calcB.setText("Calculate Value");
        pane.add(calcB, 0, 3);
        
        Label lResult = new Label("Enter Values...");
        pane.add(lResult, 0, 4);
        
        calcB.setOnAction(e -> { 
            final double result = calculateInvestment();
            lResult.setText(Double.toString(result));
                });
        
        // UI Alignments
        BorderPane.setAlignment(title, Pos.CENTER);
        pane.setAlignment(Pos.CENTER);
        tfInitInvest.setAlignment(Pos.BOTTOM_RIGHT);
        tfInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
        tfNumYears.setAlignment(Pos.BOTTOM_RIGHT);
        calcB.setAlignment(Pos.BASELINE_CENTER);
        
        
        Scene scene = new Scene(wrapper, 500, 400);
        
        primaryStage.setTitle("Investment Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private double calculateInvestment() {
        // NOTE: no input validation.
        // KNOWN BUG: crashes if provided with empty textfield
        double init = Double.parseDouble(tfInitInvest.getText());
        double rate = Double.parseDouble(tfInterestRate.getText());
        double years = Double.parseDouble(tfNumYears.getText());
       
        return init + ((init * rate) * years);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
