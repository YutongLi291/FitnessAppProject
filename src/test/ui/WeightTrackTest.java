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
        wt.weightTrack(50);
        assertEquals(50, wt.getWeight());
        wt.weightTrack(60);
        assertEquals(60, wt.getWeight());

    }

    @Test
    public void noWeightEnteredGetWeight(){
        assertEquals( 0, wt.getWeight());
    }
}
//balloon given size， bigger and bigger， expansion， reach certain point, it pops, no interaction when anything happens, everything is ontick