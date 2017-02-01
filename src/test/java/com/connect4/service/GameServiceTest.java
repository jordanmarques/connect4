package com.connect4.service;

import com.connect4.Connect4;
import com.connect4.dto.GameResponse;
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

    @Autowired
    Games games;

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

    @Test
    public void should_set_game_state_to_WAITING_FOR_OPPONENT_when_a_game_is_created(){
        Game game = gameService.newGame(new Player());

        assertThat(game).isNotNull();
        assertThat(game.getGameId()).isNotNull();
        assertThat(game.getState()).isEqualTo(State.WAITING_FOR_OPPONENT);
    }

    @Test
    public void should_add_player_to_a_game(){
        Game game = gameService.newGame(new Player());
        gameService.addPlayerToGame(new Player(), game.getGameId());

        assertThat(games.getGames().get(game.getGameId()).getPlayers()).hasSize(2);
    }

    @Test
    public void should_add_a_coin_at_the_top_of_a_given_column(){
        Game game  = gameService.newGame(new Player());

        game.getGrid()[14][7] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[13][7] = Coin.newCoin()
                .color(Color.Red)
                .build();

        Coordinate coordinate = gameService.playAtColumn(game.getGameId(), 0, Color.Yellow).getCoordinate();

        assertThat(game.getGrid()[coordinate.getX()][coordinate.getY()].getColor().name()).isEqualTo(Color.Yellow.name());

    }

    @Test
    public void should_change_game_state_to_WAITING_FOR_YELLOW_after_a_red_player_turn(){
        Game game  = gameService.newGame(new Player());

        gameService.playAtColumn(game.getGameId(), 7, Color.Red);

        assertThat(game.getState()).isEqualTo(State.WAITING_FOR_YELLOW);

    }

    @Test
    public void should_return_the_game_state(){
        Game game = gameService.newGame(new Player());

        assertThat(gameService.getGameState(game.getGameId())).isEqualTo(State.WAITING_FOR_OPPONENT);
    }

    @Test
    public void should_detect_a_winner_when_playAtAcolumn(){
        Game game  = gameService.newGame(new Player());

        game.getGrid()[14][7] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[14][8] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[14][9] = Coin.newCoin()
                .color(Color.Red)
                .build();

        game.getGrid()[14][10] = Coin.newCoin()
                .color(Color.Red)
                .build();

        GameResponse gameResponse = gameService.playAtColumn(game.getGameId(), 2, Color.Red);
        assertThat(gameResponse.isGameFinish()).isTrue();
    }
}