package ui;

import model.CalorieTrack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class CalorieTrackTest {

    CalorieTrack fc;

    @BeforeEach
    public void setup(){
        fc = new CalorieTrack();
    }

    @Test
    public void addPositiveCaloriesTest() {
        fc.addCalories(30);
        assertEquals(30, fc.netCalories);

    }

    public void addNegativeCaloriesTest() {

    }

    @Test
    public void burnCaloriesTest(){
        fc.burnCalories(50);
        assertEquals(-50, fc.netCalories);

    }


}