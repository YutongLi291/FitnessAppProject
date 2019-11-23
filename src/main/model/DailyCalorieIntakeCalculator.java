package model;

public class DailyCalorieIntakeCalculator implements Calculator {

    public double recommendedIntake;

    @Override
    //Requires: w and h be doubles in kg and m respectively
    //Modifies: this
    //Effects: prints out recommended daily calorie intake given weight and height
    public void calculateValue(double w, double h) {
        recommendedIntake = (10 * w) + (625 * h);
        System.out.println("Your recommended daily calorie intake is " + recommendedIntake);

    }

    @Override
    //Modifies: this
    //Effects: sets the recommendedIntake
    public void trackMeasure(double m) {
        recommendedIntake = m;
    }

    @Override

    //Effects: returns the recommendedIntake
    public double getMeasure() {
        return recommendedIntake;
    }
}
