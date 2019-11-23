package model;

public class HeightTrack extends Tracker {


    @Override
    //Effects: prints out the height
    public void printMeasure() {
        System.out.println("Your height recorded is now" + getMeasure() + "metres");

    }
}
