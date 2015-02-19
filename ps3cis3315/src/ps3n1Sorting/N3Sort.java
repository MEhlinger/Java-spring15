package ps3n1Sorting;

import java.util.Arrays;
import java.util.Random;
import myutil.Stopwatch;

/**
 * Use the java.util.Arrays.parallelSort() method (page 271) to sort an array of
 * numbers. Estimate the execution time to sort 1000, 10000, 100000, and 1000000
 * numbers using System.currentTimeMillis() to do the timing. Neatly display the
 * results.
 *
 * @author Marshall Ehlinger
 */
public class N3Sort {

    public static void main(String[] args) {
        Random rand = new Random();
        Stopwatch clock = new Stopwatch();
        
        int[] a = new int[10];
        
        
        for (int i =0; i < a.length; i++) {
            a[i] = rand.nextInt(a.length);
            System.out.print(a[i] + " ");
        }
        System.out.println();
        
        clock.setStopWatch();
        Arrays.parallelSort(a);
        System.out.println("Sort Time : " + clock.getStopWatch() + " millis");
        
        for (int val : a) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
