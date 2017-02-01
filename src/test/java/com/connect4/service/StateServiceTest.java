package com.connect4.service;

import com.connect4.model.Color;
import com.connect4.model.State;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class StateServiceTest {

   private StateService stateService = new StateService();

   @Test
   public void should_return_WAITING_FOR_YELLOW_after_a_red_player_turn(){
      assertThat(stateService.getGameStateAfterAPlayerColorTurn(Color.Red)).isEqualTo(State.WAITING_FOR_YELLOW);
   }

   @Test
   public void should_return_WAITING_FOR_YELLOW_when_its_a_YELLOW_player_turn(){
      assertThat(stateService.getStateForAcolor(Color.Yellow)).isEqualTo(State.WAITING_FOR_YELLOW);
   }
}