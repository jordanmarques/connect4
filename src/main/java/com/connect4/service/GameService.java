package com.connect4.service;

import com.connect4.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GameService {

    private Games games;

    @Autowired
    public GameService(Games games) {
        this.games = games;
    }

    public Coordinate getEmptyPositionAtColumn(Game game, int columnNumber) {

        for(int i = game.getGrid().length - 1 ; i >= 0; i--){
            if(game.getGrid()[i][columnNumber] == null){
                return Coordinate.newCoordinate().x(i).y(columnNumber).build();
            }
        }

        throw new RuntimeException("Game Id: " + game.getGameId() + ". Grid is full at column: " + columnNumber);
    }

    public Coordinate playAtColumn(Game game, int columnNumber, Color color){

        Coordinate coordinate = getEmptyPositionAtColumn(game, columnNumber);

        game.getGrid()[coordinate.getX()][coordinate.getY()] = Coin.newCoin().
                color(color).
                build();

        return coordinate;
    }

    public Game newGame(Player player){

        ArrayList<Player> players = new ArrayList<>();
        players.add(player);

        Game game = new Game();
        game.setPlayers(players);

        games.getGames().put(game.getGameId(), game);

        return games.getGames().get(game.getGameId());
    }

    public void addPlayerToGame(Player player, String gameId){
        Game game = games.getGames().get(gameId);
        game.getPlayers().add(player);
    }

}
