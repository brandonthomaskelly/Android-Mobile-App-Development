/**
 * A driver class that contains the main method and drives your program. The design of this class (and helper classes) is up to you!
 *
 * The driver class for CPSC 312 tic-tac-toe game
 * CPSC 312-01, Fall 2017
 * Assignment number 1
 * No sources to cite.
 * @author Brandon Kelly
 * @version v1.0 09/13/2017
 */

// Necessary for user input
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        int turnNumber = 0; // Keeps track of turn # ... essentially just to use in the trycatch below since I did not do extra credit
        int boardDimension = 0; // Variable to let user specify board dimension
        Scanner scanner = new Scanner(System.in);
        boolean on = false; // Boolean used to determine if the game is still running or not

        System.out.println("Welcome to Tic Tac Toe! There are two players, player 'X' and player 'O'.\n");
        System.out.println("Please enter the dimension, N, of the NxN Tic Tac Toe board (an integer in [3, 9]): ");
        boardDimension = scanner.nextInt();
        scanner.nextLine();

        TicTacToeBoard tictactoe = new TicTacToeBoard(boardDimension);
        while (!on) { // Keeps the game looping while there is no draw or winner
            char symbol = ' ';
            if (turnNumber % 2 == 0) {
                System.out.println(tictactoe.toString());
                System.out.println("Player X: Please enter coordinates(" + "0" + " - " + (boardDimension - 1) + " both directions): ");
                symbol = 'X';
            } else {
                System.out.println(tictactoe.toString());
                System.out.println("Player O: Please enter coordinates(" + "0" + " - " + (boardDimension - 1) + " both directions): ");
                symbol = 'O';
            }

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            try {
                if (tictactoe.makeMove(new Coordinates(row, col), symbol))
                    turnNumber++;
            } catch (Exception e) {
                System.out.println("Please enter a valid coordinate.");
            }

            on = tictactoe.isWinner(symbol);

            if (on) { // Case when the game is over - determines draw or winner
                if (tictactoe.getState() == boardDimension * boardDimension)
                    System.out.println("The game ends in a draw! Scratch. Sucks.");
                else {
                    System.out.println("Player " + symbol + " is the winner.");
                }
            }
        }
        scanner.close();
    }

}
