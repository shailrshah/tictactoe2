package com.shail.tictactoe2;

import com.shail.tictactoe2.game.Game;
import javax.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class Application {

    @Resource
    private final Game ticTacToe;

    private void start() {
        ticTacToe.play();
    }
}
