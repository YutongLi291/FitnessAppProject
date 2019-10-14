package model;

import exceptions.NegativeEntryException;

public abstract class Tracker {


    public double measure;

    //REQUIRES: entered input be a positive double
    //EFFECTS: tracks measure into the variable
    public void trackMeasure(double m) throws NegativeEntryException {
        if (m < 0) {
            throw new NegativeEntryException();
        } else {
            this.measure = m;
        }
    }

    //Requires: there be a tracked value already
    //EFFECTS: returns the recorded measure
    public double getMeasure() {
        return measure;
    }

    public abstract void printMeasure();
}
