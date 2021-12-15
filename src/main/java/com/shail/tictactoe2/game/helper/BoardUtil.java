package com.shail.tictactoe2.game.helper;

/**
 * Board utilities
 */
public class BoardUtil {
    /**
     * Compute whether the given (row, col) is on the top-left to bottom-right diagonal
     * @param row the row
     * @param col the column
     * @return true iff the point is on the top-left to bottom-right diagonal
     */
    public static boolean isOnDiagonal(final int row, final int col) {
        return row == col;
    }

    /**
     * Compute weather the given (row, col) is on the bottom-left to top-right diagonal
     * @param row the row
     * @param col the column
     * @return true iff the point is on the bottom-left to top-right diagonal
     */
    public static boolean isOnAntiDiagonal(final int row, final int col, final int boardSize) {
        return row + col == boardSize - 1;
    }
}
