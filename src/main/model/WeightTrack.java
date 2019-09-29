package model;

public class WeightTrack implements Tracker {

    public static double weight;


    //REQUIRES: weight be in kgs
    //MODIFIES: this
    //EFFECTS:  sets the weight integer to the entered weight

    @Override
    public void trackMeasure(double w) {
        this.weight = w;
    }


    //EFFECTS: returns the set weight
    @Override
    public double getMeasure() {
        return weight;
    }
}


