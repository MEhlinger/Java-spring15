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
    
    public static boolean hasWon(int score) {
        // STUB
        return false;
    }
    
    
}
