package ps3n3Arrays2D;

import java.util.Scanner;
import myutil.Validator;

/**
 * Write a program that enables two humans to interactively play a simple game
 * of tic-tac-toe against each other. Store the game board in a 2d array.
 *
 * @author Marshall Ehlinger
 */
public class C8N9TicTacToe {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] board = new String[3][3];
        String playerChar = "X";
        String botChar = "O";
        
        populateEmptyBoard(board);
        drawBoard(board);
        while (true) {
            //Game logic 
            playerMove(board, playerChar, sc);
            if (checkWinner(board) > 0) {
                break;
            }
            botMove(board, botChar);
            if (checkWinner(board) > 0) {
                break; 
            }
        }
        // Rechecks for winner/tie and stores as variable to describe winner/tie
        int winner = checkWinner(board);
    }
    
    public static void populateEmptyBoard(String[][] gameBoard) {
        // Populates empty gameboard with blank space strings for console display
        for (int c = 0; c < gameBoard.length; c++) {
            for (int r = 0; r < gameBoard[c].length; r ++) {
                gameBoard[c][r] = " ";
            
            }
        }
    }
    
    public static void drawBoard(String[][] gameBoard) {
        // Clears console and prints new board
        clearConsole();
        for (int c = 0; c < gameBoard.length; c++) {
            for (int r = 0; r < gameBoard[c].length; r ++) {
                System.out.print("|" + gameBoard[c][r]);
                }
            System.out.println("|");
            }
        }
    
    public static void playerMove(String[][] gameBoard,String playerChar, Scanner inpt) {
        // Allows the player to make a single move, using the numpad layout
        int[] chosenSpace = new int[2];
                
        System.out.println();
        while (true) {
            int playerChoice = Validator.getInt(inpt, "Enter space to place '" + playerChar + "' based on numpad coordinates: ");
            if (playerChoice >= 1 && playerChoice <= 9) {
                chosenSpace = numpadToCoord(playerChoice);
            } else {
                System.out.println("Please only eneter values between 1 and 9.");
                continue;
            }
            if (checkSpace(gameBoard, chosenSpace)) {
                gameBoard[chosenSpace[0]][chosenSpace[1]] = playerChar;
                drawBoard(gameBoard);
            } else {
                System.out.println("Please choose a vacant space.");
            }
        }
    }
    
    public static void botMove(String[][] gameBoard, String botChar) {
        // Allows the NPC bot to make a single move
    }
    
    public static int checkWinner(String[][] gameBoard) {
        // Processes gameboard to determine if there is a winner
        // Returns 0 for no winner yet, 1 for tie, 2 for PC, 3 for NPC
        
        return 0;
    }
    
    public static int[] numpadToCoord(int numpad) {
        int[] xy = new int[2];
        
        switch (numpad) {
            case 1: xy[0] = 2;
                    xy[1] = 0;
                    break;
            case 2: xy[0] = 2;
                    xy[1] = 1;
                    break; 
            case 3: xy[0] = 2;
                    xy[1] = 2;
                    break;
            case 4: xy[0] = 1;
                    xy[1] = 0;
                    break; 
            case 5: xy[0] = 1;
                    xy[1] = 1;
                    break; 
            case 6: xy[0] = 1;
                    xy[1] = 2;
                    break; 
            case 7: xy[0] = 0;
                    xy[1] = 0;
                    break;
            case 8: xy[0] = 0;
                    xy[1] = 1;
                    break;
            case 9: xy[0] = 0;
                    xy[1] = 2;
                    break;
            default: System.out.println("Invalid switch error : numpadToCoord()");
                    break;
        }
        
        return xy;
    }
    
    public static boolean checkSpace(String[][] gameBoard, int[] spaceXY) {
        // Checks if spaceXY[x][y] is free (equals " ") on gameBoard[x][y]
        // Returns true if space is empty, aka .equals(" "), else false
        if (gameBoard[spaceXY[0]][spaceXY[1]].equals(" ")) {
            return true;
        }
        return false;
    }
    
    public final static void clearConsole()
{
    try
    {
        final String os = System.getProperty("os.name");

        if (os.contains("Windows"))
        {
            Runtime.getRuntime().exec("cls");
        }
        else
        {
            Runtime.getRuntime().exec("clear");
        }
    }
    catch (final Exception e)
    {
        System.out.println("(Console clear failure)");
    }
}
}
 