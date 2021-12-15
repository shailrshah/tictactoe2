package com.shail.tictactoe2.game.entity;

import java.util.Arrays;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class Board {
    private final Symbol[][] board;

    @Getter
    private final int size;

    private int emptySpaces;

    public Board(final int boardSize) {
        this.size = boardSize;
        this.emptySpaces = size * size;

        board = new Symbol[size][size];
        for (Symbol[] row : board)
            Arrays.fill(row, Symbol.EMPTY);
    }

    public Symbol getSymbol(final int row, final int col) {
        return board[row][col];
    }

    public void makeMove(final Move move) {
        Symbol symbol = move.isUndo() ? Symbol.EMPTY : move.getSymbol();
        board[move.getRow()][move.getCol()] = symbol;
        emptySpaces += (symbol == Symbol.EMPTY ? 1 : -1);
    }

    public boolean hasEmptySpace() {
        return emptySpaces > 0;
    }

    /**
     * Compute whether or not the move can be made
     * @param move the move
     * @return true iff the move can be made on the board
     */
    public boolean isIllegalMove(final Move move) {
        final boolean isOutsideBoard = move.getRow() < 0 ||
                move.getRow() >= size ||
                move.getCol() < 0 ||
                move.getCol() >= size;

        return isOutsideBoard ||
                (!move.isUndo() && board[move.getRow()][move.getCol()] != Symbol.EMPTY);
    }
}
