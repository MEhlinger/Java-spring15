package ps2c8n4;

/**
 * Computer the weekly work hours for a set of employees. The hours are stored
 * in a 2D array.
 *
 * @author Marshall Ehlinger
 */
public class C8N4EmployeeHours {

    public static void main(String[] args) {
        String[] names = {"Mary Mack", "Brickaloon Tostada", "Galvinus Pepperidge Farm"};
        int weeklyHrs = 0;
        int[][] hours = {
            {8, 9, 10, 8, 6},
            {8, 8, 8, 8, 8},
            {7, 7, 9, 10, 6}
        };

        for (int i = 0; i < hours.length; i++) {
            System.out.println(names[i]);
            weeklyHrs = 0;
            for (int j = 0; j < hours[i].length; j++) {
                System.out.printf("%-3s", hours[i][j]);
                System.out.println(" : " + getWeekday(j+1));
                weeklyHrs += hours[i][j];
            }
            System.out.print("Total Weekly Hours: " + weeklyHrs + "\n\n"); 
            System.out.println("================");
        }
    }
    
    public static String getWeekday(int day) {
        String weekday = "Default";
        switch (day) {
            case 0 :
                weekday = "Sunday";
                break;
            case 1 :
                weekday = "Monday";
                break;
            case 2 :
                weekday = "Tuesday";
                break;
            case 3 :
                weekday = "Wednesday";
                break;
            case 4 :
                weekday = "Thursday";
                break;
            case 5 :
                weekday = "Friday";
                break;
            case 6 :
                weekday = "Saturday";
                break;
        }
        return weekday;
    }
}
