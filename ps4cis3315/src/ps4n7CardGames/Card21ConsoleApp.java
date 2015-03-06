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
                displayScoreBoard();
            }
            choice = displayMenu();
            
            if(choice.equalsIgnoreCase("H")) {
                System.out.println("Hitting you...");
                game.hit(game.getPlayerHand());
                System.out.println("Player drew: " + game.handPeek(game.getPlayerHand()));
                checkBusted(game.getPlayerHand());
                System.out.println("Player score: " + game.getHandScore(game.getPlayerHand()));
                
            } else if(choice.equalsIgnoreCase("S")) {
                System.out.println("Standing...");
                dealerAi();
                System.out.println(game.getWinnerString() + "\n\n");
            } else {
               break;
            }
            
        }
    }
    
    private void displayScoreBoard() {
        System.out.println("********************************");
        System.out.println("***      BLACKJACK / 21      ***");
        System.out.println("***        SCOREBOARD        ***");
        System.out.println("***   Dealer=    Player=     ***");
        System.out.println("********************************");
    }
    
    private String displayMenu() {
        System.out.println("Player's hand: " + game.getHandString(game.getPlayerHand()));
        System.out.println("Dealer's hand: " + game.getHandString(game.getDealerHand()));
        return Validator.getLine(sc, "\nX = exit, H = hit me, S = stand. \nEnter your choice: ", "^[XHSxhs]$");
    }
    
    private void checkBusted(CardHand hand) {
        if (game.busted(hand)) {
            System.out.println(game.getWinnerString());
        }
    }
    
    private void dealerAi() {
        while(game.getHandScore(game.getDealerHand()) < 17) {
            game.hit(game.getDealerHand());
            System.out.println("Dealer drew: " + game.handPeek(game.getDealerHand()));
            System.out.println();
            System.out.println("Dealer: " + game.getHandString(game.getDealerHand()));
            System.out.println("Dealer score: " + game.getHandScore(game.getDealerHand()));
        }
    }
    
    public static void main(String[] args) {
        Card21ConsoleApp app = new Card21ConsoleApp();
    }
}
