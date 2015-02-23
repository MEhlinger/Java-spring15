package ps4n1SortingObjects;

import java.util.Random;

/**
 * Use the java.util.Arrays.parallelSort() method (page 271) to sort an array of
 * numbers. Estimate the execution time to sort 1000, 10000, 100000, and 1000000
 * numbers using System.currentTimeMillis() to do the timing. Neatly display the
 * results.
 *
 * @author Your Name Here
 */
public class N3Sort {

    public static void main(String[] args) {
        long start, stop;
        //int[] a = {23, 15, 30, 2, 5, 16};
        int[] a = new int[50_000_000];
        fillRandom(a);
        start = System.currentTimeMillis();
        //selectionSort(a);
        //java.util.Arrays.sort(a);
        java.util.Arrays.parallelSort(a);
        stop = System.currentTimeMillis();
//        for (int num : a) {
//            System.out.println(num);
//        }
        System.out.println("Time: " + (stop - start));
    }
    
    public static void fillRandom(int[] a) {
        Random gen = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = gen.nextInt(a.length);
        }
    }
}
