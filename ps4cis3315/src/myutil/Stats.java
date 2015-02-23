package myutil;

/**
 * Create static methods to implement min, max, sum, median, mean (average), and
 * standard deviation that work with int and double arrays. Test the methods
 * from main.
 *
 * @author Your Name Here
 */
public class Stats {

//    public static void main(String[] args) {
//        int[] a = {50, 60, 70, 80, 90};
//        double[] d = {3.5, 4.5, 7.5, 2.23, 5.5, 6.5};
//
//        System.out.println("Array a: " + java.util.Arrays.toString(a));
//        System.out.println("Array d: " + java.util.Arrays.toString(d));
//
//        System.out.printf("Min array a: %d\n", min(a));
//        System.out.printf("Min array d: %.4f\n", min(d));
//
//        System.out.printf("Max array a: %d\n", max(a));
//        System.out.printf("Max array d: %.4f\n", max(d));
//
//        System.out.printf("Sum array a: %d\n", sum(a));
//        System.out.printf("Sum array d: %.4f\n", sum(d));
//
//        System.out.printf("Median array a: %d\n", median(a));
//        System.out.printf("Median array d: %.4f\n", median(d));
//
//        System.out.printf("Mean array a: %.4f\n", mean(a));
//        System.out.printf("Mean array d: %.4f\n", mean(d));
//
//        System.out.printf("Standard deviation array a: %.4f\n", stddev(a));
//        System.out.printf("Standard deviation array d: %.4f\n", stddev(d));
//    }

    public static int min(int[] a) {
        int min = a[0];
        for(int item : a) {
            if(item < min) {
                min = item;
            }
        }
        return min;
    }

    public static double min(double[] d) {
        double min = d[0];
        for(double item : d) {
            if(item < min) {
                min = item;
            }
        }
        return min;
    }

    public static int max(int[] a) {
        int max = a[0];
        for(int item : a) {
            if(item > max) {
                max = item;
            }
        }
        return max;
    }

    public static double max(double[] d) {
        double max = d[0];
        for(double item : d) {
            if(item > max) {
                max = item;
            }
        }
        return max;
    }

    public static int sum(int[] a) {
        int sum = 0;
        for (int item : a) {
            sum += item;
        }
        return sum;
    }

    public static double sum(double[] d) {
        double sum = 0;
        for (double item : d) {
            sum += item;
        }
        return sum;
    }

    public static int median(int[] a) {
        java.util.Arrays.sort(a);
        return a[(a.length-1)/2];
    }

    public static double median(double[] d) {
        java.util.Arrays.sort(d);
        return d[(d.length-1)/2];
    }

    public static double mean(int[] a) {
        return sum(a) / a.length;
    }

    public static double mean(double[] d) {
        return sum(d) / d.length;
    }

    public static double stddev(int[] a) {
        double avg = mean(a);
        double sumOfDevSq = 0;
        
        for (double num : a) {
            sumOfDevSq += Math.pow((num - avg), 2);
        }

        return Math.sqrt(sumOfDevSq / (a.length-1));
    }

    public static double stddev(double[] d) {
        double avg = mean(d);
        double sumOfDevSq = 0;
        
        for (double num : d) {
            sumOfDevSq += Math.pow((num - avg), 2);
        }

        return Math.sqrt(sumOfDevSq / (d.length-1));
    }
}
