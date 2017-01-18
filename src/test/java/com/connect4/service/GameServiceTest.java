package com.connect4.service;

import com.connect4.Connect4;
import com.connect4.model.Coin;
import com.connect4.model.Color;
import com.connect4.model.Game;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Connect4.class)
public class GameServiceTest {

    @Autowired
    GameService gameService;

    @Test
    public void should_detect_a_winner_horizontally(){
        Game game  = new Game();

        game.getGrid()[14][5] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[14][6] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[14][7] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[14][8] = Coin.newCoin()
                .color(Color.Red)
                .build();

        assertThat(gameService.checkHorizontally(game, Color.Red)).isTrue();
    }

    @Test
    public void should_detect_a_winner_horizontally_2(){
        Game game  = new Game();

        game.getGrid()[14][5] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[14][6] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[14][7] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[14][8] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[14][9] = Coin.newCoin()
                .color(Color.Yellow)
                .build();


        assertThat(gameService.checkHorizontally(game, Color.Red)).isTrue();
    }

    @Test
    public void should_not_detect_a_winner_horizontally(){
        Game game  = new Game();

        game.getGrid()[14][5] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[14][6] = Coin.newCoin()
                .color(Color.Yellow)
                .build();

        game.getGrid()[14][7] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[14][8] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[14][9] = Coin.newCoin()
                .color(Color.Red)
                .build();

        assertThat(gameService.checkHorizontally(game, Color.Red)).isFalse();
    }

    @Test
    public void should_detect_a_winner_vertically(){
        Game game  = new Game();

        game.getGrid()[10][5] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[11][5] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[12][5] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[13][5] = Coin.newCoin()
                .color(Color.Red)
                .build();

        assertThat(gameService.checkVertically(game, Color.Red)).isTrue();
    }

    @Test
    public void should_not_detect_a_winner_vertically(){
        Game game  = new Game();

        game.getGrid()[10][5] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[11][5] = Coin.newCoin()
                .color(Color.Yellow)
                .build();

        game.getGrid()[12][5] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[13][5] = Coin.newCoin()
                .color(Color.Red)
                .build();

        assertThat(gameService.checkVertically(game, Color.Red)).isFalse();
    }

    @Test
    public void should_detect_a_winner_right_transversal(){
        Game game  = new Game();

        game.getGrid()[9][3] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[8][4] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[7][5] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[6][6] = Coin.newCoin()
                .color(Color.Red)
                .build();

        assertThat(gameService.checkRightTransversal(game, Color.Red)).isTrue();
    }

    @Test
    public void should_not_detect_a_winner_right_transversal(){
        Game game  = new Game();

        game.getGrid()[9][3] = Coin.newCoin()
                .color(Color.Red)
                .build();

        assertThat(gameService.checkRightTransversal(game, Color.Red)).isFalse();
    }

}