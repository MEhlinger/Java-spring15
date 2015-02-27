package ps4n7CardGames;

/**
 *
 * @author Marshall Ehlinger
 */
public class Blackjack {
    
    public static void main (String[] args) {
        Card c1 = new Card(0, 0, "False", "Clubs", false);
    }
    
    public static int cardPointValue(Card card) {
        if (card.getRANK_VALUE() > 7) {
            return 10;
        } else if (card.getRANK_VALUE() == 11) {
            return 11; // Ace value variability handles in addToScore()
        }
        return card.getRANK_VALUE() + 2;
    }
    
    public static int addToScore(Card newCard, int score) {
        // STUB
        // Checks to see if it's an ace, adjusts ace to 1 if (score += 11) > 21
        return 0;
    }
    
    public static boolean hasWon(int score) {
        // STUB
        return false;
    }
    
    
}
