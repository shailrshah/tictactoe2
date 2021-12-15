package com.shail.tictactoe2.game.component;

import java.util.Stack;

import com.shail.tictactoe2.game.entity.Move;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MoveHistoryKeeper {
    private final Stack<Move> history;

    public MoveHistoryKeeper() {
        this.history = new Stack<>();
    }

    public void logMove(final Move move) {
        log.info(move.toString());
        if(!move.isUndo()) {
            history.push(move);
        }
    }

    public Move popMove() {
        return history.pop();
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }
}
