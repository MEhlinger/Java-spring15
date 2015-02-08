package ps2c7n07;

import java.util.Random;

/**
 * Write a program that creates one hundred random integers between 0 and 9 and
 * displays the count for each number. 
 *
 * @author JP
 */
public class N7CountDigits {

    public static void main(String[] args) {
        int[] randInts = new int[100];
        int[] counts = new int[10];
        int thisVal;
        
        
        for (int i = 0 ; i < randInts.length ; i ++) {
            randInts[i] = (int) (Math.random() * 10);
            counts[randInts[i]] ++;
        }
        
        for (int i = 0 ; i < counts.length ; i++) {
            System.out.println(i + " occurs " + counts[i] + " times.");
        }
    
    }
}
