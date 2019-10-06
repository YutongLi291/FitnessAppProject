package model;

public abstract class Tracker {


    public  double measure;
    
    public void trackMeasure(double m) {
        this.measure = m;
    }

    //Requires: there be a tracked value already
    public double getMeasure() {
        return measure;
    }

    public abstract void printMeasure();
}
