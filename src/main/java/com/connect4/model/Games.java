package com.connect4.model;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Games {
    private Map<String, Game> games;

    public Games() {
        this.games = new HashMap<>();
    }

    public Map<String, Game> getGames() {
        return games;
    }

    public void setGames(Map<String, Game> games) {
        this.games = games;
    }
}
