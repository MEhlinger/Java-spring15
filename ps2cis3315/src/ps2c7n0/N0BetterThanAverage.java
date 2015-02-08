package ps2c7n0;

import java.util.Random;

/**
 * Write a program that creates one hundred random numbers in an array, computes
 * their average, and finds out how many numbers are above the average. Use
 * static methods as appropriate.
 *
 * @author JP
 */
public class N0BetterThanAverage {

    public static void main(String[] args) {
        int[] a = new int[100];
        int arrayLength = a.length;
        double average;
        int aboveCount;
        fillArray(a, arrayLength);
        displayArray(a);
        average = calcAverage(a);
        aboveCount = countAboveAverage(a, average);
        System.out.println("The average of " + arrayLength + " random ints is " + average);
        System.out.println("There were " + aboveCount + " numbers above average.");
    }

    public static void fillArray(int[] a, int length) {
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(length);
        }
    }

    public static void displayArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if ((i > 0) && (i % 10 == 0)) {
                System.out.printf("\n%4s", a[i]);
            } else {
                System.out.printf("%4s", a[i]);
            }
        }
        System.out.println();
//        int i = 0;
//        while (i < a.length) {
//            if ((i > 0) && (i % 10 == 0)) {
//                System.out.printf("\n%4s", a[i]);
//            } else {
//                System.out.printf("%4s", a[i]);
//            }
//            i++;
//        }
//        System.out.println();
    }

    public static double calcAverage(int[] a) {
        double average = 0;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        average = sum / a.length;
        return average;
    }

    public static int countAboveAverage(int[] a, double avg) {
        int aboveAvg = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > avg) {
                aboveAvg ++;
            }
        }
        return aboveAvg;
    }
}
