package com.connect4.service;

import com.connect4.model.Color;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ColorServiceTest {

   private ColorService colorService = new ColorService();

   @Test
   public void should_return_the_opposite_color(){
      assertThat(colorService.swith(Color.Red)).isEqualTo(Color.Yellow);
   }

   @Test
   public void should_return_color_for_a_string(){
      assertThat(ColorService.get("red")).isEqualTo(Color.Red);
   }

}