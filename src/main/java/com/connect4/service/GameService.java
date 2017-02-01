package com.connect4.service;

import com.connect4.dto.GameResponse;
import com.connect4.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.connect4.dto.GameResponse.*;

@Service
public class GameService {

    private Games games;
    private StateService stateService;
    private GridCheckerService gridCheckerService;

    @Autowired
    public GameService(Games games, StateService stateService, GridCheckerService gridCheckerService) {
        this.games = games;
        this.stateService = stateService;
        this.gridCheckerService = gridCheckerService;
    }

    public GameResponse playAtColumn(String gameId, int columnNumber, Color color){

        Game game = games.getGames().get(gameId);

        if( hasGameAWinner(game, color)){
            game.setState(State.WINNER_FOUND);
            return GameResponseBuilder.aGameResponse().coordinate(game.getLastCoordinate()).isGameFinish(true).state(game.getState()).build();
        }

        Coordinate coordinate = getEmptyPositionAtColumn(game, columnNumber);

        game.getGrid()[coordinate.getX()][coordinate.getY()] = Coin.newCoin().
                color(color).
                build();
        game.setLastCoordinate(coordinate);
        game.setState(stateService.getGameStateAfterAPlayerColorTurn(color));

        if( hasGameAWinner(game, color)){
            game.setState(State.WINNER_FOUND);
            return GameResponseBuilder.aGameResponse().coordinate(game.getLastCoordinate()).isGameFinish(true).state(game.getState()).build();
        }

        return GameResponseBuilder.aGameResponse()
                .coordinate(coordinate)
                .isGameFinish(false)
                .state(game.getState()).build();
    }

    public Game newGame(Player player){

        ArrayList<Player> players = new ArrayList<>();
        players.add(player);

        Game game = new Game();
        game.setPlayers(players);
        game.setState(State.WAITING_FOR_OPPONENT);

        games.getGames().put(game.getGameId(), game);

        return games.getGames().get(game.getGameId());
    }

    public void addPlayerToGame(Player player, String gameId){
        Game game = games.getGames().get(gameId);

        if(game.getPlayers().size() >= 2){
            throw new RuntimeException("Cannot add another player : Game have already 2 player.");
        }

        game.setState(Math.floor(Math.random()*10) % 2 == 0 ? State.WAITING_FOR_YELLOW : State.WAITING_FOR_RED);

        game.getPlayers().add(player);
    }

    public boolean hasGameAWinner(Game game, Color color){
        return gridCheckerService.checkHorizontally(game, color) ||
                gridCheckerService.checkVertically(game, color) ||
                gridCheckerService.checkLeftTransversal(game, color) ||
                gridCheckerService.checkRightTransversal(game, color);
     }

    public State getGameState(String gameId){
        return games.getGames().get(gameId).getState();
    }

    public Coordinate getLastGameCoordinate(String gameId){
        return games.getGames().get(gameId).getLastCoordinate();
    }

    public Player getPlayer(String gameId){
        return games.getGames().get(gameId).getPlayers().get(0);
    }

    public Coordinate getEmptyPositionAtColumn(Game game, int columnNumber) {

        for(int i = game.getGrid().length - 1 ; i >= 0; i--){
            if(game.getGrid()[i][columnNumber] == null){
                return Coordinate.newCoordinate().x(i).y(columnNumber).build();
            }
        }

        throw new RuntimeException("Game Id: " + game.getGameId() + ". Grid is full at column: " + columnNumber);
    }



}
