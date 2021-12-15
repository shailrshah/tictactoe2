package com.shail.tictactoe2.game.component;

import java.util.Scanner;

import com.shail.tictactoe2.game.entity.Board;
import com.shail.tictactoe2.game.entity.Move;
import com.shail.tictactoe2.game.entity.Symbol;
import com.shail.tictactoe2.game.exception.MoveNotPossibleException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class MoveGetterConsole implements MoveGetter {

    private final MoveHistoryKeeper moveLogger;
    private final Scanner scanner;

    public Move getMove(final Symbol symbol, final Board board) throws MoveNotPossibleException {
        final int firstInt = scanner.nextInt();
        final int secondInt = scanner.nextInt();

        final Move move = isUndoMove(firstInt, secondInt) ?
                getUndoMove() :
                getNormalMove(firstInt, secondInt, symbol);

        if(board.isIllegalMove(move)) {
            throw new MoveNotPossibleException("Cannot make that move on the board. Try again.");
        }

        return move;
    }

    private boolean isUndoMove(int firstInt, int secondInt) {
        return firstInt == -1 && secondInt == -1;
    }

    private Move getUndoMove() throws MoveNotPossibleException {
        if(moveLogger.isEmpty()) {
            throw new MoveNotPossibleException("Nothing to undo.");
        }
        final Move prevMove = moveLogger.popMove();
        log.info("Undoing move.");
        return new Move(prevMove.getSymbol(), prevMove.getRow(), prevMove.getCol(), true);
    }

    private Move getNormalMove(int row, int col, Symbol symbol) {
        return new Move(symbol, row, col, false);
    }
}
