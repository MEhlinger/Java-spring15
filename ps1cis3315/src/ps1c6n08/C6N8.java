package ps1c6n08;

import java.util.Scanner;
import myutil.Validator;
/**
 * Write methods to convert temperatures. Write a test program to display a
 * table of temperatures.
 *
 * @author Marshall Ehlinger
 */
public class C6N8 {

    public static void main(String[] args) {
        double fahrenheit, celsius, oldCelsius, oldFahrenheit;
        Scanner sc = new Scanner(System.in);
        
        oldCelsius = Validator.getDouble(sc, "Enter celsius to be converted: \n");
        oldFahrenheit = Validator.getDouble(sc, "Enter fahrenheit to be converted: \n");
        
        celsius = fahrenheitToCelsius(oldFahrenheit);
        fahrenheit = celsiusToFahrenheit(oldCelsius);
        
        System.out.println("Celsius  |  Fahrenheit");
        System.out.printf("%-10.4s", oldCelsius);
        System.out.printf("%6.4s\n", celsius);
        System.out.printf("%-10.4s", oldFahrenheit);
        System.out.printf("%6.4s\n", fahrenheit);
    }

    public static double celsiusToFahrenheit(double celsius) {
        double fahrenheit;
        fahrenheit = (9.0 / 5) * celsius + 32;
        return fahrenheit;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        double celsius;
        celsius = (5.0 / 9) * (fahrenheit - 32);
        return celsius;
    }
}
