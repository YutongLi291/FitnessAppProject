package model;

import exceptions.NegativeEntryException;
import model.HeightTrack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeightTrackTest {

    HeightTrack ht;


    @BeforeEach
    public void setup() {
        ht = new HeightTrack();
    }


    @Test
    public void normalHeightTrackTest() {
        try {
            ht.trackMeasure(1.8);
        } catch (NegativeEntryException e) {
            System.out.println("Please enter a positive number!");
        }
        assertEquals(1.8, ht.getMeasure());
        try {
            ht.trackMeasure(2.0);
        } catch (NegativeEntryException e) {
            System.out.println("Please enter a positive number!");
        }
        assertEquals(2.0, ht.getMeasure());

    }

    @Test
    public void noWeightEnteredGetWeight() {
        assertEquals(0, ht.getMeasure());
    }
}
