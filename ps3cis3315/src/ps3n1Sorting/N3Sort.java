package ps3n1Sorting;

import java.util.Arrays;
import java.util.Random;
import myutil.Timer;

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
        Timer clock = new Timer();
        
        int[] a = new int[100_000];
        
        
        for (int i =0; i < a.length; i++) {
            a[i] = rand.nextInt(a.length);
            System.out.print(a[i] + " ");
        }
        System.out.println();
        
        clock.startStopWatch();
        Arrays.parallelSort(a);
        System.out.println("Sort Time : " + clock.getStopWatch() + " millis");
        
        for (int val : a) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
