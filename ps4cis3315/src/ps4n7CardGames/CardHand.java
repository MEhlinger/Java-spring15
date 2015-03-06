package ps4n7CardGames;

/**
 *
 * @author Marshall Ehlinger
 */
public class CardHand {
    private Card [] hand;
    private int numCards;
    
    public CardHand() {
        hand = new Card[52];
        numCards = 0;
    }
    
    public Card[] getHand() {
        Card[] cArray = new Card[numCards];
        for (int i = 0 ; i < numCards; i++) {
            cArray[i] = hand[i];
        }
        return cArray;
    }
    
    public void addCard(Card c) {
        // Add a card to the hand
        hand[numCards++] = c;
    }
    
    public Card peek() {
        return hand[numCards];
    }
    
    public int score21() {
        // Stub
        int score = 0;
        int aces = 0;
        for (int i = 0; i < numCards; i++) {
            score += hand[i].getValue21();
            if (hand[i].getRANK_VALUE() == 12) {
                aces++;
            }
        }
        
        while (score > 21 && aces > 0) {
            aces--;
            score -= 10;
        }
        return score;
    }
    
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < numCards; i++) {
            s += hand[i].toString();
            s += " / ";
        }
        return s;
    }
    
}
