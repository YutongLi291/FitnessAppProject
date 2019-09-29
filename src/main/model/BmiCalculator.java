package model;

public class BmiCalculator {


    public static double bmi;


    //REQUIRES: weight be in kgs, height be in cms
    //EFFECT: tracks BMI from given weight and height, and gives feedback
    public void calculateBMI(double w, double h) {
        bmi = (w / (h * h));
        if (bmi < 18.5) {
            System.out.println("Your bmi is " + bmi + ", you are considered underweight");
        } else if (bmi >= 25) {
            System.out.println("Your bmi is " + bmi + ", you are considered overweight");
        } else {
            System.out.println("Your bmi is " + bmi + ", you are considered normal weight");
        }
    }
}