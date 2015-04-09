package ps5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * N04TwentyOne.java Write a program that plays the card game 21.
 *
 * @author Marshall Ehlinger
 */
public class N04TwentyOne extends Application {
    
    Image[] cardFiles = new Image[53];
    Label lblDealer  = new Label();
    Label lblPlayer = new Label();
    Button btnHit, btnStand, btnNew;
    HBox pnDealer, pnPlayer;


    @Override
    public void start(Stage primaryStage) {
            
        /* IMAGES AND LABELS*/
        
       for (int i = 0; i < cardFiles.length; i++) {
           cardFiles[i] = new Image("mycards/c" + i + ".gif");
       }
       
       lblDealer.setText("DEALER: 00");
       lblDealer.setStyle("-fx-font-size: 22pt; -fx-font-weight: bolder; -fx-text-fill: #665544; -fx-padding: 20");
       lblPlayer.setText("PLAYER: 00");
       lblPlayer.setStyle("-fx-font-size: 22pt; -fx-font-weight: bolder; -fx-text-fill: #445566; -fx-padding: 20");
       
       /* GRIDPANE */
       
       pnDealer = new HBox(-110);
       pnDealer.setPadding(new Insets(0,10,10,10));
       
       pnPlayer = new HBox(-110);
       pnPlayer.setPadding(new Insets(0,10,10,15));
       
       GridPane pnGrid = new GridPane();
       ColumnConstraints col1 = new ColumnConstraints();
       col1.setPercentWidth(50);
       ColumnConstraints col2 = new ColumnConstraints();
       col2.setPercentWidth(50);
       pnGrid.getColumnConstraints().addAll(col1, col2);
       
       pnGrid.add(lblDealer, 0, 0);
       pnGrid.add(pnDealer, 0, 1);
       pnGrid.add(lblPlayer, 1, 0);
       pnGrid.add(pnPlayer, 1, 1); 
       
       /* UI BUTTONS */
       
       HBox pnButtons = new HBox(20);
       String btnColor = "#ff4444";
       
       btnHit = new Button("Hit");
       btnHit.setMinWidth(150);
       btnHit.setStyle("-fx-font-size: 14pt; -fx-text-fill: " + btnColor);
       btnStand = new Button("Stand");
       btnStand.setMinWidth(150);
       btnStand.setStyle("-fx-font-size: 14pt; -fx-text-fill: " + btnColor);
       
       btnNew = new Button("New");
       btnNew.setMinWidth(150);
       btnNew.setStyle("-fx-font-size: 14pt; -fx-text-fill: " + btnColor);
       btnNew.setOnAction(e -> newGame());
       
       pnButtons.getChildren().addAll(btnHit, btnStand, btnNew);
       pnButtons.setAlignment(Pos.CENTER);
       
       /* ROOT PANE, SCENE, AND STAGE */
       
       BorderPane pnBorder = new BorderPane();
       pnBorder.setCenter(pnGrid);
       pnBorder.setBottom(pnButtons);
              
        
        Scene scene = new Scene(pnBorder, 750, 400);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void newGame() {
        pnDealer.getChildren().addAll(new ImageView(cardFiles[52]), new ImageView(cardFiles[0]));
        pnPlayer.getChildren().addAll(new ImageView(cardFiles[42]), new ImageView(cardFiles[15]));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
