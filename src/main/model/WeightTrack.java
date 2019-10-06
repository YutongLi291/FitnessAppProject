package model;

public class WeightTrack extends Tracker {


    @Override
    public void printMeasure() {
        System.out.println("Your weight recorded is now" + getMeasure() + "kgs");
    }
}


