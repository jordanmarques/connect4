package com.connect4.model;

import org.junit.Test;

import java.util.Arrays;

import static org.fest.assertions.Assertions.assertThat;

public class PlayerTest {

   @Test
   public void should_init_a_player(){
      Player player = new Player();

      assertThat(player.getColor()).isIn(Arrays.asList(Color.Red, Color.Yellow));
      assertThat(player.getName()).isNotNull();
   }
}