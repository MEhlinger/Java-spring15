package ps3n2Search;

import java.util.Arrays;
import java.util.Random;
import myutil.Stopwatch;

/**
 * Write a program to randomly generate an array of 1,000,000 integers and a key
 * number to search for. Implement a binary search using
 * java.util.Arrays.binarySearch(). Estimate the execution time. Use
 * System.currentTimeMillis() to do the timing.
 *
 * @author Your Name Here
 */
public class N3SearchBinary {

    public static void main(String[] args) {
        Random pseudoRandom = new Random();
        Stopwatch clock = new Stopwatch();
        int[] vals = new int[100_000];
        
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
        int keyIndex = Arrays.binarySearch(vals, keyValue);
        long opTime = clock.getStopWatch();
        System.out.println("Search took " + opTime + " millis.");
        
        // Display results
        if (keyIndex >= 0) {
            System.out.println("Key value " + keyValue + " found at " + keyIndex);
        } else {
            System.out.println("Key value " + keyValue + " not in list.");
        }
        
    }
    }
