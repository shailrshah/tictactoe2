package com.shail.tictactoe2.game.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Move {
    private final Symbol symbol;
    private final int row;
    private final int col;
    private final boolean isUndo;
}
