package model;

public class HeightTrack implements Tracker {


    public double height;


    @Override
    //Requires: height be a double in metres
    //Modifies: this
    //Effects: puts entered height into height variable
    public void trackMeasure(double h) {
        this.height = h;
    }

    @Override
    //Effects: returns  the set height
    public double getMeasure() {
        return height;
    }
}
