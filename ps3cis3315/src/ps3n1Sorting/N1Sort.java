package ps3n1Sorting;

import java.util.Random;
import myutil.Stopwatch;

/**
 * Implement a selection sort similar to listing 7.8 and use it to sort an array
 * of numbers. Estimate the execution time to sort 1000, 10000, 100000, and
 * 1000000 numbers using System.currentTimeMillis() to do the timing. Neatly
 * display the results.
 *
 * @author Marshall Ehlinger
 */
public class N1Sort {

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
        selectionSort(a);
        System.out.println("Sort Time : " + clock.getStopWatch() + " millis");
        
        for (int val : a) {
            System.out.print(val + " ");
        }
        System.out.println();
        
    }
    
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int currentMin = array[i];
            int currentMinIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (currentMin > array[j]) {
                    currentMin = array[j];
                    currentMinIndex = j;
                }
            }
            // After the 'j' loop pass through all array elements, move new
            // smallest number to front, then increment the i counter and repeat
            if (currentMinIndex != i) {
                array[currentMinIndex] = array[i];
                array[i] = currentMin;
            }
        }
    }
}
