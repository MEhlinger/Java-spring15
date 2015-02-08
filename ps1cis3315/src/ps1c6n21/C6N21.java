package ps1c6n21;

import java.util.Scanner;
import myutil.Validator;

/**
 * Write a method that converts an uppercase letter to a number using the
 * telephone letter/number mapping. Write a test program that asks the user to
 * enter a phone number as a String that contains numbers and letters and then
 * convert it to all digits.
 *
 * abc/def/ghi/jkl/mno/pqrs/tuv/wxyz
 * 
 * @author Marshall Ehlinger
 */
public class C6N21 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String phoneStr = Validator.getLine(sc, "Enter a phone number (letters permitted): ");
        
        System.out.println("The number is " + convertNumber(phoneStr));
    }
    
    public static String convertNumber(String phone) {
        String result = "";
        char c;
        for (int i =0; i < phone.length(); i++) {
            c = phone.charAt(i);
            if (Character.isLetter(c)) {
                result += getNumber(Character.toUpperCase(c));
            } else {
                result += c;
            }
        }
        return result;
    }

    public static int getNumber(char uppercaseLetter) {
        int num = 0;
        switch (uppercaseLetter) {
            case 'A':
            case 'B':
            case 'C':   
                num = 2;
                break;
            case 'D':
            case 'E':
            case 'F':   
                num = 3;
                break;
            case 'G':
            case 'H':
            case 'I':   
                num = 4;
                break;
            case 'J':
            case 'K':
            case 'L':   
                num = 5;
                break;
            case 'M':
            case 'N':
            case 'O':   
                num = 6;
                break;
            case 'P':
            case 'Q':
            case 'R':   
            case 'S':
                num = 7;
                break;
            case 'T':
            case 'U':
            case 'V':   
                num = 8;
                break;
            case 'W':
            case 'X':
            case 'Y':  
            case 'Z':
                num = 9;
                break;
        }
        return num;
    }
}
