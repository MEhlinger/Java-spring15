package ps5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
            
       for (int i = 0; i < cardFiles.length; i++) {
           cardFiles[i] = new Image("mycards/c" + i + ".gif");
       }
       
       lblDealer.setText("DEALER: 00");
       lblDealer.setStyle("-fx-font-size: 22pt; -fx-font-weight: bolder; -fx-text-fill: #665544; -fx-padding: 20");
       lblPlayer.setText("PLAYER: 00");
       lblPlayer.setStyle("-fx-font-size: 22pt; -fx-font-weight: bolder; -fx-text-fill: #445566; -fx-padding: 20");
       
       pnDealer = new HBox(-80);
       pnPlayer = new HBox(-80);
       
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
       
       HBox pnButtons = new HBox();
       
       btnHit = new Button("Hit");
       
       btnStand = new Button("Stand");
       
       btnNew = new Button("New");
       btnNew.setOnAction(e -> newGame());
       
       pnButtons.getChildren().addAll(btnHit, btnStand, btnNew);
       
       BorderPane pnBorder = new BorderPane();
       pnBorder.setCenter(pnGrid);
       pnBorder.setBottom(pnButtons);
              
        
        Scene scene = new Scene(pnBorder, 500, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void newGame() {
        //pnDealer.getChildren().addAll(new ImageView(cardFiles[52]), new ImageView(cardFiles[0]));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
