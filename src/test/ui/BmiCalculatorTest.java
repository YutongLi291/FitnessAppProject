package ui;

import model.BmiCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BmiCalculatorTest {

    BmiCalculator bc ;

    @BeforeEach
    public void setup(){
        bc = new BmiCalculator();
    }

    @Test
    public void underweightBmiTest(){
        bc.calculateValue(50, 1.8);
        assertEquals("underweight", bc.getWeightClassify());
    }


    @Test
    public void normalWeightBmiTest(){
        bc.calculateValue(70, 1.8);
        assertEquals("normal weight", bc.getWeightClassify());
    }

    @Test
    public void overweightBmiTest(){
        bc.calculateValue(100, 1.7);
        assertEquals("overweight", bc.getWeightClassify());
    }
}
