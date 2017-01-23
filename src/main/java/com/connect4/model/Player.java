package com.connect4.model;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Player {

    private String playerId;
    private Color color;
    private String name;

    public static final List<String> DEFAULT_PSEUDOS = Arrays.asList("Clark","Alfred","Bruce","Tony","Peter");

    public Player() {
        this.playerId = UUID.randomUUID().toString();
        this.color = Math.floor(Math.random()*10) % 2 == 0 ? Color.Red : Color.Yellow;
        this.name = DEFAULT_PSEUDOS.get((int) ((Math.random() * DEFAULT_PSEUDOS.size() )));
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
