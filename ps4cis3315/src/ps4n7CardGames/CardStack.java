package ps4n7CardGames;

import java.util.Random;

/**
 *
 * @author Marshall Ehlinger
 */
public class CardStack {
    public static final int MAXSIZE = 52;
    private Card[] stackArray;
    private int top;
    
    public CardStack() {
        stackArray = new Card[MAXSIZE];
        top = -1;
        createDeck();
    }
    
    public void createDeck() {
        String[] suit = {"clubs", "diamonds", "hearts", "spades"};
        String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace"};
        int count = 0;
        
        for (int r = 0; r < 13; r++) {
            for (int s = 0; s < 4; s++) {
                push(new Card(count++, r, rank[r], suit[s], false)); // Cards NOT hidden by default
            }
        }
    }
    
    public void shuffle() {
        // Pseudoranom deck shuffle
        Random rgen = new Random();
        for (int i = 0; i < 52; i++) {
            swap(i, rgen.nextInt(52));
        }
    }
    
    private void swap (int i, int j) {
        // Swaps two cards at indices i and j, for shuffling purposes
        Card temp = stackArray[i];
        stackArray[i] = stackArray[j];
        stackArray[j] = temp;
    }
    
    private void push(Card card) {
        // Increments top, then adds the passed card to the top of the deck/stack
        stackArray[++top] = card;
    }
    
    /*public void draw() {
        // Wrapper method for "pop" that checks to make sure deck isn't empty
        if (!empty()) {
            pop();
        } else {
            System.out.println("Draw failed: cannot draw from an empty deck!");
        }
    }*/
    
    public Card pop() {
        // Returns top card from deck/stack, then decrements top
        return stackArray[top--];
    }
    
    public Card peek() {
        // Returns top card of deck without drawing it. Cheater.
        return stackArray[top];
    }
    
    public boolean empty() {
        return top == -1;
    }
    
}
