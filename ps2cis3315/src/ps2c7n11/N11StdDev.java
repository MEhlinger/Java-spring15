package ps2c7n11;

/**
 * Write a method to calculate the standard deviation. Create a test program to
 * verify that it works correctly.
 *
 * @author Marshall Ehlinger
 */
public class N11StdDev {

    public static void main(String[] args) {
        int[] testArray = new int[10];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = (int) (Math.random() * 10);
            System.out.println(testArray[i]);
        }
        
        System.out.println("Stand Dev: " + stanDev(testArray));
    }
    
    public static double stanDev(int[] values) {
        double stDev;
        int sum = 0;
        
        
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        
        double average = sum / values.length;
        double[] differences = new double[values.length];
        double differencesSum = 0;
        double variance;
        
        for (int i = 0; i < values.length; i++) {
            differences[i] = average - values[i];
            differences[i] *= differences[i];
            differencesSum += differences[i];
        }
        
        variance = differencesSum / (double)differences.length;
        
        stDev = Math.sqrt(variance);
        
        return stDev;
    }
}
