package ui;

import model.BmiCalculator;
import model.CalorieTrack;
import model.WeightTrack;

import java.util.Scanner;



public class FitnessTracker {

    private static final String CONFIRM = "ok";
    private static final String TRACK_MEAL = "trackmeal";
    private static final String TRACK_EXERCISE = "trackexercise";
    private static final String QUIT_COMMAND = "quit";
    private static final String TRACK_WEIGHT = "trackweight";
    private static final String CALCULATE_BMI = "bmi";
    private Scanner scanner;
    public String input;
    public CalorieTrack ct = new CalorieTrack();
    public WeightTrack wt = new WeightTrack();
    public BmiCalculator bc = new BmiCalculator();

    public static void main(String[] args) {

        FitnessTracker ft = new FitnessTracker();
        ft.welcome();
        ft.enterCommands();
    }

    public void welcome() {

        System.out.println("Welcome to Fitness Planner!");
        System.out.println("You can do the following things:");

        System.out.println("You can enter 'trackmeal' to record your meal");
        System.out.println("You can enter 'trackexercise' to record your exercise");
        System.out.println("You can enter 'trackweight' to record your weight");
        System.out.println("You can enter 'bmi' to calculate your bmi");
        System.out.println("Enter help at any time to show this menu again");
        System.out.println("You can enter 'quit' to quit this application");
    }
    //MODIFIES: this, CalorieTrack, WeightTrack
    //EFFECT: prompts the user to enter commands and directs the user to the right menu
    //mostly referenced from SimpleCalculatorStarterLecture code

    private void enterCommands() {

        scanner = new Scanner(System.in);

        while (true) {
            input = scanner.nextLine();

            if (input.equals(QUIT_COMMAND)) {
                save();
                break;
            } else if (input.equals(TRACK_MEAL)) {
                trackMeal(ct);
            } else if (input.equals(TRACK_EXERCISE)) {
                trackExercise(ct);
            } else if (input.equals(TRACK_WEIGHT)) {
                trackWeight(wt);
            } else if (input.equals(CALCULATE_BMI)) {
                calculateBmi(bc);
            }
        }
    }

    private void calculateBmi(BmiCalculator bc) {
        double weight;
        double height;
        System.out.println("Please enter your weight in kg");
        weight = scanner.nextDouble();
        System.out.println("Please enter your height in meters");
        height = scanner.nextDouble();
        bc.calculateBMI(weight, height);
    }

    private void trackWeight(WeightTrack wt) {
        int weight;
        System.out.println("Please enter your weight in kg");
        weight = scanner.nextInt();
        wt.trackMeasure(weight);
        System.out.println("Your weight of " + wt.getMeasure() + "kg has been tracked");
    }

    private void trackExercise(CalorieTrack ct) {
        int calories;
        System.out.println("Please enter the amount of calories you burnt");
        calories = scanner.nextInt();
        ct.burnCalories(calories);
        System.out.println("Your net calories today is " + ct.getCalories());
    }

    private void trackMeal(CalorieTrack f) {
        int calories;
        System.out.println("Please enter the calorie amount of your meal");
        calories = scanner.nextInt();
        f.addCalories(calories);
        System.out.println("Your net calories today is " + f.getCalories());
    }

    private void save(){}
}



