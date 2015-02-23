package ps4n2SearchObjects;

/**
 * Write a program to randomly generate an array of 1,000,000 integers and a key
 * number to search for. Implement a binary search similar to listing 7.7.
 * Estimate the execution time. Use System.currentTimeMillis() to do the timing.
 *
 * @author Your Name Here
 */
public class N2SearchBinary {

    public static void main(String[] args) {
        //int[] a = {5, 10, 15, 20, 25, 30, 31, 32, 33};
        int[] a = new int[100_000_000];
        int myNum = 99_000_000;
        int foundIndex;

        fillSequence(a);
        foundIndex = binarySearch(a, myNum);
        System.out.println("Found Index = " + foundIndex);
    }

    public static int binarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        int count = 0;

        while (high >= low) {
            int mid = (low + high) / 2;
            if (key < list[mid]) {
                high = mid - 1;
            } else if (key == list[mid]) {
                return mid;
            } else {
                low = mid + 1;
            }
            count++;
            System.out.println("Loop=" + count + " low=" + low + " high=" + high);
        }
        return -1;
    }
    
    public static void fillSequence(int[] list) {
        for(int i=0; i<list.length; i++){
            list[i] = i;
        }
    }
}
