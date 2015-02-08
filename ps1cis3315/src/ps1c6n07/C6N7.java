package ps1c6n07;

import java.util.Scanner;
import myutil.Validator;
/**
 * Write a method to calculate the future investment value given an investment
 * amount, a monthly interest rate, and the number of years. Use the formula
 *
 * fiv = ia * (1 + mir)^noy*12
 *
 * Test the method by displaying a table for years 1 to 30.
 *
 * @author Marshall Ehlinger
 */
public class C6N7 {

    public static void main(String[] args) {
        double ia, mir;
        int noy;
        Scanner sc = new Scanner(System.in);
        
        ia = Validator.getDouble(sc, "Initial Investment: ");
        mir = Validator.getDouble(sc, "Monthly Interest Rate as Decimal: ");
        noy = Validator.getInt(sc, "Enter number of years to track: ");
        
        System.out.println();
        System.out.printf("%-7s" , "Year |");
        System.out.printf("%s\n",  "Future Value");
        System.out.println("----------------------------------");
        
        for (int i = 0; i < noy; i++) {
            System.out.printf("%-7d" ,i + 1);
            System.out.printf("%,.2f\n",  futureInvestmentValue(ia, mir, i + 1));
        }
    }

    public static double futureInvestmentValue(double investmentAmount,
            double monthlyInterestRate, int years) {
        
        double futureValue = investmentAmount * Math.pow((1 + monthlyInterestRate), years * 12);
        
        return futureValue;
    }
}