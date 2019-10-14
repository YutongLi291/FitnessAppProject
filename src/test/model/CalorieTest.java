package model;

import exceptions.ImpossibleMeasureException;
import model.Calorie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class CalorieTest {

    Calorie fc;

    //TODO: add way more test cases
    //THINk OF MORE TEST CASES!!!!
    @BeforeEach
    public void setup() {
        fc = new Calorie();
    }

    @Test
    public void addPositiveCaloriesTest() {

        try {
            fc.addCalories(30);
            assertEquals(30, fc.getCalories());
        } catch (ImpossibleMeasureException e) {
            fail();
        }


    }


    @Test
    public void burnCaloriesTest() {
        try {
            fc.burnCalories(50);
            assertEquals(-50, fc.getCalories());
        } catch (ImpossibleMeasureException e) {
            fail();
        }


    }

    @Test
    public void noActionsGetCaloriesTest() {
        assertEquals(0, fc.getCalories());
    }

    @Test
    public void addThenBurnCaloriesTest() {
        try {
            fc.addCalories(30);
            fc.burnCalories(10);
            assertEquals(20, fc.getCalories());
        } catch (ImpossibleMeasureException e) {
            fail();
        }

    }

    @Test
    public void burnThenAddCaloriesTest() {
        try {
            fc.burnCalories(50);
            fc.addCalories(20);

            assertEquals(-30, fc.getCalories());
        } catch (ImpossibleMeasureException e) {
            fail();
        }

    }

    @Test
    public void addNegativeCalories() {
        try {
            fc.addCalories(-50);
            assertEquals(0, fc.getCalories());
        } catch (ImpossibleMeasureException e) {
        }

    }

    public void burnNegativeCalories() {
        try {
            fc.burnCalories(-60);
            assertEquals(0, fc.getCalories());
        } catch (ImpossibleMeasureException e) {
        }
    }

}