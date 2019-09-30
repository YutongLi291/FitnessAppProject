package ui;

import model.DailyCalorieIntakeCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DailyCalorieIntakeCalculatorTest {

   DailyCalorieIntakeCalculator dcic;


   @BeforeEach
   public void setup(){
       dcic = new DailyCalorieIntakeCalculator();
   }
    @Test
   public void calorieIntakeCalculatorTest(){
       dcic.calculateValue(70, 1.80);
        assertEquals(1825, dcic.getMeasure());
    }
}
