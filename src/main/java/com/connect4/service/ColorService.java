package com.connect4.service;

import com.connect4.model.Color;
import org.springframework.stereotype.Service;

@Service
public class ColorService {

   public Color swith(Color color){
      return color.equals(Color.Red) ? Color.Yellow : Color.Red;
   }

   public static Color get(String color){
      return color.equalsIgnoreCase("red") ? Color.Red : Color.Yellow;
   }
}
