package ps4n7CardGames;

import java.util.Scanner;
import myutil.Validator;

/**
 *
 * @author Marshall Ehlinger
 */
public class Card21ConsoleApp {
    private Game21 game = new Game21();
    private Scanner sc = new Scanner(System.in);
    
    public Card21ConsoleApp() {
        playGame();
    }

    public final void playGame() {
        String choice;
        
        while (true) {
            if (game.isGameOver()) {
                game.newGame();
                game.setGameOver(false);
                System.out.println("***** BLACKJACK / 21 *****");
            }
            
            System.out.println("Player's hand: " + game.getHandString(game.getPlayerHand()));
            System.out.println("Dealer's hand: " + game.getHandString(game.getDealerHand()));
            choice = Validator.getLine(sc, "X = exit, H = hit me, S = stand. Enter your choice: ", "^[XHSxhs]$");
            if(choice.equalsIgnoreCase("H")) {
                System.out.println("Hitting you...");
                game.hit(game.getPlayerHand());
                if (game.busted(game.getPlayerHand())) {
                    System.out.println(game.getWinnerString());
                }
            } else if(choice.equalsIgnoreCase("S")) {
                System.out.println("Standing...");
                while(game.getHandScore(game.getDealerHand()) < 17) {
                    game.hit(game.getDealerHand());
                    System.out.println("Dealer: " + game.getHandString(game.getDealerHand()));
                }
                System.out.println(game.getWinnerString());
            } else {
               break;
            }
            
        }
    }
    
    public static void main(String[] args) {
        Card21ConsoleApp app = new Card21ConsoleApp();
    }
}
