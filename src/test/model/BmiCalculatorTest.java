package model;

import exceptions.ImpossibleMeasureException;
import exceptions.NegativeEntryException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class BmiCalculatorTest {

    BmiCalculator bc;

    @BeforeEach
    public void setup() {
        bc = new BmiCalculator();
    }

    @Test
    public void underweightBmiTest() throws ImpossibleMeasureException {
        try {
            bc.calculateValue(50, 1.8);
            assertEquals("underweight", bc.getWeightClassification());
        } catch (ImpossibleMeasureException e) {
            fail();
        }
    }


    @Test
    public void normalWeightBmiTest() throws ImpossibleMeasureException {
        try {
            bc.calculateValue(70, 1.8);
            assertEquals("normal weight", bc.getWeightClassification());
        } catch (ImpossibleMeasureException e) {
            fail();
        }
    }

    @Test
    public void overweightBmiTest() throws ImpossibleMeasureException {
        try {
            bc.calculateValue(100, 1.7);
            assertEquals("overweight", bc.getWeightClassification());
        } catch (ImpossibleMeasureException e) {
            fail();
        }
    }

    @Test
    public void negativeNumbersTest() throws NegativeEntryException {
        try {
            bc.calculateValue(-50, -1.5);

        } catch (NegativeEntryException e) {

        } catch (ImpossibleMeasureException e) {
            fail();
        }
    }

    @Test
    public void impossibleNumbersTest() throws ImpossibleMeasureException {
        try {
            bc.calculateValue(1000, 3);
        } catch (ImpossibleMeasureException e) {

        }
    }
}
