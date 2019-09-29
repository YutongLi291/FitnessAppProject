package model;

public class DailyCalorieIntakeCalculator implements Calculator, Tracker {

    public static double recommendedIntake;

    @Override
    public void calculateValue(double w, double h) {
        recommendedIntake = (10 * w) + (6.25 * h);
        System.out.println("Your recommended daily calorie intake is " + recommendedIntake);

    }

    @Override
    public void trackMeasure(double m) {
        recommendedIntake = m;
    }

    @Override
    public double getMeasure() {
        return recommendedIntake;
    }
}
