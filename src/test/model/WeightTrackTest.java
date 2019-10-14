package model;

import exceptions.NegativeEntryException;
import model.WeightTrack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class WeightTrackTest {


    WeightTrack wt;


    @BeforeEach
    public void setup() {
        wt = new WeightTrack();
    }


    @Test
    public void normalWeightTrackTest() {
        try {
            wt.trackMeasure(50);
        } catch (NegativeEntryException e) {
            fail();
        }
        assertEquals(50, wt.getMeasure());
        try {
            wt.trackMeasure(60);
        } catch (NegativeEntryException e) {
            fail();
        }
        assertEquals(60, wt.getMeasure());

    }

    @Test
    public void noWeightEnteredGetWeight() {
        assertEquals(0, wt.getMeasure());
    }

    @Test
    public void negativeEnteredTest() {

        try {
            wt.trackMeasure(-10);

        } catch (NegativeEntryException e) {
            System.out.println("Please enter a positive number!");
        }
        assertEquals(0, wt.getMeasure());


    }
}
