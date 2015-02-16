package ps3n3Arrays2D;

import java.util.Random;
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
            if (checkWinner(board, playerChar, botChar) > 0) {
                break;
            }
            botMove(board, botChar);
            if (checkWinner(board, playerChar, botChar) > 0) {
                break; 
            }
        }
        // Rechecks for winner/tie and stores as variable to describe winner/tie
        int winner = checkWinner(board, playerChar, botChar);
        if (winner == 2) {
            System.out.println("PC WINS");
        } else if (winner == 3) {
            System.out.println("BOT WINS");
        } else {
            System.out.println("A TIE!");
        }
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
        // Prints new board
        for (int c = 0; c < gameBoard.length; c++) {
            for (int r = 0; r < gameBoard[c].length; r ++) {
                System.out.print("|" + gameBoard[c][r]);
                }
            System.out.println("|");
            }
        System.out.println();
        }
    
    public static void playerMove(String[][] gameBoard,String playerChar, Scanner inpt) {
        // Allows the player to make a single move, using the numpad layout
        // Then draws board
        int[] chosenSpace;
                
        System.out.println();
        while (true) {
            int playerChoice = Validator.getInt(inpt, "Enter space to place '" + playerChar + "' based on numpad coordinates: ");
            if (playerChoice >= 1 && playerChoice <= 9) {
                chosenSpace = numToXY(playerChoice);
            } else {
                System.out.println("Please only enter values between 1 and 9.");
                continue;
            }
            if (checkSpace(gameBoard, chosenSpace, " ")) {
                gameBoard[chosenSpace[0]][chosenSpace[1]] = playerChar;
                drawBoard(gameBoard);
                return;
            } else {
                System.out.println("Please choose a vacant space.");
            }
        }
    }
    
    public static void botMove(String[][] gameBoard, String botChar) {
        // Allows the bot to make a (semi-Random) single move
        // Then draws board
        Random rand = new Random();
        while (true) {
            int spaceNum = (int) (rand.nextDouble() * 9); 
            int[] space = numToXY(spaceNum);
            if (gameBoard[space[0]][space[1]].equals(" ")) {
                gameBoard[space[0]][space[1]] = botChar;
                drawBoard(gameBoard);
                return;
            }
        }
    }
    
    public static int checkWinner(String[][] gameBoard, String playerChar, String botChar) {
        // Processes gameboard to determine if there is a winner
        // Returns 0 for no winner yet, 1 for tie, 2 for PC, 3 for NPC
        
        // Check horizontals/rows first
        for (int r = 0; r < 3; r++) {
            // Check if space is not blank, and if all spaces on row share the character
            if (gameBoard[0][r].equals(gameBoard[1][r]) && gameBoard[1][r].equals(gameBoard[2][r])) {
                if (gameBoard[0][r].equals(playerChar)) {
                    return 2;
                } else if (gameBoard[0][r].equals(botChar))  {
                    return 3;
                }
            }
        }
        
        // Now check columns/verticals victories
        for (int c = 0; c < 3; c++) {
            // Check if space is not blank, and if all spaces on row share the character
            if (gameBoard[c][0].equals(gameBoard[c][1]) && gameBoard[c][1].equals(gameBoard[c][2])) {
                if (gameBoard[c][0].equals(playerChar)) {
                    return 2;
                } else if (gameBoard[c][0].equals(botChar))  {
                    return 3;
                }
            }
        }
        
        // Check diagonals
        if (gameBoard[2][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[0][2])) {
            if (gameBoard[1][1].equals(playerChar)) {
                    return 2;
            } else if (gameBoard[1][1].equals(botChar))  {
                    return 3;
            }
        }
        
        if (gameBoard[0][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][2])) {
            if (gameBoard[1][1].equals(playerChar)) {
                    return 2;
            } else if (gameBoard[1][1].equals(botChar))  {
                    return 3;
            }
        }
        
        //Check to see if board is full, despite no winner! A TIE!
        int fullBoardCount = 0;
        for (int i = 1; i <=9; i++) {
            int[] spaceXY = numToXY(i);
            if (gameBoard[spaceXY[0]][spaceXY[1]].equals(" ")) {
                return 0;
            } else {
                fullBoardCount++;
            }
        }
        if (fullBoardCount == 9) {
            return 1;
        }
        return 0; //This should never be reached-- needed for compiler
    }
    
    public static int[] numToXY(int numpad) {
        // Converts a numpad value to a two item array representing ordered pair,
        // from 0,0 (7) to 2,2 (3). First value is y, or which row you're on
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
    
    public static boolean checkSpace(String[][] gameBoard, int[] spaceXY, String checkFor) {
        // Checks if spaceXY[x][y] is equal to "checkFor" argument on gameBoard[x][y]
        // Returns true if space is equal to "checkFor" value, else false
        if (gameBoard[spaceXY[0]][spaceXY[1]].equals(checkFor)) {
            return true;
        }
        return false;
    }
} 