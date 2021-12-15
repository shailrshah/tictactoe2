package com.shail.tictactoe2.game.entity;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
public enum Symbol {
    O("O"),
    X("X"),
    EMPTY("-");

    private final String label;

    @Override
    public String toString() {
        return label;
    }
}
