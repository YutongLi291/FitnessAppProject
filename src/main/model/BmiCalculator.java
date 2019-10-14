package model;

import exceptions.ImpossibleMeasureException;
import exceptions.NegativeEntryException;

public class BmiCalculator implements Calculator {


    public double bmi;
    public String weightClassify;
    private static final String UNDERWEIGHT = "underweight";
    private static final String OVERWEIGHT = "overweight";
    private static final String NORMAL_WEIGHT = "normal weight";
    //REQUIRES: weight be in kgs, height be in cms
    //EFFECT: tracks BMI from given weight and height, and gives feedback

    @Override
    //Requires: weight and height be doubles in kg and m respectively
    //Modifies: this
    //Effects: calculates bmi and then prints out message regarding bmi
    public void calculateValue(double w, double h) throws NegativeEntryException, ImpossibleMeasureException {
        if (w < 0 || h < 0) {
            throw new NegativeEntryException();
        } else if (w < 15 || w > 500 || h < 0.8 || h > 2.5) {
            throw new ImpossibleMeasureException();
        }
        bmi = (w / (h * h));
        if (bmi < 18.5) {
            weightClassify = UNDERWEIGHT;
        } else if (bmi >= 25) {
            weightClassify = OVERWEIGHT;
        } else {
            weightClassify = NORMAL_WEIGHT;
        }
        System.out.println("Your bmi is " + bmi + ", you are considered " + weightClassify);
    }

    @Override
    //Effects: lets the user enter their own bmi if they know it
    public void trackMeasure(double bmi) {
        this.bmi = bmi;
    }

    @Override
    //Effects: returns the tracked bmi
    public double getMeasure() {
        return bmi;
    }

    //Effects: returns the weight classification
    public String getWeightClassify() {
        return weightClassify;
    }
}