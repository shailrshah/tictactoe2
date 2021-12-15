package com.shail.tictactoe2.game;

import java.util.Map;
import java.util.Optional;

import com.shail.tictactoe2.game.entity.Board;
import com.shail.tictactoe2.game.entity.Move;
import com.shail.tictactoe2.game.entity.Player;
import com.shail.tictactoe2.game.entity.Symbol;
import com.shail.tictactoe2.game.exception.MoveNotPossibleException;
import com.shail.tictactoe2.game.component.Drawer;
import com.shail.tictactoe2.game.component.MoveGetter;
import com.shail.tictactoe2.game.component.MoveHistoryKeeper;
import com.shail.tictactoe2.game.component.WinDeterminer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class TicTacToe implements Game {
    private final Player player1;
    private final Player player2;
    private final Board board;
    private final WinDeterminer winDeterminer;
    private final Drawer drawer;
    private final MoveHistoryKeeper moveLogger;
    private final MoveGetter moveGetter;

    @Override
    public void play() {
        final Optional<Player> player = getWinner();

        final String resultMessage = player.map(Player::getName)
                .map(name -> name + " wins!")
                .orElse("It's a tie!");
        log.info(resultMessage);
    }

    /**
     * Get the winner after a round of tic tac toe
     * @return the winner wrapped in an optional, if there is one
     */
    private Optional<Player> getWinner() {
        Player currentPlayer = this.player1;

        while(board.hasEmptySpace()) {
            logBoard();

            log.info("Type '-1 -1' to undo move. Otherwise, it's {}'s turn.", currentPlayer.getName());

            final Move move;
            try {
                move = moveGetter.getMove(getSymbol(currentPlayer), board);
            } catch(MoveNotPossibleException e) {
                log.error(e.getMessage());
                continue;
            }

            board.makeMove(move);
            moveLogger.logMove(move);
            if(winDeterminer.isWinningMove(move, board)) {
                logBoard();
                return Optional.of(currentPlayer);
            }

            currentPlayer = togglePlayer(currentPlayer);
        }

        // Out of empty spaces on the board - tie
        return Optional.empty();
    }

    private Symbol getSymbol(final Player currentPlayer) {
        return currentPlayer == this.player1 ? Symbol.O : Symbol.X;
    }

    private Player togglePlayer(final Player currentPlayer) {
        return  (currentPlayer == this.player1 ? this.player2 : player1);
    }

    private void logBoard() {
        for(String line : drawer.draw(board)) {
            log.info(line);
        }
    }
}
