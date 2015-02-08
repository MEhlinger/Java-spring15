package ps1c6n01;

/**
 * Write a method to calculate a pentagonal number. Test the method by
 * displaying the first 100 pentagonal numbers in a 10 column by 10 row table.
 *
 * @author Marshall Ehlinger
 */
public class C6N1 {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.printf("%8d ", getPentagonalNumber(i));
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }

    public static int getPentagonalNumber(int n) {
        return n * (3 * n - 1) / 2;
    }
}
