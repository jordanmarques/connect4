package com.connect4.dto;

import com.connect4.model.Coordinate;
import com.connect4.model.State;

public class GameResponse {
   private State state;
   private Coordinate coordinate;
   private Boolean isgameFinish;

   public State getState() {
      return state;
   }

   public void setState(State state) {
      this.state = state;
   }

   public Coordinate getCoordinate() {
      return coordinate;
   }

   public void setCoordinate(Coordinate coordinate) {
      this.coordinate = coordinate;
   }

   public Boolean isGameFinish() {
      return isgameFinish;
   }

   public void setIsgameFinish(Boolean isgameFinish) {
      this.isgameFinish = isgameFinish;
   }

   public static final class GameResponseBuilder {
      private State state;
      private Coordinate coordinate;
      private Boolean gameFinish;

      private GameResponseBuilder() {
      }

      public static GameResponseBuilder aGameResponse() {
         return new GameResponseBuilder();
      }

      public GameResponseBuilder state(State state) {
         this.state = state;
         return this;
      }

      public GameResponseBuilder coordinate(Coordinate coordinate) {
         this.coordinate = coordinate;
         return this;
      }

      public GameResponseBuilder isGameFinish(Boolean gameFinish) {
         this.gameFinish = gameFinish;
         return this;
      }

      public GameResponse build() {
         GameResponse gameResponse = new GameResponse();
         gameResponse.state = this.state;
         gameResponse.coordinate = this.coordinate;
         gameResponse.isgameFinish = this.gameFinish;
         return gameResponse;
      }
   }
}
