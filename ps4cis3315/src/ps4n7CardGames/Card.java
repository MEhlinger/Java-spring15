package ps4n7CardGames;

/**
 *
 * @author Marshall Ehlinger
 */
public class Card {
   private final int CARD_VALUE; 
   private final int RANK_VALUE;
   private final String RANK;
   private final String SUIT;
   private boolean hidden;
   
   public Card(int cardValue, int rankValue, String rank, String suit) {
       this.CARD_VALUE = cardValue; //0 is 2 of clubs, 51 is ace of spades
       this.RANK_VALUE = rankValue; //0 is 2, 12 is Ace
       this.RANK = rank; 
       this.SUIT = suit;
       this.hidden = true; // hidden defaults to true if not passed a value
    }
   
   public Card(int cardValue, int rankValue, String rank, String suit, boolean isHidden) {
       this(cardValue, rankValue, rank, suit);
       this.hidden = isHidden;
       
    }

    public int getCARD_VALUE() {
        return CARD_VALUE;
    }

    public int getRANK_VALUE() {
        return RANK_VALUE;
    }

    public String getRANK() {
        return RANK;
    }

    public String getSUIT() {
        return SUIT;
    }

    public boolean isHidden() {
        return hidden;
    }
   
    public void setHidden(boolean hiding) {
        this.hidden = hiding;
    }
    
    @Override
    public String toString() {
        if (hidden) {
            return "Hidden Card";
        } 
        return (this.RANK + " of " + this.SUIT);
    }
    
    public int getValue21() {
        if (this.RANK_VALUE == 12) {
            return 11;
        }
        if (this.RANK_VALUE > 7) {
            return 10;
        }
        return this.RANK_VALUE + 2;
    }
}
