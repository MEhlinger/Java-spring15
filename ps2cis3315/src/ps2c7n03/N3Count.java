package ps2c7n03;

import java.util.Scanner;
import myutil.Validator;

/**
 * Write a program that interactively reads integers between 1 and 100 and
 * counts the occurrences of each. Assume the input ends with 0. Hint: use a
 * while loop.
 *
 * @author Your Name Here
 */
public class N3Count {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int newInt;
        int[] numCounts = new int[100];
        
        while (true) {
            newInt = Validator.getInt(sc, "Enter Integer: ", 0, 101);
            if (newInt == 0) {
                break;
            } else {
                numCounts[newInt - 1] ++;
                System.out.println(newInt + " : " + numCounts[newInt - 1]);
            }
        }
        System.out.printf("\n%40s\n\n", "Value : Times Entered");
        for (int i = 0 ; i < 100 ; i++) {
            if ((i + 1) % 5 == 0) {
                System.out.printf("%11s\n", (i + 1) + " : " + numCounts[i]);
            } else {
                System.out.printf("%11s", (i + 1) + " : " + numCounts[i]);
            }
        }
    }
}
