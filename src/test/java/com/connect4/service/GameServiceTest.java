package com.connect4.service;

import com.connect4.Connect4;
import com.connect4.model.*;
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
    public void should_detect_a_winner_right_transversal_2(){
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
                .color(Color.Yellow)
                .build();

        game.getGrid()[5][7] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[4][8] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[3][9] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[2][10] = Coin.newCoin()
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



    @Test
    public void should_detect_a_winner_left_transversal(){
        Game game  = new Game();

        game.getGrid()[8][9] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[7][8] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[6][7] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[5][6] = Coin.newCoin()
                .color(Color.Red)
                .build();

        assertThat(gameService.checkLeftTransversal(game, Color.Red)).isTrue();
    }
    @Test
    public void should_detect_a_winner_left_transversal_2(){
        Game game  = new Game();

        game.getGrid()[8][9] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[7][8] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[6][7] = Coin.newCoin()
                .color(Color.Yellow)
                .build();

        game.getGrid()[5][6] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[4][5] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[3][4] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[2][3] = Coin.newCoin()
                .color(Color.Red)
                .build();

        assertThat(gameService.checkLeftTransversal(game, Color.Red)).isTrue();
    }
    @Test
    public void should_not_detect_a_winner_left_transversal_2(){
        Game game  = new Game();

        game.getGrid()[8][9] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[7][8] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[6][7] = Coin.newCoin()
                .color(Color.Yellow)
                .build();

        game.getGrid()[5][6] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[3][4] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[2][3] = Coin.newCoin()
                .color(Color.Red)
                .build();

        assertThat(gameService.checkLeftTransversal(game, Color.Red)).isFalse();
    }


    @Test
    public void should_return_an_empty_position_for_a_given_column(){
        Game game  = new Game();

        game.getGrid()[14][7] = Coin.newCoin()
                .color(Color.Red)
                .build();

        Coordinate coordinate = gameService.getEmptyPositionAtColumn(game, 7);
        assertThat(coordinate.getX()).isEqualTo(13);
        assertThat(coordinate.getY()).isEqualTo(7);
    }

    @Test
    public void should_return_an_empty_position_for_a_given_column_2(){
        Game game  = new Game();

        game.getGrid()[14][7] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[13][7] = Coin.newCoin()
                .color(Color.Red)
                .build();

        Coordinate coordinate = gameService.getEmptyPositionAtColumn(game, 7);
        assertThat(coordinate.getX()).isEqualTo(12);
        assertThat(coordinate.getY()).isEqualTo(7);
    }

    @Test(expected = RuntimeException.class)
    public void should_throw_a_runtime_exception_when_a_column_is_full(){
        Game game  = new Game();
        int column = 5;

        game.getGrid()[0][column] = Coin.newCoin().build();
        game.getGrid()[1][column] = Coin.newCoin().build();
        game.getGrid()[2][column] = Coin.newCoin().build();
        game.getGrid()[3][column] = Coin.newCoin().build();
        game.getGrid()[4][column] = Coin.newCoin().build();
        game.getGrid()[5][column] = Coin.newCoin().build();
        game.getGrid()[6][column] = Coin.newCoin().build();
        game.getGrid()[7][column] = Coin.newCoin().build();
        game.getGrid()[8][column] = Coin.newCoin().build();
        game.getGrid()[9][column] = Coin.newCoin().build();
        game.getGrid()[10][column] = Coin.newCoin().build();
        game.getGrid()[11][column] = Coin.newCoin().build();
        game.getGrid()[12][column] = Coin.newCoin().build();
        game.getGrid()[13][column] = Coin.newCoin().build();
        game.getGrid()[14][column] = Coin.newCoin().build();

        gameService.getEmptyPositionAtColumn(game, column);
    }

    @Test
    public void should_return_a_game_id_when_a_game_is_created(){
        Game game = gameService.newGame(new Player());

        assertThat(game).isNotNull();
        assertThat(game.getGameId()).isNotNull();
    }
}