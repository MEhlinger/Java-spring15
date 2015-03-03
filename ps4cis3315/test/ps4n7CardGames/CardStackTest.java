package ps4n7CardGames;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marshall Ehlinger
 */
public class CardStackTest {
    
    public CardStackTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of createDeck method, of class CardStack.
     */
    @Test
    public void testCreateDeck() {
        System.out.println("createDeck");
        CardStack instance = new CardStack();
        Card expResult = new Card(51, 12, "ace", "spades", false);
        Card result = instance.peek();
        assertEquals(expResult, result);
    }

    /**
     * Test of shuffle method, of class CardStack.
     */
    @Test
    public void testShuffle() {
        System.out.println("shuffle");
        CardStack instance = new CardStack();
        instance.shuffle();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of peek method, of class CardStack.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        CardStack instance = new CardStack();
        Card expResult = null;
        Card result = instance.peek();
        assertEquals(expResult, result);
    }

    /**
     * Test of empty method, of class CardStack.
     */
    @Test
    public void testEmpty() {
        System.out.println("empty");
        CardStack instance = new CardStack();
        boolean expResult = false;
        boolean result = instance.empty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
