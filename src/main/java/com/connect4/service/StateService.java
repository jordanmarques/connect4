package com.connect4.service;

import com.connect4.model.Color;
import com.connect4.model.State;
import org.springframework.stereotype.Service;

@Service
public class StateService {

   public State getGameStateAfterAPlayerColorTurn(Color color){
      return color.equals(Color.Red) ? State.WAITING_FOR_YELLOW : State.WAITING_FOR_RED;
   }

   public State getStateForAcolor(Color color){
      return color.equals(Color.Red) ? State.WAITING_FOR_RED : State.WAITING_FOR_YELLOW;
   }
}
