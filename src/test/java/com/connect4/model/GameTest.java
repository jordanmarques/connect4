package com.connect4.model;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class GameTest {


   @Test
   public void should_init_a_game(){
      Game game = new Game();

      assertThat(game.getGrid().length).isEqualTo(Game.GRID_SIZE);
      assertThat(game.getGrid()[0].length).isEqualTo(Game.GRID_SIZE);
      assertThat(game.getGameId()).isNotEmpty();
   }
}