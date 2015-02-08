package ps2c7n01;

import java.util.Scanner;
import myutil.Validator;

/**
 * Write a program that reads student scores, gets the best score, and then
 * assigns grades based on the following scheme:
 *
 * Grade is A if score is >= best - 10
 *
 * Grade is B if score is >= best - 20
 *
 * Grade is C if score is >= best - 30
 *
 * Grade is D if score is >= best - 40
 *
 * Grade is F otherwise
 *
 * The program prompts the user to enter the total number of students, the
 * prompts the user to enter all of the scores, and concludes by displaying the
 * grades.
 *
 * @author Your name here
 */
public class N1Grades {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int classSize = Validator.getInt(sc, "Enter total number of students: ");
        int[] scores = new int[classSize];
        int max = 0;
        for (int i = 0; i < classSize; i++) {
            scores[i] = Validator.getInt(sc, "Enter student score: ", 0, 100);
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        System.out.printf("%8s", "Grade %");
        System.out.printf("%8s\n", "Letter");
        System.out.println("----------------");
        
        for (int i = 0; i < classSize; i++) {
            System.out.printf("%8s", scores[i]);
            System.out.printf("%8c", convertToLetter(scores[i], max));
            if (scores[i] == max) {
                System.out.printf("%14s", "BEST SCORE");
            }
            System.out.println();
        }
    }
    
    public static char convertToLetter(int grade, int max) {
        if (grade >= (max - 10)) {
            return 'A';
        } else if (grade >= (max - 20)) {
            return 'B';
        } else if (grade >= (max - 30)) {
            return 'C';
        } else if (grade >= (max - 40)) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
