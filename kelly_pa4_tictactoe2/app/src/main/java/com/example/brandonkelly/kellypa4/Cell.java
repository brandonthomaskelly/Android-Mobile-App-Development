package com.example.brandonkelly.kellypa4;/*
Cell: represents a cell on the board. Cell should contain the following fields and methods (at a minimum):
        coordinates: the coordinates (location) of this cell on the board (a Coordinates object).
        symbol: the symbol denoting who occupies this cell (character ‘X’ for player one, ‘O’ for the other player, ‘-’ for unoccupied)
        toString(): returns a string representation of a Cell (return the symbol)
*/

/**
 *
 * The Cell class represents a cell on the board.
 * CPSC 312-01, Fall 2017
 * Assignment number 1
 * No sources to cite.
 * @author Brandon Kelly
 * @version v1.0 09/13/2017
 */


public class Cell {
    Coordinates coord;
    char symbol;

    public Cell(Coordinates c, char sym) {
        coord = c;
        symbol = sym;
    }

    public String toString() {
        return String.valueOf(this.symbol);
    }

    public Coordinates getCoord() {
        return this.coord;
    }

    public char getPlayerSym() {
        return this.symbol;
    }

}
