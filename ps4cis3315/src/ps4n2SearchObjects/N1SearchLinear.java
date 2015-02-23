package ps4n2SearchObjects;

import java.util.Random;

/**
 * Write a program to randomly generate an array of 1,000,000 integers and a key
 * number to search for. Implement a linear search similar to listing 7.6.
 * Estimate the execution time. Use System.currentTimeMillis() to do the timing.
 *
 * @author John Phillips
 */
public class N1SearchLinear {

    public static void main(String[] args) {
        long start, stop;
        int myNum = 100_000_000;
        //int[] a = {34, 56, 100, 7, 3, 67, 99, 2};
        int foundIndex;
        int[] a = new int[100_000_000];
        fillRandom(a);
        a[99_999_999] = myNum;
        start = System.nanoTime();
        foundIndex = linearSearch(a, myNum);
        stop = System.nanoTime();
        System.out.println("Index=" + foundIndex + " value=" + a[foundIndex]);
        System.out.println("Searched 100,000,000 in " + (stop - start) + "nanosec");
    }

    public static int linearSearch(int[] list, int key) {
        for (int i = 0; i < list.length; i++) {
            if (key == list[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void fillRandom(int[] a) {
        Random gen = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = gen.nextInt(a.length);
        }
    }
}
