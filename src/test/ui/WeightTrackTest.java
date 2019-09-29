package ui;

import model.WeightTrack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeightTrackTest {


    WeightTrack wt;


    @BeforeEach
    public void setup() {
         wt = new WeightTrack();
    }



    @Test
    public void normalWeightTrackTest(){
        wt.trackMeasure(50);
        assertEquals(50, wt.getMeasure());
        wt.trackMeasure(60);
        assertEquals(60, wt.getMeasure());

    }

    @Test
    public void noWeightEnteredGetWeight(){
        assertEquals( 0, wt.getMeasure());
    }
}
