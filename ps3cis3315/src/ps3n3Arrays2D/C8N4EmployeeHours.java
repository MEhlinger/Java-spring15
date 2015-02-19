package ps3n3Arrays2D;

/**
 * Computer the weekly work hours for a set of employees. The hours are stored
 * in a 2D array.
 *
 * @author Your Name Here
 */
public class C8N4EmployeeHours {

    public static void main(String[] args) {
        String[] names = {"Mary", "Jill"};
        int[][] hours = {
            {20, 30, 40, 30, 20},
            {40, 40, 40, 40, 40}
        };

        for (int i = 0; i < hours.length; i++) {
            System.out.println(names[i]);
            int totalHours = 0;
            for (int j = 0; j < hours[0].length; j++) {
                System.out.print(hours[i][j] + " ");
                totalHours += hours[i][j];
            }
            System.out.println(", Total: " + totalHours);
        }
    }
}
