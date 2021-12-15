package com.shail.tictactoe2.game.component;

import com.shail.tictactoe2.game.entity.Board;
import com.shail.tictactoe2.game.entity.Move;
import com.shail.tictactoe2.game.entity.Symbol;
import com.shail.tictactoe2.game.helper.BoardUtil;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Determine if the move is a winning move in
 * O(1) time complexity but with O(n) space complexity
 */
@Component
@Primary
public class WinDeterminerTimeOptimized implements WinDeterminer {
    private final int[] rows;
    private final int[] cols;
    private int diagonal;
    private int antiDiagonal;
    private final int boardSize;

    public WinDeterminerTimeOptimized(final int boardSize) {
        this.boardSize = boardSize;
        rows = new int[boardSize];
        cols = new int[boardSize];
        diagonal = 0;
        antiDiagonal = 0;
    }

    @Override
    public boolean isWinningMove(final Move move, final Board board) {
        final int addValue = getValue(move.getSymbol(), move.isUndo());
        final int target = getTarget(move.getSymbol());

        rows[move.getRow()] += addValue;
        cols[move.getCol()] += addValue;

        if(BoardUtil.isOnDiagonal(move.getRow(), move.getCol())) {
            diagonal += addValue;
        }

        if(BoardUtil.isOnAntiDiagonal(move.getRow(), move.getCol(), boardSize)) {
            antiDiagonal += addValue;
        }

        return !move.isUndo() &&
                rows[move.getRow()] == target || cols[move.getCol()] == target ||
                diagonal == target || antiDiagonal == target;
    }

    private int getValue(final Symbol symbol, boolean isUndo) {
        return (isUndo ? -1 : 1) * (symbol == Symbol.O ? 1 : -1);
    }

    private int getTarget(final Symbol symbol) {
        return symbol == Symbol.O ? boardSize : -boardSize;
    }
}
