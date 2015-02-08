package ps2c7n09;

import java.util.Arrays;
import java.util.Scanner;
import myutil.Validator;

/**
 * Write a method that finds the smallest element in an array of double values
 * using the following header:
 *
 * public static double min (double[] array)
 *
 * Write a test program that prompts the user to enter ten numbers, invokes this
 * method to return the minimum value, and displays the minimum value.
 *
 * @author Marshall Ehlinger
 */
public class N9Min {

    public static void main(String[] args) {
        double input;
        Scanner sc = new Scanner(System.in);
        double[] testArray = new double[10];
        
        for (int i = 0; i < 10; i++) {
            input = Validator.getDouble(sc, "Enter double value: ");
            testArray[i] = (input);
        }
        
        /*
        # Below is the code for populating the array with random values in lieu of entry
        for (int i = 0; i < testArray.length ; i++) {
            testArray[i] = Math.random();
            System.out.printf("%.4s\n", testArray[i]);
        }
        */
        
        System.out.printf("\n%.9s\n", "Min: " + min(testArray));
    }
    
    public static double min (double[] array) {
        double min;
        Arrays.sort(array);
        min = array[0];
        return min;
    }
}
