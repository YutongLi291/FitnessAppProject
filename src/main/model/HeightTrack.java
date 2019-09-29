package model;

public class HeightTrack implements Tracker {


    public static double height;
    //Requires: height be a double in metres
    //Modifies: this
    //Effects: puts entered height into height variable

    @Override
    public void trackMeasure(double h) {
        this.height = h;
    }

    @Override
    public double getMeasure() {
        return height;
    }
}
