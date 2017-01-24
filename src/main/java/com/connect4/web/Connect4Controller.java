package com.connect4.web;

import com.connect4.model.Color;
import com.connect4.model.Game;
import com.connect4.model.Player;
import com.connect4.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/connect4")
public class Connect4Controller {

   private GameService gameService;

   @Autowired
   public Connect4Controller(GameService gameService) {
      this.gameService = gameService;
   }

   @RequestMapping(path = "/game/new", method = RequestMethod.POST)
   public String newGame(@RequestParam("userName")String pseudo,
                         @RequestParam("userColor")String color){

      Player player = buildPlayer(pseudo, color);

      Game game = gameService.newGame(player);

      return game.getGameId();
   }

   @RequestMapping(path = "game/addPlayer", method = RequestMethod.PUT)
   public void addPlayerToGame(@RequestParam("userName")String pseudo,
                               @RequestParam("userColor")String color,
                               @RequestParam("gameId")String gameId){

      Player player = buildPlayer(pseudo, color);

      gameService.addPlayerToGame(player, gameId);

   }

   private Player buildPlayer(@RequestParam("userName") String pseudo,
                              @RequestParam("userColor") String color) {
      Player player = new Player();
      player.setName(pseudo);
      player.setColor(color.equalsIgnoreCase("red") ? Color.Red : Color.Yellow);
      return player;
   }

}
