package model;

public class WeightTrack implements Tracker {

    public double weight;



    @Override
    //REQUIRES: weight be in kgs
    //MODIFIES: this
    //EFFECTS:  sets the weight integer to the entered weight

    public void trackMeasure(double w) {
        this.weight = w;
    }



    @Override
    //EFFECTS: returns the set weight
    public double getMeasure() {
        return weight;
    }
}


