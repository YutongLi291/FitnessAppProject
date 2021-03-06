package model;

import exceptions.ImpossibleMeasureException;
import exceptions.NegativeEntryException;

public interface Calculator {


    void trackMeasure(double b);

    double getMeasure();

    void calculateValue(double a, double b) throws NegativeEntryException, ImpossibleMeasureException;
}
