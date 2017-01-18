package com.connect4.model;

public class Coordinate {

    private Integer x;
    private Integer y;

    private Coordinate(Builder builder) {
        this.x = builder.x;
        this.y = builder.y;
    }

    public static Builder newCoordinate() {
        return new Builder();
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public static final class Builder {
        private Integer x;
        private Integer y;

        public Coordinate build() {
            return new Coordinate(this);
        }

        public Builder x(Integer x) {
            this.x = x;
            return this;
        }

        public Builder y(Integer y) {
            this.y = y;
            return this;
        }
    }
}
