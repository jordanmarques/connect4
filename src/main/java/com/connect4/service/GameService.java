package com.connect4.service;

import com.connect4.model.Coin;
import com.connect4.model.Color;
import com.connect4.model.Game;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class GameService {

    public static Integer WINNING_SUIT = 4;


    public Boolean checkHorizontallyForAGivenColor(Game game, Color color) {

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

    public boolean checkVerticallyForAGivenColor(Game game, Color color) {

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
}
