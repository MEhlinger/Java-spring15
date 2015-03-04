package ps4n7CardGames;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marshall Ehlinger
 */
public class CardTest {
    
    // Declare card for tests
    Card instance;

    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Card(51, 12, "ace", "spades", false);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCARD_VALUE method, of class Card.
     */
    @Test
    public void testGetCARD_VALUE() {
        System.out.println("getCARD_VALUE");
        int expResult = 51;
        int result = instance.getCARD_VALUE();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRANK_VALUE method, of class Card.
     */
    @Test
    public void testGetRANK_VALUE() {
        System.out.println("getRANK_VALUE");
        int expResult = 12;
        int result = instance.getRANK_VALUE();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRANK method, of class Card.
     */
    @Test
    public void testGetRANK() {
        System.out.println("getRANK");
        String expResult = "ace";
        String result = instance.getRANK();
        assertEquals(expResult, result);

    }

    /**
     * Test of getSUIT method, of class Card.
     */
    @Test
    public void testGetSUIT() {
        System.out.println("getSUIT");
        String expResult = "spades";
        String result = instance.getSUIT();
        assertEquals(expResult, result);
    }

    /**
     * Test of isIsHidden method, of class Card.
     */
    @Test
    public void testIsHidden() {
        System.out.println("isHidden");
        boolean expResult = false;
        boolean result = instance.isHidden();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIsHidden method, of class Card.
     */
    @Test
    public void testSetHidden() {
        System.out.println("setHidden");
        boolean hiding = true;
        boolean expResult = true;
        instance.setHidden(hiding);
        boolean result = instance.isHidden();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Card.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "ace of spades";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
