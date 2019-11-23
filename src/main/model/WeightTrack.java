package model;

public class WeightTrack extends Tracker {


    @Override
    //Effects: prints out weight
    public void printMeasure() {
        System.out.println("Your weight recorded is now" + getMeasure() + "kgs");
    }
}


