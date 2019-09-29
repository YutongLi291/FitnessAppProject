package model;

public interface Tracker {

    void trackMeasure(double m);

    //Requires: there be a tracked value already
    double getMeasure();
}
