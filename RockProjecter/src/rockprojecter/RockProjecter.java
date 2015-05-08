package rockprojecter;

import java.util.Scanner;

/**
 *
 * @author Marshall Ehlinger
 */
public class RockProjecter {

    public static void main(String[] args) {
        ClimbPortfolio myClimbs = new ClimbPortfolio("climbs.txt");
        boolean running = true;
        String climbName;
        int input;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n         A      ");
        System.out.println(" ROCK   /\\\\    ");
        System.out.println("       / \\\\\\  Projector\n\n");
        while (running) {
            System.out.println("\n==========================================");
            System.out.println(" Press a number according to your choice: ");
            System.out.println("1: List My Climbs");
            System.out.println("2: Add A Climb");
            System.out.println("3: Display A Climb");
            System.out.println("4: Update A Climb");
            System.out.println("5: Delete A Climb");
            System.out.println("6: Quit RockProjector\n");
            
            input = Validator.getInt(sc, "ENTER A VALUE:  ", 1, 6);
            
            switch (input) {
                case 1 :    System.out.println("\n==========================================");
                            myClimbs.print();
                            break;
                case 2 :    myClimbs.createRecord(defClimb());
                            break;
                case 3:     climbName = Validator.getLine(sc, "Enter a climb name to retrieve: ");
                            System.out.println(myClimbs.retrieveRecord(climbName));
                            break;
                case 4:     System.out.println("Enter new climn info with same name as existing climb: ");
                            myClimbs.updateRecord(defClimb());
                            break;
                case 5:     myClimbs.deleteRecord(Validator.getLine(sc, "Enter climb name to delete: "));
                            break;
                case 6:     running = false;
                            break;
            }
        }
    }
    
    public static RockClimb defClimb() {
        RockClimb climb;
        String name, grade, area, style, input;
        int pitches;
        boolean sent;
        Scanner sc = new Scanner(System.in);
        
        style = Validator.getLine(sc, "Enter style 'route' or 'problem': ", "(problem)|(route)");
        
        name = Validator.getLine(sc, "Enter climb name: ");
        grade = Validator.getLine(sc, "Enter climb grade: ");
        area = Validator.getLine(sc, "Enter climb area: ");
        input = Validator.getLine(sc, "Sent? Y/N: ", "Y|N");
        if (input.equals("Y")) {
            sent = true;
        } else {
            sent = false;
        }
        if (style.equals("route")) {
            pitches = Validator.getInt(sc, "Enter number of pitches: ");
            climb = new RockRoute(name, grade, area, sent, pitches);
        } else {
            climb = new BoulderProblem(name, grade, area, sent);
        }
        
        return climb;
        
    }
}
