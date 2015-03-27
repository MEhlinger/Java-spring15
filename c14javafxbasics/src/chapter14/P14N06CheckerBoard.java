package chapter14;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Marshall Ehlinger
 * PVP checkers deathmatch, yo.
 * For Data Structures / Java class, Spring 2015
 */
public class P14N06CheckerBoard extends Application {
    int count = 0;
    final Button[][] btn = new Button[8][8];
    
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        borderPane.setStyle("-fx-background-color: #AAAAAA");
        
        gp.setHgap(1);
        gp.setVgap(1);
        borderPane.setCenter(gp);
        
        Label lblTitle = new Label("Dope Checkers");
        lblTitle.setFont(Font.font(16));
        BorderPane.setAlignment(lblTitle, Pos.CENTER);
        borderPane.setTop(lblTitle);
        
        Button playAgain = new Button("Play Again");
        playAgain.setFont(Font.font(16));
        BorderPane.setAlignment(playAgain, Pos.CENTER);
        borderPane.setBottom(playAgain);
        
        for (int i = 0; i < btn.length; i++) {
            for (int j = 0; j < btn[i].length; j++) {
                btn[i][j] = new Button("");
                btn[i][j].setMinWidth(40);
                btn[i][j].setMinHeight(40);
                
                if ((i+j) % 2 == 0) {
                    btn[i][j].setStyle("-fx-base: #FF0000");
                } else {
                    btn[i][j].setStyle("-fx-base: #333333");
                }
                
                btn[i][j].setOnAction(e -> {
                   Button b = (Button) e.getSource();
                   System.out.println("ROW= " + GridPane.getRowIndex(b));
                   System.out.println("COL= " + GridPane.getColumnIndex(b));
                });
            }
        }
        for (int col = 0; col < btn.length; col++) {
            for (int row = 0; row < btn[col].length; row++) {
                gp.add(btn[row][col], col, row);
            }
        }
        
        borderPane.setBottom(playAgain);
        
        
        Scene scene = new Scene(borderPane, 500, 500);
        
        primaryStage.setTitle("Check Yoself before you Checker Yoself");
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
