package com.connect4.web;

import com.connect4.dto.GameResponse;
import com.connect4.model.*;
import com.connect4.service.ColorService;
import com.connect4.service.GameService;
import com.connect4.service.StateService;
import com.jayway.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

import static com.connect4.dto.GameResponse.*;

@RestController
@RequestMapping("/connect4")
public class Connect4Controller {

   private GameService gameService;
   private StateService stateService;
   private ColorService colorService;

   @Autowired
   public Connect4Controller(GameService gameService, StateService stateService, ColorService colorService) {
      this.gameService = gameService;
      this.stateService = stateService;
      this.colorService = colorService;
   }

   @RequestMapping(path = "/game/new", method = RequestMethod.POST)
   public String newGame(@RequestParam("userName")String pseudo,
                         @RequestParam("userColor")String color){

      Player player = buildPlayer(pseudo, color);

      Game game = gameService.newGame(player);

      return game.getGameId();
   }

   @RequestMapping(path = "game/{id}/addPlayer", method = RequestMethod.PUT)
   public Player addPlayerToGame(@RequestParam("userName")String pseudo,
                               @PathVariable("id") String gameId){

      Player player = buildSecondPlayer(pseudo, gameId);

      gameService.addPlayerToGame(player, gameId);

      return player;
   }

   @RequestMapping(path="game/{id}/state", method = RequestMethod.GET)
   public State getGameState(@PathVariable("id")String id){
      return gameService.getGameState(id);
   }

   @RequestMapping(path="game/{id}/play", method = RequestMethod.PUT)
   public GameResponse playAtColumn(@RequestParam("columnNumber")String columnNumber,
                                    @RequestParam("playerColor")String playerColor,
                                    @PathVariable("id")String id){

      if(gameService.getGameState(id).equals(State.WINNER_FOUND)){
        return GameResponseBuilder.aGameResponse().isGameFinish(true).coordinate(gameService.getLastGameCoordinate(id)).state(State.WINNER_FOUND).build();
      } else if(isPlayerTurn(playerColor, id)){
         return gameService.playAtColumn(id, Integer.parseInt(columnNumber), ColorService.get(playerColor));
      }

      throw new RuntimeException("It's not " + playerColor + " turn.");
   }

   private boolean isPlayerTurn(String playerColor, String id) {
      return gameService.getGameState(id).equals(stateService.getStateForAcolor(ColorService.get(playerColor)));
   }

   private Player buildPlayer(String pseudo, String color) {
      Player player = new Player();
      player.setName(pseudo);
      player.setColor(color.equalsIgnoreCase("red") ? Color.Red : Color.Yellow);
      return player;
   }

   private Player buildSecondPlayer(String pseudo, String gameId){
      Player firstPlayer = gameService.getPlayer(gameId);

      return buildPlayer(pseudo, colorService.swith(firstPlayer.getColor()).name());
   }
}
