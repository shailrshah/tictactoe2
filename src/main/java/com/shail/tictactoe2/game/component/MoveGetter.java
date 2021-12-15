package com.shail.tictactoe2.game.component;

import com.shail.tictactoe2.game.entity.Board;
import com.shail.tictactoe2.game.entity.Move;
import com.shail.tictactoe2.game.entity.Symbol;
import com.shail.tictactoe2.game.exception.MoveNotPossibleException;

public interface MoveGetter {
    Move getMove(final Symbol symbol, final Board board) throws MoveNotPossibleException;
}
