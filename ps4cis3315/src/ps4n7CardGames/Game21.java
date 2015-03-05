package ps4n7CardGames;

/**
 *
 * @author Marshall Ehlinger
 * 
 * This version completed along with class.
 * All aces high.
 */
public class Game21 {
    
    private CardStack deck = new CardStack();
    private CardHand playerHand = new CardHand();
    private CardHand dealerHand = new CardHand();
    private boolean gameOver;
    
    public Game21() {
        gameOver = true;
    }
    
    public void newGame() {
        deck = new CardStack();
        playerHand = new CardHand();
        dealerHand = new CardHand();
        
        deck.shuffle();
        
        // Deal out four cards
        Card card = deck.pop();
        card.setHidden(false);
        playerHand.addCard(card);
        
        card = deck.pop();
        card.setHidden(true); //Dealer's first card is hidden
        dealerHand.addCard(card);
        
        card = deck.pop();
        card.setHidden(false);
        playerHand.addCard(card);
        
        card = deck.pop();
        card.setHidden(false);
        dealerHand.addCard(card);
    }
    
    public Card hit(CardHand hand) {
        // Adds a face-up card to the hand passed
        Card card = deck.pop();
        card.setHidden(false);
        hand.addCard(card);
        return card;
    }
    
    public int getHandScore(CardHand hand) {
        // Totals are returns the score of the player's hand.
        // Just a coat for a CardHand method that does 100% of the work
        return hand.score21();
    }
    
    public boolean busted(CardHand hand) {
        // Return true if score is greater than 21, else false
        return hand.score21() > 21;
    }
    
    public boolean isGameOver() {
        return gameOver;
    }
    
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
    
    public String getWinnerString() {
        String s = "";
        setGameOver(true);
        if (busted(playerHand)) {
            s += "Player busted!";
        } else if (busted(dealerHand)) {
            s += "Dealer busted!";
        } else if (getHandScore(playerHand) > getHandScore(dealerHand)) {
            s+= "Player wins! ";
        } else {
            s+= "Dealer wins! ";
        }
        return s;
    }
    
    public CardHand getPlayerHand() {
        return playerHand;
    }
    
    public CardHand getDealerHand() {
        return dealerHand;
    }
    
    // Methods for testing //
    public String getHandString(CardHand hand) {
        return hand.toString();
    }
    
    public static void main(String[] args) {
        Game21 game = new Game21();
        game.newGame();
        // SHUFFLE ON THIS LINE...
        System.out.println(game.getHandString(game.getPlayerHand()));
        System.out.println(game.getHandString(game.getDealerHand()));
    }
    
    
}
