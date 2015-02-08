package ps1c6n30;

/**
 * Write a program to play the game of craps. Roll two dice and get the sum.
 * Values of 2, 3, or 12 is craps and you loose. Values of 7 or 11 and you win.
 * Values of 4, 5, 6, 8, 9, or 10 and then you re-roll the dice and a point is
 * established. Continue to roll the dice until 7 or the same point value is
 * rolled. If you roll 7 you loose. Otherwise, you win.
 *
 * 
 * 
 * @author Marshall Ehlinger.
 */
public class C6N30 {

    public static void main(String[] args) {
        int pointVal = 0;
        int secondRoundRoll = 0;
        int reroll;
        
        int crapsRoll = rollDice(2);
        System.out.println("Roll is " + crapsRoll);
        
        switch (crapsRoll) {
            case 2 :
            case 3 :
            case 12 :
                System.out.println("Craps! Yer out.");
                break;
            case 4 :
            case 5 :
            case 6 :
            case 8 :
            case 9 :
            case 10 :
                pointVal = crapsRoll;
                System.out.println("Point set to " + pointVal + ".");
                break;
            case 7 :
            case 11 :
                System.out.println("You win, sonny.");
                break;
        }
        
        if (pointVal != 0) {
            while (true) {
                reroll = rollDice(2);
                System.out.println("Roll is " + reroll + "\n");
                if (reroll == pointVal) {
                    System.out.println("You win, sonny.");
                    break;
                } else if (reroll == 7) {
                    System.out.println("You looo0se, sonny.");
                    break;
                }
                
            }
        }
        
        System.out.println("Game over.");
    }

    public static int rollDice(int numDice) {
        // rolls numDice dice and returns sum of rolled values
        System.out.println("\nRolling...");
        int rollSum = 0;
        int roll;
        for (int i = 0; i < numDice; i++) {
            roll = (int)Math.ceil(Math.random() * 6);
            rollSum += roll;
            System.out.println("Rolled " + roll + "...");
        }
        return rollSum;
    }
}
