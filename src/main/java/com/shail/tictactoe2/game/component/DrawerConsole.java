package com.shail.tictactoe2.game.component;

import java.util.ArrayList;
import java.util.List;

import com.shail.tictactoe2.game.entity.Board;
import org.springframework.stereotype.Component;

/**
 * Drawer for the console
 */
@Component
public class DrawerConsole implements Drawer{

    @Override
    public List<String> draw(final Board board) {
        final int size = board.getSize();
        final StringBuilder sb = new StringBuilder();
        final List<String> lines = new ArrayList<>();

        for(int row = 0; row < size; row++) {
            sb.setLength(0);

            for (int col = 0; col < size; col++) {
                sb.append(board.getSymbol(row, col));
                sb.append("    ");
            }
            lines.add(sb.toString());
        }

        return lines;
    }
}
