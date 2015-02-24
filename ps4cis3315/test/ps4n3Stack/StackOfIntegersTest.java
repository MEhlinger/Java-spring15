package ps4n3Stack;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marshall Ehlinger
 */
public class StackOfIntegersTest {
    
    public StackOfIntegersTest() {
    }
    
    /**
     * Test of push method, of class StackOfIntegers.
     */
    @Test
    public void testPush() {
        // Adds an item to stack, then pops it off and returns it.
        System.out.println("push");
        int value = 23;
        StackOfIntegers instance = new StackOfIntegers();
        instance.push(value);
        int expResult = 23;
        int result = instance.pop();
        assertEquals(expResult, result);
    }

    /**
     * Test of pop method, of class StackOfIntegers.
     */
    @Test
    public void testPop() {
        // Adds a different value to stack, then pops it off and returns it.
        
        System.out.println("pop");
        StackOfIntegers instance = new StackOfIntegers();
        int pushVal = 55;
        instance.push(pushVal);
        int expResult = 55;
        int result = instance.pop();
        assertEquals(expResult, result);
    }

    /**
     * Test of peek method, of class StackOfIntegers.
     */
    @Test
    public void testPeek() {
        // Adds to items to stack, then returns/"looks at" top/last one
        System.out.println("peek");
        StackOfIntegers instance = new StackOfIntegers();
        
        int pushVal = 14;
        instance.push(pushVal);
        pushVal = 200;
        instance.push(pushVal);
        
        int expResult = 200;
        int result = instance.peek();
        assertEquals(expResult, result);
    }

    /**
     * Test of empty method, of class StackOfIntegers.
     */
    @Test
    public void testEmpty() {
        // Adds, then pops, value from stack, then checks to see if empty
        
        System.out.println("empty");
        StackOfIntegers instance = new StackOfIntegers();
        
        int pushVal = 5;
        while (instance.getSize() < 10) {
            instance.push(pushVal);
        }
        while (instance.getSize() > 0) {
            instance.pop();
        }
        
        boolean expResult = true;
        boolean result = instance.empty();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSize method, of class StackOfIntegers.
     */
    @Test
    public void testGetSize() {
        //Pushes 5 values to the stack, then checks size (should be 5)
        
        System.out.println("getSize");
        StackOfIntegers instance = new StackOfIntegers();
        
        int pushVal = 100;
        while (instance.getSize() < 5) {
            instance.push(pushVal);
        }
        
        int expResult = 5;
        int result = instance.getSize();
        assertEquals(expResult, result);
    }
    
}
