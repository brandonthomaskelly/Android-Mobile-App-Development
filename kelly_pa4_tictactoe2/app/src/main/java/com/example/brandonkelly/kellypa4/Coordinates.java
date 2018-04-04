package com.example.brandonkelly.kellypa4;/*
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
	/*
	 * row: a row location col: a column location toString(): returns a string
	 * representation of a Coordinate, i.e. (0, 0)
	 */

    public int row;
    public int col;

    public Coordinates(int _row, int _col) {
        this.row = _row;
        this.col = _col;
    }

    public String toString() {
        return String.valueOf(this.row) + ", " + String.valueOf(this.col);
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

}