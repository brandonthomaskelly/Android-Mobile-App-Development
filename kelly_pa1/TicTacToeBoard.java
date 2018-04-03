/*
TicTacToeBoard: represents the Tic Tac Toe board. TicTacToeBoard should contain the following fields and methods (at a minimum):
        N: dimension of board
        grid: the Tic Tac Toe N x N grid (a 2-Dimensional array of Cell objects)
        toString(): returns a string representation of a TicTacToeBoard (display the cells in the grid)
        Hint: call Cell’s toString() :)
        isValidMove(Coordinates coordinates): accepts the coordinate of a cell. Returns true if the coordinates are valid and the cell is unoccuppied; otherwise returns false.
        makeMove(Coordinates coordinates, char playerSymbol): accepts the coordinates of a cell and a player’s symbol. Marks the cell with the symbol.
        isWinner(char playerSymbol): accepts a player symbol (‘X’ or ‘O’). Returns true if there are N in a row of the player’s symbol; otherwise returns false
*/
// boardDimensions should have been N


/**
 * TicTacToeBoard represents the board itself
 *
 * The TicTacToeBoard class for CPSC 312 tic-tac-toe game
 * CPSC 312-01, Fall 2017
 * Assignment number 1
 * No sources to cite.
 * @author Brandon Kelly
 * @version v1.0 09/13/2017
 */

import java.util.Arrays;

public class TicTacToeBoard {

    int takenSpaces;
    int boardDimensions;
    Cell[][] grid;

    public TicTacToeBoard(int tBoardDimensions) {
        takenSpaces = 0;

        this.boardDimensions = tBoardDimensions;
        this.grid = new Cell[boardDimensions][boardDimensions];

        // Loops through the board with specified dimensions
        for (int row = 0; row < boardDimensions; row++)
            for (int col = 0; col < boardDimensions; col++)
                grid[row][col] = new Cell(new Coordinates(row, col), ' ');
    }

    // toString used to create the "board" itself
    public String toString() {
        return Arrays.deepToString(grid).replace("], ", "]\n").replace("[[", "[").replace("]]", "]");
    }

    // Checks if there is a "piece" already in that coordinate location
    public boolean isValidMove(Coordinates coordinates) {
        return grid[coordinates.row][coordinates.col].Symbol() == ' ';
    }

    // Used to determine if the move you want to make is valid utilizing isValidMove()
    public boolean makeMove(Coordinates coordinates, char playerSymbol) {
        if (isValidMove(coordinates)) {
            grid[coordinates.row][coordinates.col] = new Cell(coordinates, playerSymbol);
            this.takenSpaces++; // Incremented everytime to use for draw condition
          return true;
        } else
            System.out.println("Please enter a valid move.");
        return false;
    }

    public boolean isWinner(char playerSymbol) {
        int diagonalOne = 0;
        int diagonalTwo = 0;
        int counter = 0;

        // Loops through the board to check for diagonals
        for (int i = 0; i < boardDimensions; i++) {
            for (int j = 0; j < boardDimensions; j++) {
                if (i == j && grid[i][j].Symbol() == playerSymbol)
                    diagonalOne++;

                if (i + j == (boardDimensions - 1) && grid[i][j].Symbol() == playerSymbol)
                    diagonalTwo++;

                if (grid[j][i].Symbol() == playerSymbol)
                    counter++;

                if (counter == boardDimensions || diagonalOne == boardDimensions || diagonalTwo == boardDimensions)
                    return true;
            }
            counter = 0;
        }


        if (this.takenSpaces == (boardDimensions * boardDimensions)) { // Statement for the draw case
            System.out.println("The game ends in a draw!");
            return true;
        }
        return false;
    }

    // Used to decide if game is a tie or not
    public int getState() {
        return this.takenSpaces;
    }

}
