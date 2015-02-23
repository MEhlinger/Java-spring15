package ps4n2SearchObjects;

/**
 * Write a program to randomly generate an array of 1,000,000 integers and a key
 * number to search for. Implement a binary search using
 * java.util.Arrays.binarySearch(). Estimate the execution time. Use
 * System.currentTimeMillis() to do the timing.
 *
 * @author John Phillips
 */
public class N3SearchBinary {

    public static void main(String[] args) {
        int[] a = new int[100_000_000];
        int myNum = 99_000_000;
        int foundIndex;

        fillSequence(a);
        foundIndex = java.util.Arrays.binarySearch(a, myNum);
        System.out.println("Found Index = " + foundIndex);
    }

    public static void fillSequence(int[] list) {
        for (int i = 0; i < list.length; i++) {
            list[i] = i;
        }
    }
}
