package ps4n1SortingObjects;

import java.util.Random;

/**
 * Implement a selection sort similar to listing 7.8 and use it to sort an array
 * of numbers. Estimate the execution time to sort 1000, 10000, 100000, and
 * 1000000 numbers using System.currentTimeMillis() to do the timing. Neatly
 * display the results.
 *
 * @author Your Name Here
 */
public class N1Sort {

    public static void main(String[] args) {
        long start, stop;
        //int[] a = {23, 15, 30, 2, 5, 16};
        int[] a = new int[1_000_000];
        fillRandom(a);
        start = System.currentTimeMillis();
        selectionSort(a);
        stop = System.currentTimeMillis();
//        for (int num : a) {
//            System.out.println(num);
//        }
        System.out.println("Time: " + (stop - start));
    }

    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int currentMin = list[i];
            int currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            // Swap - place smallest number at front of list
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }

    public static void fillRandom(int[] a) {
        Random gen = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = gen.nextInt(a.length);
        }
    }
}
