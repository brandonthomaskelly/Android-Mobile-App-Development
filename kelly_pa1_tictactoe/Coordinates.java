/*
Coordinates: represents the coordinates of a cell on the board. Coordinates should contain the following fields and methods (at a minimum):
        row: a row location
        col: a column location
        toString(): returns a string representation of a Coordinate, i.e. (0, 0)
*/

/**
 *
 * The coordinate represents the coordinate of the cell on the board.
 * CPSC 312-01, Fall 2017
 * Assignment number 1
 * No sources to cite.
 * @author Brandon Kelly
 * @version v1.0 09/13/2017
 */

public class Coordinates {
    public int row; // Used to hold row location
    public int col; // Used to hold column location

    public String toString() { // String representation of the coordinate
        return String.valueOf(this.row) + ", " + String.valueOf(this.col);
    }

    public Coordinates(int tRow, int tCol) { // Current values
        this.col = tCol;
        this.row = tRow;
    }

}
