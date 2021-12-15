package com.shail.tictactoe2;

import java.util.Scanner;

import com.shail.tictactoe2.game.entity.Player;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {
    private static final int BOARD_SIZE = 3;
    private static final String PLAYER1_NAME = "Player 1";
    private static final String PLAYER2_NAME = "Player 2";

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

    @Bean
    public int boardSize() {
        return BOARD_SIZE;
    }

    @Bean
    public Player player1() {
        return new Player(PLAYER1_NAME);
    }

    @Bean
    public Player player2() {
        return new Player(PLAYER2_NAME);
    }
}
