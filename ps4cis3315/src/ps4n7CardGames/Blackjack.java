
import java.util.Scanner;

package ps4n7CardGames;

/**
 *
 * @author Marshall Ehlinger
 */
public class Blackjack {
    
    public static void main (String[] args) {

        CardStack deck = new CardStack();
        deck.shuffle();

        int playerScore;
        int dealerScore;

        boolean playerHit;
        boolean dealerHit;

        ArrayList playerHand;
        ArrayList dealerHand;

        Scanner sc = new Scanner();

        boolean playing = true;


        // Dealerbot gets cards, one face down, one up
        dealerHand.add(deck.draw());
        dealerHand.get(0).setIsHidden(true);
        dealerHand.add(deck.draw());
        // Player gets 2 cards
        playerHand.add(deck.draw());
        playerHand.add(deck.draw());
        // Check for nat 21s 
        if (anyNat21) {
            player = false;
        }

        while (playing) {
            // Set the playerHit and dealerHit counters back to 0 for the new turn
            playerHit = false;
            dealerHit = false;
            // Print player hand and dealerbot hand.
            printHand(playerHand, "Your");
            printHand(dealerHand, "Dealerbot");
            // Will player hit? Add card to hand if so, and add card val to score.
            response = getLine(sc, "Will you hit? Y or N: ", "Y|N");
            if (response == "Y") {
                playerHand.add(deck.draw());
                addToScore(playerHand.get(playerHand.size - 1), playerScore);
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
                dealerHand.add(deck.draw());
            }
            // Is bot bust? If so, set winner and break.
            if (isBust(dealerScore)) {
                System.out.println("You win!");
                break;
            }
            // Did neither player hit? If so, check for winner by comparing the two.
            if (playerHit == false && dealerHit == false) {
                whoWon(playerScore, dealerScore);
            }
        }
    }


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

    public static Card hit() {
        return(deck.draw());
    }

    public static boolean willDealerHit(int dealerScore) {
        if (dealerScore < 17) {
            dealerHit = true;
            return true;
        }
        return false;
    }

    public void printHand (ArrayList cards, String whoseHand) {
        System.out.print(whoseHand + " hand: ");
        for (int i = 0; i < cards.length; i++) {
            System.out.print(cards[i].toString());
        }
    }

    public static boolean isBust(int score) {
        if (score > 21) {
            return true;
        }
        return false;
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
