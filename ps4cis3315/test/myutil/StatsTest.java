package myutil;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Your Name Here
 */
public class StatsTest {
    
    public StatsTest() {
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
     * Test of min method, of class Stats.
     */
    @Test
    public void testMin_intArr() {
        int[] a = {50, 60, 70, 80, 90};
        int expResult = 50;
        int result = Stats.min(a);
        System.out.println("min = " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of min method, of class Stats.
     */
    @Test
    public void testMin_doubleArr() {
        double[] d = {3.5, 4.5, 7.5, 2.23, 5.5, 6.5};
        double expResult = 2.23;
        double result = Stats.min(d);
        System.out.println("min = " + result);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of max method, of class Stats.
     */
    @Test
    public void testMax_intArr() {
        System.out.println("max");
        int[] a = {50, 60, 70, 80, 90};
        int expResult = 90;
        int result = Stats.max(a);
        System.out.println("max = " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of max method, of class Stats.
     */
    @Test
    public void testMax_doubleArr() {
        System.out.println("max");
        double[] d = {3.5, 4.5, 7.5, 2.23, 5.5, 6.5};
        double expResult = 7.5;
        double result = Stats.max(d);
        System.out.println("max = " + result);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of sum method, of class Stats.
     */
    @Test
    public void testSum_intArr() {
        System.out.println("sum");
        int[] a = {50, 60, 70, 80, 90};
        int expResult = 350;
        int result = Stats.sum(a);
        System.out.println("sum = " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of sum method, of class Stats.
     */
    @Test
    public void testSum_doubleArr() {
        System.out.println("sum");
        double[] d = {3.5, 4.5, 7.5, 2.23, 5.5, 6.5};
        double expResult = 29.73;
        double result = Stats.sum(d);
        System.out.println("sum = " + result);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of median method, of class Stats.
     */
    @Test
    public void testMedian_intArr() {
        System.out.println("median");
        int[] a = {50, 60, 70, 80, 90};
        int expResult = 70;
        int result = Stats.median(a);
        System.out.println("median = " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of median method, of class Stats.
     */
    @Test
    public void testMedian_doubleArr() {
        System.out.println("median");
        double[] d = {3.5, 4.5, 7.5, 2.23, 5.5, 6.5};
        double expResult = 4.5;
        double result = Stats.median(d);
        System.out.println("median = " + result);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of mean method, of class Stats.
     */
    @Test
    public void testMean_intArr() {
        System.out.println("mean");
        int[] a = {50, 60, 70, 80, 90};
        double expResult = 70.0;
        double result = Stats.mean(a);
        System.out.println("i_mean = " + result);
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of mean method, of class Stats.
     */
    @Test
    public void testMean_doubleArr() {
        System.out.println("mean");
        double[] d = {3.5, 4.5, 7.5, 2.23, 5.5, 6.5};
        double expResult = 4.955;
        double result = Stats.mean(d);
        System.out.println("d_mean = " + result);
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of stddev method, of class Stats.
     */
    @Test
    public void testStddev_intArr() {
        System.out.println("stddev");
        int[] a = {50, 60, 70, 80, 90};
        double expResult = 15.811388300841896;
        double result = Stats.stddev(a);
        System.out.println("int stDev = " + result);
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of stddev method, of class Stats.
     */
    @Test
    public void testStddev_doubleArr() {
        System.out.println("stddev");
        double[] d = {3.5, 4.5, 7.5, 2.23, 5.5, 6.5};
        double expResult = 1.9447750512591426;
        double result = Stats.stddev(d);
        System.out.println("double stDev = " + result);
        assertEquals(expResult, result, 0.001);
    }
    
}
