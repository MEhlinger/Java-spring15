package ps2c7n04;

import java.util.Arrays;
import java.util.Scanner;
import myutil.Validator;

/**
 * Write a program that interactively reads an unspecified number of scores and
 * determines how many scores are above or equal to the average and how many
 * scores are below average. Enter a negative number to signal the end of input.
 * Assume the maximum number of scores is 100. Hint: use a while loop.
 *
 * @author Your Name Here
 */
public class N4Scores {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double average = 0.0;
        int input = 0;
        int[] values = new int[100];
        Arrays.fill(values, -1);
        int aboveAvg = 0;
        int belowAvg = 0;
        int count = 0;
        
        System.out.println("ENTER a negative number to cease value entry: ");
        
        while ((input >= 0) && (count <= values.length)) {
            input = Validator.getInt(sc, "Enter integer: ");
            values[count] = input;
            count ++;
        }
        
        average = calcAverage(values);
        aboveAndBelow(values, average);
    }
    
    public static double calcAverage(int[] valueArray) {
        int sum = 0;
        for (int value : valueArray) {
            sum += value;
        }
        return (sum / valueArray.length);
    }
    
    public static void aboveAndBelow(int[] valueArray, double average) {
        // Prints number of values in an array above and below a given average
        int above = 0; 
        int below = 0;

        for (int value : valueArray) {
            if (value >= 0) {
                if (value > average) {
                    above ++;
                } else if (value < average) {
                    below ++;
                }
            }
        }
        
        System.out.println(above + " values above the average of " + average + ", " + below + " values below.");
    }
}
