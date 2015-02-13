package ps3n2Search;

import java.util.Arrays;
import java.util.Random;
import myutil.Timer;

/**
 * Write a program to randomly generate an array of 1,000,000 integers and a key
 * number to search for. Implement a binary search similar to listing 7.7.
 * Estimate the execution time. Use System.currentTimeMillis() to do the timing.
 *
 * @author Your Name Here
 */
public class N2SearchBinary {

    public static void main(String[] args) {
        Random pseudoRandom = new Random();
        Timer clock = new Timer();
        int[] vals = new int[100_000000];
        
        //Populate array
        for (int i =0; i < vals.length; i++) {
            vals[i] = (int) (pseudoRandom.nextDouble() * vals.length);
        }
        
        // Sort array... a must for binary searching
        Arrays.sort(vals);
        
        // Choose value to be searched for
        int keyValue = (int) (pseudoRandom.nextDouble() * vals.length);
        
        // Searcj for keyValue
        clock.setStopWatch();
        int keyIndex = binarySearch(vals, keyValue);
        long opTime = clock.getStopWatch();
        System.out.println("Search took " + opTime + " millis.");
        
        // Display results
        if (keyIndex >= 0) {
            System.out.println("Key value " + keyValue + " found at " + keyIndex);
        } else {
            System.out.println("Key value " + keyValue + " not in list.");
        }
        
    }
    
    public static int binarySearch(int[] list, int key) {
        //Finds value 'key' in pre-sorted array 'list'
        
        int highBound = list.length-1;
        int lowBound = 0;
        
        while (highBound >= lowBound) {
            int midpoint = (lowBound + highBound) / 2;
            if (key < list[midpoint]) {
                highBound = midpoint - 1;
            } else if ( key == list[midpoint]) {
                return midpoint;
            } else {
                lowBound = midpoint + 1;
            }
        }
        // Returns -1 if key is not in array/list
        return -1;
    }
}
