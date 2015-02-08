package ps1c6n09;

import java.util.Scanner;
import myutil.Validator;

/**
 * Write methods to convert between feet and meters. Write a test program to
 * display a table of measures.
 * .3048 meters in a foot
 * @author Marshall Ehlinger
 */
public class C6N9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double feet = Validator.getDouble(sc, "Enter feet to convert: ");
        double meters = Validator.getDouble(sc, "Enter meters to convert: ");
        
        double newMeter = footToMeter(feet);
        double newFeet = meterToFoot(meters);
        
        System.out.println("Feet  |  Meters");
        System.out.printf("%-9.4s", feet);
        System.out.printf("%6.4s\n", newMeter);
        System.out.printf("%-9.4s", newFeet);
        System.out.printf("%6.4s\n", meters);
    
    }

    public static double footToMeter(double foot) {
        double newMeter = foot * 3.280;
        return newMeter;
    }

    public static double meterToFoot(double meter) {
        double newFeet = meter * 0.3048;
        return newFeet;
    }
}
