package com.connect4.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Game {

    public static final int GRID_SIZE = 15;

    private String gameId;
    private Coin[][] grid;
    private State state;
    private List<Player> players;

    public Game() {
        this.gameId = UUID.randomUUID().toString();
        this.grid = new Coin[GRID_SIZE][GRID_SIZE];
        this.players = new ArrayList<>();
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Coin[][] getGrid() {
        return grid;
    }

    public String getGameId() {
        return gameId;
    }
}
