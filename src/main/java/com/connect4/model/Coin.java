package com.connect4.model;

import groovy.transform.builder.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
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
