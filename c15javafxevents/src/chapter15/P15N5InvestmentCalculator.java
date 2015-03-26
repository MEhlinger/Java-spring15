package chapter15;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * P15N5InvestmentCalculator Write a program that calculates the future value of
 * an investment at a given interest rate for a specified number of years. See
 * problem in your book for details.
 *
 * @author Marshall Ehlinger
 */
public class P15N5InvestmentCalculator extends Application {
 
    private TextField tfInitInvest = new TextField();
    private TextField tfInterestRate = new TextField();
    private TextField tfNumYears = new TextField();
    private Button calcB = new Button();

    
    @Override
    public void start(Stage primaryStage) {
        
        GridPane pane = new GridPane();
        
        
        pane.setHgap(20);
        pane.setVgap(5);
        
        pane.add(new Label("Initial Investment: "), 0, 0);
        pane.add(tfInitInvest, 1, 0);
        pane.add(new Label("Initial Investment: "), 0, 1);
        pane.add(tfInterestRate, 1, 1);
        pane.add(new Label("Initial Investment: "), 0, 2);
        pane.add(tfNumYears, 1, 2);
        
        calcB.setText("Calculate Value");
        pane.getChildren().add(calcB);
        
        Label lResult = new Label("Enter Values and Press Calculate...");
        pane.getChildren().add(lResult);
        
        calcB.setOnAction(e -> { 
            final double result = calculateInvestment();
            lResult.setText(Double.toString(result));
                });
        
        // UI Alignments
        pane.setAlignment(Pos.CENTER);
        tfInitInvest.setAlignment(Pos.BOTTOM_RIGHT);
        tfInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
        tfNumYears.setAlignment(Pos.BOTTOM_RIGHT);
        calcB.setAlignment(Pos.BASELINE_CENTER);
        
        
        Scene scene = new Scene(pane, 500, 400);
        
        primaryStage.setTitle("Loan Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private double calculateInvestment() {
        double init = 10;//Double.parseDouble(tfInitInvest.getText());
        double rate = .01;//Double.parseDouble(tfInterestRate.getText());
        double years = 20;//Double.parseDouble(tfNumYears.getText());
        return init + ((init * rate) * years);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
