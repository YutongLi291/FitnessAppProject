package ui;

import model.CalorieTrack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class CalorieTrackTest {

    CalorieTrack fc;

    //TODO: add way more test cases
    //THINk OF MORE TEST CASES!!!!
    @BeforeEach
    public void setup(){
        fc = new CalorieTrack();
    }

    @Test
    public void addPositiveCaloriesTest() {

        fc.addCalories(30);
        assertEquals(30, fc.getCalories());

    }


    @Test
    public void burnCaloriesTest(){
        fc.burnCalories(50);
        assertEquals(-50, fc.getCalories());

    }

    @Test
    public void noActionsGetCaloriesTest(){
        assertEquals(0, fc.getCalories());
    }

    @Test
    public void addThenBurnCaloriesTest(){
        fc.addCalories(30);
        fc.burnCalories(10);
        assertEquals(20, fc.getCalories());
    }

    @Test
    public void burnThenAddCaloriesTest(){
        fc.burnCalories(50);
        fc.addCalories(20);

        assertEquals(-30, fc.getCalories());
    }

}