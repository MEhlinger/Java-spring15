/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ps4n4Queue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CSLab
 */
public class QueueOfIntegersTest {
    
    public QueueOfIntegersTest() {
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
     * Test of enqueue method, of class QueueOfIntegers.
     */
    @Test
    public void testEnqueue() {
        System.out.println("enqueue");
        int value = 5;
        QueueOfIntegers instance = new QueueOfIntegers();
        instance.enqueue(value);
        
        int expResult = 5;
        int result = instance.dequeue();
        assertEquals(expResult, result);
    }

    /**
     * Test of dequeue method, of class QueueOfIntegers.
     */
    @Test
    public void testDequeue() {
        System.out.println("dequeue");
        QueueOfIntegers instance = new QueueOfIntegers();
        
        instance.enqueue(123);
        instance.enqueue(555);
        
        int expResult = 123;
        int result = instance.dequeue();
        assertEquals(expResult, result);
    }

    /**
     * Test of peek method, of class QueueOfIntegers.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        QueueOfIntegers instance = new QueueOfIntegers();
        
        instance.enqueue(666);
        
        int expResult = 666;
        int result = instance.peek();
        assertEquals(expResult, result);
    }

    /**
     * Test of empty method, of class QueueOfIntegers.
     */
    @Test
    public void testEmpty() {
        System.out.println("empty");
        QueueOfIntegers instance = new QueueOfIntegers();
        
        instance.enqueue(123123);
        
        boolean expResult = false;
        boolean result = instance.empty();
        assertEquals(expResult, result);
    }
    
}
