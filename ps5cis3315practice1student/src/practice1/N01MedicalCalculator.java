package practice1;

import java.text.DecimalFormat;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import static javafx.scene.text.Font.font;
import javafx.stage.Stage;

/**
 * N01MedicalCalculator Write a program that converts a patient's weight from
 * pounds to kilograms and from kilograms to pounds. Your program should look
 * like the attached practiceMedicalCalculator.png file. 
 * 
 * kilograms = pounds * 2.2
 * pounds = kilograms / 2.2
 *
 * @author Your name here
 */
public class N01MedicalCalculator extends Application {

    private Label lblTitle = new Label("Convert Patient Weight");
    private TextField tfWeight = new TextField();
    private RadioButton rbP2K = new RadioButton("Convert Pounds to Kilograms");
    private RadioButton rbK2P = new RadioButton("Convert Kilograms to Pounds");
    private Button btCalculate = new Button("Convert Weight");
    private Label lblResult = new Label("");
    private String operation = "";
    private double result;
    DecimalFormat outputFormat = new DecimalFormat("#.00");

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create UI
        VBox pane = new VBox(30);
        pane.getChildren().addAll(lblTitle, tfWeight);
        lblTitle.setAlignment(Pos.CENTER);
        tfWeight.setAlignment(Pos.CENTER);
        VBox bottomPane = new VBox(30);
        bottomPane.getChildren().addAll(rbP2K, rbK2P, btCalculate, lblResult);
        pane.getChildren().add(bottomPane);
        bottomPane.setAlignment(Pos.CENTER);
        

        lblTitle.setStyle("-fx-font-size: 22pt; -fx-text-fill: red");
        tfWeight.setStyle("-fx-font-size: 22pt; -fx-text-fill: green");
        lblResult.setStyle("-fx-font-size: 22pt; -fx-text-fill: blue");
        
        // Add button toggle group
        final ToggleGroup tgConversion = new ToggleGroup();
        rbP2K.setToggleGroup(tgConversion);
        rbK2P.setToggleGroup(tgConversion);
        tgConversion.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle,
                    Toggle new_Toggle) {
                if (rbP2K.isSelected()) {
                    operation = "p2k";
                } else if (rbK2P.isSelected()) {
                    operation = "k2p";
                }
            }
        });
        
        
        // Process button event
        btCalculate.setOnMouseClicked(e -> {
            if ("p2k".equals(operation)) {
                double pounds = Double.parseDouble(tfWeight.getText());
                result = pounds * 2.2;
                lblResult.setText(outputFormat.format(result));
            } else if ("k2p".equals(operation)) {
                double kilos = Double.parseDouble(tfWeight.getText());
                result = kilos / 2.2;
                lblResult.setText(outputFormat.format(result));
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 350, 450);
        primaryStage.setTitle("Medical Calculator"); // Set title
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
