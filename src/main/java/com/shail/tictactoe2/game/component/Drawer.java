package com.shail.tictactoe2.game.component;

import java.util.List;

import com.shail.tictactoe2.game.entity.Board;

/**
 * Interface to draw the board
 */
public interface Drawer {
    /**
     * Draw the board
     * @param board the board
     */
    List<String> draw(final Board board);
}
