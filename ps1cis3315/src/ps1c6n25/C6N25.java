package ps1c6n25;

import java.util.Scanner;
import myutil.Validator;

/**
 * Write a method that converts milliseconds to hours, minutes, and seconds.
 *
 * @author Marshall Ehlinger
 */
public class C6N25 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = Validator.getInt(sc, "Enter milliseconds: ");
        convertMillis(input);
    }

    public static void convertMillis(long millis) {
        long hours, minutes, seconds;
        seconds = (long)Math.floor(millis / 1000);
        millis %= millis / 1000;
        minutes = (long)Math.floor(seconds / 60);
        seconds %= 60;
        hours = (long)Math.floor(minutes / 60);
        minutes %= 60;
        System.out.println(hours + " hours, " + minutes + " minutes, " + seconds + " seconds, " +  millis + " milliseconds.");
    }
}
