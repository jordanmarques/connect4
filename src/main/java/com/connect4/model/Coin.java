package com.connect4.model;

public class Coin {
    private Color color;

    public Coin() {
    }

    private Coin(Builder builder) {
        this.color = builder.color;
    }

    public static Builder newCoin() {
        return new Builder();
    }

    public Color getColor() {
        return color;
    }

    public static final class Builder {
        private Color color;

        private Builder() {
        }

        public Coin build() {
            return new Coin(this);
        }

        public Builder color(Color color) {
            this.color = color;
            return this;
        }
    }
}
