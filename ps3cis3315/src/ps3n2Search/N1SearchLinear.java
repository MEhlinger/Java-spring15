package ps3n2Search;

import java.util.Random;
import myutil.Timer;

/**
 * Write a program to randomly generate an array of 1,000,000 integers and a key
 * number to search for. Implement a linear search similar to listing 7.6.
 * Estimate the execution time. Use System.currentTimeMillis() to do the timing.
 *
 * @author Marshall Ehlinger
 */
public class N1SearchLinear {

    public static void main(String[] args) {
        Random randGen = new Random();
        Timer clock = new Timer();
        
        //Populate array of 1 million elements with random values
        int[] vals = new int[1_000_000];
        for (int i=0; i < vals.length; i++) {
            vals[i] =(int)  (randGen.nextDouble() * vals.length);
        }
        
        //Determine value to be searched for
        // First line selects a random value definitely in array.
        // Second line can be swapped in via comment with first for a hardcoded target
        //int keyVal = vals[(int) (randGen.nextDouble() * vals.length)];
        int keyVal = 1000; //Arbitrary hardcoded value for test/debug
        
        //Set "clock" time object to time search algorithm
        //Assign result of search (returns index of searched value, or -1) to variable
        clock.setStopWatch();
        int keyValIndex = linearSearch(keyVal, vals);
        
        //Print results of search and time to completion.
        if (keyValIndex > -1) {
            System.out.println("Found " + keyVal + " at index " + keyValIndex + ".");
        } else {
            System.out.println(keyVal + " is not in array.");
        }
        System.out.println("Completed in : " + clock.getStopWatch() + " millis.");
        
    }
    
    public static int linearSearch(int target, int[] array) {
        // Searches given array for target value.
        // Returns -1 and prints warning if item not found.
        // If successful, returns index of -first- found instance of target.
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                index = i;
                break;
            }
        }
        if (index > -1) {
            return index;
        } else {
            System.out.println("Searched item not in given array.");
            return index;
        }
    }
}
