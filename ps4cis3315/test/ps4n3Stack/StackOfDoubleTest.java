/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ps4n3Stack;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marshall
 */
public class StackOfDoubleTest {
    
    public StackOfDoubleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of push method, of class StackOfDouble.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        double value = 5.6;
        StackOfDouble instance = new StackOfDouble();
        instance.push(value);
        double expResult = 5.6;
        double result = instance.pop();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of pop method, of class StackOfDouble.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        StackOfDouble instance = new StackOfDouble();
        
        instance.push(6.765);
        instance.push(213.2);
        
        double expResult = 213.2;
        double result = instance.pop();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of peek method, of class StackOfDouble.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        StackOfDouble instance = new StackOfDouble();
        
        instance.push(12.0);
        instance.push(222.333);
        
        double expResult = 222.333;
        double result = instance.peek();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of empty method, of class StackOfDouble.
     */
    @Test
    public void testEmpty() {
        System.out.println("empty");
        StackOfDouble instance = new StackOfDouble();
        
        instance.push(12.0);
        
        boolean expResult = false;
        boolean result = instance.empty();
        assertEquals(expResult, result);

    }

    /**
     * Test of getSize method, of class StackOfDouble.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        StackOfDouble instance = new StackOfDouble();
        
        instance.push(122.0);
        
        int expResult = 1;
        int result = instance.getSize();
        assertEquals(expResult, result);

    }
    
}
