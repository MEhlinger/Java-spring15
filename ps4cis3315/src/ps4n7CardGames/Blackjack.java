package ps4n7CardGames;

import java.util.ArrayList;
import java.util.Scanner;
import static myutil.Validator.getLine;

/**
 *
 * @author Marshall Ehlinger
 */
public class Blackjack {
    
    public static void main (String[] args) {

        CardStack deck = new CardStack();
        deck.shuffle();

        int playerScore = 0;
        int dealerScore = 0;

        boolean playerHit = false;
        boolean dealerHit = false;

        ArrayList<Card> playerHand = new ArrayList<Card>();
        ArrayList<Card> dealerHand = new ArrayList<Card>();

        Scanner sc = new Scanner(System.in);

        boolean playing = true;
        
        Card newCard; // Used for adding new draws to score


        // Dealerbot gets cards, one face down, one up
        hit(deck, dealerHand);
        newCard = dealerHand.get(0);
        newCard.setIsHidden(true);
        newCard = (dealerHand.get(dealerHand.size() - 1));
        dealerScore = addToScore(newCard, dealerScore);
        hit(deck, dealerHand);
        newCard = (dealerHand.get(dealerHand.size() - 1));
        dealerScore = addToScore(newCard, dealerScore);
        
        // Player gets 2 cards
        hit(deck, playerHand);
        newCard = (playerHand.get(playerHand.size() - 1));
        playerScore = addToScore(newCard, playerScore);
                
        hit(deck, playerHand);
        newCard = (playerHand.get(playerHand.size() - 1));
        playerScore = addToScore(newCard, playerScore);
      
        // Check for nat 21s 
        if (anyNat21(playerScore, dealerScore)) {
            playing = false;
        }

        while (playing) {
            // Set the playerHit and dealerHit counters back to 0 for the new turn
            playerHit = false;
            dealerHit = false;
            
            // Print player hand and dealerbot hand.
            printHand(playerHand, "Your");
            printHand(dealerHand, "Dealerbot");
            
            // Will player hit? Add card to hand if so, and add card val to score.
            String response = getLine(sc, "Will you hit? Y or N: \n", "Y|N");
            if ("Y".equals(response)) {
                hit(deck, playerHand);
                newCard = (playerHand.get(playerHand.size() - 1));
                playerScore = addToScore(newCard, playerScore);
                playerHit = true;
            }
            
            // Is player bust? If so, set winner and break;
            if (isBust(playerScore)) {
                System.out.println("Dealerbot wins!");
                break;
            }
            
            // Print player hand and dealerbot hand.
            printHand(playerHand, "Your");
            printHand(dealerHand, "Dealerbot");
            
            // Will bot hit? Add card to hand, and add card value to bot score.
            if (willDealerHit(dealerScore)) {
                hit(deck, dealerHand);
                newCard = (dealerHand.get(dealerHand.size() - 1));
                dealerScore = addToScore(newCard, dealerScore);
                dealerHit = true;
            }
            
            // Is bot bust? If so, set winner and break.
            if (isBust(dealerScore)) {
                System.out.println("You win!");
                
                break;
            }
            
            // Did neither player hit? If so, check for winner by comparing the two.
            if (playerHit == false && dealerHit == false) {
                whoWon(playerScore, dealerScore);
                break;
            }
            
            System.out.println("-------next-round--------");
        }
        
        System.out.println("---------GAME------OVER----------");
        System.out.println("Finals Hands:");
        
        newCard = dealerHand.get(0);
        newCard.setIsHidden(false);
        
        printHand(playerHand, "Your");
        printHand(dealerHand, "Dealerbot");
        
        System.out.println("Your final score: " + playerScore);
        System.out.println("Dealerbot's final score: " + dealerScore);
    }

    
    // NON-MAIN METHODS

    public static int cardPointValue(Card card) {
        if (card.getRANK_VALUE() > 7) {
            return 10;
        } else if (card.getRANK_VALUE() == 12) {
            return 11; // Ace value variability handles in addToScore()
        }
        return card.getRANK_VALUE() + 2;
    }
    
    public static int addToScore(Card newCard, int score) {
        // Checks to see if it's an ace, adjusts ace to 1 if (score += 11) > 21
        int newScore = score + cardPointValue(newCard);
        if (newScore > 21 && newCard.getRANK_VALUE() == 12) {
            score -= 10; // Adjust for the difference between a high ace and a low ace (11 to 1)
        }
        return newScore;
    }

    public static boolean willDealerHit(int dealerScore) {
        return (dealerScore < 17);
    }
    
    public static void hit(CardStack deck, ArrayList hand) {
        if (!deck.empty()) {
            hand.add(deck.pop());
        } else {
            System.out.println("Draw failed: cannot draw from an empty deck!");
        }
    }

    public static void printHand (ArrayList cards, String whoseHand) {
        System.out.print(whoseHand + " hand: ");
        for (int i = 0; i < cards.size(); i++) {
            System.out.print(cards.get(i).toString() + " / ");
        }
        System.out.print("\n\n");
    }

    public static boolean isBust(int score) {
        return (score > 21);
    }

    public static void whoWon(int playerScore, int dealerScore) {
        if (dealerScore == playerScore) {
            System.out.println("Push! A tie, and player is returned their bet.");
        } else if (playerScore > dealerScore) {
            System.out.println("You win!");
        } else if (playerScore < dealerScore) {
            System.out.println("Dealerbot wins! Puny human, can you even count?");
        }
    }

    public static boolean anyNat21(int playerScore, int dealerScore) {
        if (dealerScore == playerScore && playerScore == 21) {
            System.out.println("Push! A tie, and player is returned their bet.");
            return true;
        } else if (playerScore == 21) {
            System.out.println("You win!");
            return true;
        } else if (dealerScore == 21) {
            System.out.println("Dealerbot wins! Puny human, can you even count?");
            return true;
        }
        return false;
    }
}
