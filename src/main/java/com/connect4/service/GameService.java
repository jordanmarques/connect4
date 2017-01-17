package com.connect4.service;

import com.connect4.model.Coin;
import com.connect4.model.Color;
import com.connect4.model.Game;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class GameService {

    public static Integer WINNING_SUIT = 4;


    public Boolean checkVerticallyForAGivenColor(Game game, Color color) {

        return Arrays.stream(game.getGrid())
                .map(coins -> countVerticallyColorSuit(coins, color))
                .filter(suit -> suit >= WINNING_SUIT)
                .findFirst()
                .isPresent();
    }

    public Integer countVerticallyColorSuit(Coin[] coins, Color color){
        Integer suitCounter = 0;

        for(Coin coin : coins) {
            if(coin != null){
                if( coin.getColor().name().equals(color.name()) ){
                    suitCounter ++;
                }else{
                    suitCounter = 0;
                }
            }
        }
        return suitCounter;
    }

}
