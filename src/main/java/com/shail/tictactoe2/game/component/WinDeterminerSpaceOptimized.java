package com.shail.tictactoe2.game.component;

import com.shail.tictactoe2.game.entity.Board;
import com.shail.tictactoe2.game.entity.Move;
import com.shail.tictactoe2.game.entity.Symbol;
import com.shail.tictactoe2.game.helper.BoardUtil;
import org.springframework.stereotype.Component;

/**
 * Determine if the move is a winning move in
 * O(1) space complexity but with O(n) time complexity
 */
@Component
public class WinDeterminerSpaceOptimized implements WinDeterminer {
    public boolean isWinningMove(Move move, Board board) {
        if(move.isUndo()) {
            return false;
        }

        final Symbol symbol = move.getSymbol();
        final int row = move.getRow();
        final int col = move.getCol();

        return hasWonByRow(symbol, board, row) ||
                hasWonByCol(symbol, board, col) ||
                (BoardUtil.isOnDiagonal(row, col) && hasWonByDiagonal(symbol, board)) ||
                (BoardUtil.isOnAntiDiagonal(row, col, board.getSize()) && hasWonByAntiDiagonal(symbol, board));
    }

    private boolean hasWonByRow(Symbol symbol, Board board, int row) {
        for(int i = 0; i < board.getSize(); i++) {
            if(board.getSymbol(row, i) != symbol) {
                return false;
            }
        }

        return true;
    }

    private boolean hasWonByCol(Symbol symbol, Board board, int col) {
        for(int i = 0; i < board.getSize(); i++) {
            if(board.getSymbol(i, col) != symbol) {
                return false;
            }
        }

        return true;
    }

    private boolean hasWonByDiagonal(Symbol symbol, Board board) {
        for(int i = 0; i < board.getSize(); i++) {
            if(board.getSymbol(i, i) != symbol) {
                return false;
            }
        }

        return true;
    }

    private boolean hasWonByAntiDiagonal(Symbol symbol, Board board) {
        for(int i = board.getSize() - 1; i >= 0; i--) {
            for (int j = 0; j < board.getSize(); j++)
                if (board.getSymbol(i, j) != symbol) {
                    return false;
                }
        }

        return true;
    }
}