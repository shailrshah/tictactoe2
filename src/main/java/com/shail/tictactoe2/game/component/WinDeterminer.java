package com.shail.tictactoe2.game.component;

import com.shail.tictactoe2.game.entity.Board;
import com.shail.tictactoe2.game.entity.Move;

public interface WinDeterminer {

    /**
     * Make a move on the board by placing a given symbol
     * @param move the move
     * @param board the board
     * @return true if the move was a winning move
     */
    boolean isWinningMove(Move move, Board board);
}
