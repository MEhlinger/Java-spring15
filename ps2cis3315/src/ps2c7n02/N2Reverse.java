package ps2c7n02;

import java.util.Scanner;
import myutil.Validator;

/**
 * Write a program that displays 10 integers and displays them in the reverse
 * order in which they were read.
 *
 * @author Your Name Here
 */
public class N2Reverse {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] reverseArray = new int[10];
        for (int i = reverseArray.length-1; i >= 0; i--) {
            reverseArray[i] = Validator.getInt(sc, "Enter an integer: ");
        }
        
        for (int i = 0; i < reverseArray.length ; i++) {
            System.out.println(reverseArray[i]);
        }
    }   
}
