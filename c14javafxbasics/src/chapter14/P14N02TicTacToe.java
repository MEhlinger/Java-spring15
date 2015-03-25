
package chapter14;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
 */
public class P14N02TicTacToe extends Application {
    
    Button[] btn = new Button[9];
    int count = 0;
    boolean gameOver = false;
    int xScore, oScore, catScore = 0;
            
    @Override
    public void start(Stage primaryStage) {
        BorderPane borderpane = new BorderPane();
        GridPane gpane = new GridPane();
        gpane.setAlignment(Pos.CENTER);
        borderpane.setCenter(gpane);
        
        // Set label with scores
        Label ltitle = new Label("Player X : " + xScore + " Player O : " + oScore +  " Cat : " + catScore);
        ltitle.setFont(Font.font(18));
        BorderPane.setAlignment(ltitle, Pos.CENTER);
        borderpane.setTop(ltitle);
        
        
        // Create buttons
        for (int i = 0; i < btn.length; i++) {
            btn[i] = new Button();
            btn[i].setText("");
            btn[i].setMinWidth(40);
            btn[i].setMinHeight(40);
            
            // Button press handler
            btn[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Button b = (Button) event.getSource();
                    if(!gameOver && b.getText().equals("")) {
                        b.setText(count++ % 2 == 0 ? "X" : "O");

                        if (isWinner("X")) {
                            xScore++;
                            gameOver = true;
                        }
                        if (isWinner("O")) {
                            oScore++;
                            gameOver = true;
                        } else if (count == 9) {
                            catScore++;
                            gameOver = true;
                        }
                    }

                    ltitle.setText("Player X : " + xScore + " Player O : " + oScore +  " Cat : " + catScore);
                }
            });
        }

        // Place buttons on gridpane
        for (int row = 0; row < 3; row++){
            for (int col = 0; col < 3; col++) {
                gpane.add(btn[row * 3 + col], col, row);
            }
        }
        
        Button playAgain = new Button("Play Again");
        playAgain.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (gameOver) {
                    for (int i = 0; i < btn.length; i++) {
                        btn[i].setText("");
                    }
                    count = 0;
                    
                    gameOver = false;
                }
            }
        });
        
        borderpane.setBottom(playAgain);
        BorderPane.setAlignment(playAgain, Pos.CENTER);
        Scene scene = new Scene(borderpane, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public boolean isWinner(String s){
        return  //check rows 
                   btn[0].getText().equals(s) && btn[1].getText().equals(s) && btn[2].getText().equals(s)
                || btn[3].getText().equals(s) && btn[4].getText().equals(s) && btn[5].getText().equals(s)
                || btn[6].getText().equals(s) && btn[7].getText().equals(s) && btn[8].getText().equals(s)
                // check columns
                || btn[0].getText().equals(s) && btn[3].getText().equals(s) && btn[6].getText().equals(s)
                || btn[1].getText().equals(s) && btn[4].getText().equals(s) && btn[7].getText().equals(s)
                || btn[2].getText().equals(s) && btn[5].getText().equals(s) && btn[8].getText().equals(s)
                // check diagonals
                || btn[0].getText().equals(s) && btn[4].getText().equals(s) && btn[8].getText().equals(s)
                || btn[6].getText().equals(s) && btn[4].getText().equals(s) && btn[2].getText().equals(s);
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}