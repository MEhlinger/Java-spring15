package ps1c6n18;

import java.util.Scanner;
import myutil.Validator;

/**
 * Write a method that checks whether a string is a valid password that contains
 * at least 8 characters, consists only of letters and digits, and contains at
 * least 2 digits.
 *
 * @author Marshall Ehlinger
 */
public class C6N18 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pw = "pw";
        while (pw != "") {
            pw = Validator.getLine(sc, "Enter a valid password: ");
            if(isValid(pw)) {
                System.out.println("Valid Password.");
            } else {
                System.out.println("Invalid Password!");
            }
        }   
    }

    public static boolean isValid(String password) {
        if (password.length() < 8 || !checkPasswordComposition(password)) {
            return false;
        }
        return true;
    }
    
    public static boolean checkPasswordComposition(String password) {
        int numDigits = 0;
        int numLetters = 0; 
        int numOtherChar = 0;
        
        for (int i = 0; i < password.length(); i++) {
            char currentChar = password.charAt(i); 
            
            if (currentChar >= 48 && currentChar <= 57) {
                numDigits++;
            } else if (currentChar >= 65 && currentChar <= 122) {
                numLetters++;
            } else {
                numOtherChar++;
            }
        }
        
        if (numDigits >= 2 && numOtherChar == 0) {
            return true;
        }
        return false;
    }
}
