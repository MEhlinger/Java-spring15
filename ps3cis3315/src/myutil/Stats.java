package myutil;

import java.util.Arrays;

/**
 * Create static methods to implement min, max, sum, median, mean (average), and
 * standard deviation that work with int and double arrays. Test the methods
 * from main.
 *
 * @author Your Name Here
 */
public class Stats {

    public static void main(String[] args) {
        int[] a = {50, 60, 70, 80, 90};
        double[] b = {3.5, 4.5, 7.5, 2.23, 5.5, 6.5};

        System.out.println("Array a: " + java.util.Arrays.toString(a));
        System.out.println("Array b: " + java.util.Arrays.toString(b));

        System.out.printf("Min array a: %d\n", min(a));
        System.out.printf("Min array b: %.4f\n", min(b));

        System.out.printf("Max array a: %d\n", max(a));
        System.out.printf("Max array b: %.4f\n", max(b));

        System.out.printf("Sum array a: %d\n", sum(a));
        System.out.printf("Sum array b: %.4f\n", sum(b));

        System.out.printf("Median array a: %d\n", median(a));
        System.out.printf("Median array b: %.4f\n", median(b));

        System.out.printf("Mean array a: %.4f\n", mean(a));
        System.out.printf("Mean array b: %.4f\n", mean(b));

        System.out.printf("Standard deviation array a: %.4f\n", stddev(a));
        System.out.printf("Standard deviation array b: %.4f\n", stddev(b));
    }

    public static int min(int[] a) {
        int aMin;
        Arrays.sort(a);
        aMin = a[0];
        return aMin;
    }

    public static double min(double[] b) {
        double bMin;
        Arrays.sort(b);
        bMin = b[0];
        return bMin;
    }

    public static int max(int[] a) {
        int aMax;
        Arrays.sort(a);
        aMax = a[a.length-1];
        return aMax;
    }

    public static double max(double[] b) {
        double bMax;
        Arrays.sort(b);
        bMax = b[b.length-1];
        return bMax;
    }

    public static int sum(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    public static double sum(double[] b) {
        double sum = 0;
        for (int i = 0; i < b.length; i++) {
            sum += b[i];
        }
        return sum;
    }

    public static int median(int[] a) {
        int median = a[a.length / 2];
        return median;
    }

    public static double median(double[] b) {
        double median = b[b.length / 2];
        return median;
    }

    public static double mean(int[] a) {
        int sum = 0;
        for (int i = 0 ; i < a.length; i++) {
            sum+= a[i];
        }
        return (sum / a.length);
    }

    public static double mean(double[] b) {
        double sum = 0.0;
        for (int i = 0; i < b.length; i++) {
            sum += b[i];
        }
        return (sum / b.length);
    }

    public static double stddev(int[] a) {
        double variance;
        double[] squaredDifferences = new double[a.length];
        double firstMean = mean(a);
        for (int i = 0; i < a.length; i++) {
            squaredDifferences[i] = Math.pow(firstMean - a[i], 2);
        }

        return Math.sqrt(mean(squaredDifferences));
    }

    public static double stddev(double[] b) {
        double variance;
        double[] squaredDifferences = new double[b.length];
        double firstMean = mean(b);
        for (int i = 0; i < b.length; i++) {
            squaredDifferences[i] = Math.pow(firstMean - b[i], 2);
        }

        return Math.sqrt(mean(squaredDifferences));
    }
}
