package ui;

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
    public void normalHeightTrackTest(){
        ht.trackMeasure(1.8);
        assertEquals(1.8, ht.getMeasure());
        ht.trackMeasure(2.0);
        assertEquals(2.0, ht.getMeasure());

    }

    @Test
    public void noWeightEnteredGetWeight(){
        assertEquals( 0, ht.getMeasure());
    }
}
