package model;

public class WeightTrack {

    public double weight;


    //REQUIRES: weight be in kgs
    //MODIFIES: this
    //EFFECTS:  sets the weight integer to the entered weight
    public void weightTrack(double w) {
        this.weight = w;
    }


    //EFFECTS: returns the set weight
    public double getWeight() {
        return weight;
    }
}

