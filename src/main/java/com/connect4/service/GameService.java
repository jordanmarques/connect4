package com.connect4.service;

import com.connect4.model.Coin;
import com.connect4.model.Color;
import com.connect4.model.Game;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    public static Integer WINNING_SUIT = 4;

    public Boolean checkHorizontally(Game game, Color color) {
        Integer counter = 0;

        for(int i = 0; i < game.getGrid().length; i++){
            for(int j = 0; j < game.getGrid()[i].length; j++){
                Coin coin = game.getGrid()[i][j];
                if(coin != null && coin.getColor().name().equals(color.name())){
                    counter ++;
                    if(counter >= WINNING_SUIT){
                        return true;
                    }
                }else{
                    counter = 0;
                }
            }

        }

        return false;
    }

    public Boolean checkVertically(Game game, Color color) {
        Integer counter = 0;

        for(int i = 0; i < game.getGrid().length; i++){
            for(int j = 0; j < game.getGrid()[i].length; j++){
                Coin coin = game.getGrid()[j][i];
                if(coin != null && coin.getColor().name().equals(color.name())){
                    counter ++;
                    if(counter >= WINNING_SUIT){
                        return true;
                    }
                }else{
                    counter = 0;
                }
            }

        }

        return false;
    }

    public Boolean checkRightTransversal(Game game, Color color){

        for(int i = 0; i < game.getGrid().length; i++){
            for(int j = 0; j < game.getGrid()[i].length; j++){
                Coin coin = game.getGrid()[i][j];
                if(coin != null && coin.getColor().name().equals(color.name())){
                    Integer rightTop = checkRightTop(game.getGrid(), color, i ,j);
                    Integer bottomLeft = checkLeftBottom(game.getGrid(),color, i ,j);
                    if(rightTop + bottomLeft + 1 >= WINNING_SUIT){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Boolean checkLeftTransversal(Game game, Color color) {
        for(int i = 0; i < game.getGrid().length; i++){
            for(int j = 0; j < game.getGrid()[i].length; j++){
                Coin coin = game.getGrid()[i][j];
                if(coin != null && coin.getColor().name().equals(color.name())){
                    Integer leftTop = checkLeftTop(game.getGrid(), color, i ,j);
                    Integer rightBottom = checkRightBottom(game.getGrid(),color, i ,j);
                    if(leftTop + rightBottom + 1 >= WINNING_SUIT){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private Integer checkRightTop(Coin[][] grid, Color color, int i, int j) {
        Integer counter = 0;
        i++;
        j--;

        while(grid[i][j] != null && areIndexesInBound(i, j) && color.name().equals(grid[i][j].getColor().name())){
            counter++;
            i++;
            j--;
        }

        return counter;
    }

    private Integer checkLeftBottom(Coin[][] grid, Color color, int i, int j) {
        Integer counter = 0;
        i--;
        j++;

        while(grid[i][j] != null && areIndexesInBound(i, j) && color.name().equals(grid[i][j].getColor().name())){
            counter++;
            i--;
            j++;
        }

        return counter;
    }

    private Integer checkLeftTop(Coin[][] grid, Color color, int i, int j) {
        Integer counter = 0;
        i--;
        j--;

        while(grid[i][j] != null && areIndexesInBound(i, j) && color.name().equals(grid[i][j].getColor().name())){
            counter++;
            i--;
            j--;
        }

        return counter;
    }

    private Integer checkRightBottom(Coin[][] grid, Color color, int i, int j) {
        Integer counter = 0;
        i++;
        j++;

        while(grid[i][j] != null && areIndexesInBound(i, j) && color.name().equals(grid[i][j].getColor().name())){
            counter++;
            i++;
            j++;
        }

        return counter;
    }

    private Boolean areIndexesInBound(int i, int j) {
        return i < Game.GRID_SIZE && i >= 0 && j < Game.GRID_SIZE && j >= 0;
    }
}
