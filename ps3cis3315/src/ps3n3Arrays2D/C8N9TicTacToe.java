package ps3n3Arrays2D;

/**
 * Write a program that enables two humans to interactively play a simple game
 * of tic-tac-toe against each other. Store the game board in a 2d array.
 *
 * @author Your Name Here
 */
public class C8N9TicTacToe {

    public static void main(String[] args) {
        String[][] board = new String[3][3];
        populateEmptyBoard(board);
        drawBoard(board);
        while (true) {
            //Game logic
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
        // Clears console and prints new board
        for (int c = 0; c < gameBoard.length; c++) {
            for (int r = 0; r < gameBoard[c].length; r ++) {
                System.out.print("|" + gameBoard[c][r]);
                }
            System.out.println("|");
            }
        }
    
    public static void playerMove(String[][] gameBoard) {
        // Allows the player to make a single move, using the numpad layout
    }
    
    public static void botMove(String[][] gameBoard) {
        // Allows the NPC bot to make a single move
    }
    
    public static void checkWinner(String[][] gameBoard) {
        // Processes gameboard to determine if there is a winner
    }
}
 