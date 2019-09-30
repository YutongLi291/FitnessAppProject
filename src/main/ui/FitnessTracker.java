package ui;

import model.*;

import java.io.IOException;
import java.util.Scanner;



public class FitnessTracker {

    private static final String CONFIRM = "ok";
    private static final String TRACK = "track";
    private static final String QUIT_COMMAND = "quit";
    private static final String WEIGHT = "weight";
    private static final String HEIGHT = "height";
    private static final String CALCULATE_BMI = "bmi";
    private Scanner scanner;
    public String input;
    public static CalorieTrack ct = new CalorieTrack();
    public static WeightTrack wt = new WeightTrack();
    public static BmiCalculator bc = new BmiCalculator();
    public static HeightTrack ht = new HeightTrack();
    public static DailyCalorieIntakeCalculator dcic = new DailyCalorieIntakeCalculator();

    public static void main(String[] args) throws IOException {

        FitnessTracker ft = new FitnessTracker();
        LoadFile.main(new String[] {"main"});

        ft.welcome();
        ft.enterCommands();
    }

    public void welcome() {

        System.out.println("Welcome to Fitness Planner!");
        System.out.println("You can do the following things:");

        System.out.println("You can enter 'track' to record your meal or exercise");
        System.out.println("You can enter 'weight' to record or get your weight");
        System.out.println("You can enter 'height' to record or get your height");
        System.out.println("You can enter 'bmi' to calculate your bmi");
        System.out.println("Enter 'help' at any time to show this menu again");
        System.out.println("You can enter 'quit' to quit this application");
    }
    //MODIFIES: this, CalorieTrack, WeightTrack
    //EFFECT: prompts the user to enter commands and directs the user to the right menu
    //mostly referenced from SimpleCalculatorStarterLecture code

    private void enterCommands() throws IOException {
        scanner = new Scanner(System.in);

        while (true) {
            input = scanner.nextLine();
            if (input.equals(QUIT_COMMAND)) {
                SaveFile.main(new String[]{"main"});
                break;
            } else if (input.equals("help")) {
                welcome();
            } else if (input.equals(TRACK)) {
                trackMealOrExercise(ct);
            } else if (input.equals(WEIGHT)) {
                trackOrGetWeight(wt);
            } else if (input.equals(CALCULATE_BMI)) {
                calculateBmi(bc);
            } else if (input.equals(HEIGHT)) {
                trackOrGetHeight(ht);

            }
        }
    }

    private void trackMealOrExercise(CalorieTrack ct) {
        System.out.println("Enter 'trackmeal' to track your meal or 'trackexercise' to track your exercise");
        input = scanner.nextLine();
        if (input.equals("trackmeal")) {
            trackMeal(ct);
        } else if (input.equals("trackexercise")) {
            trackExercise(ct);
        }
    }

    private void calculateBmi(BmiCalculator bc) {
        double weight;
        double height;
        System.out.println("Please enter your weight in kg");
        weight = scanner.nextDouble();
        System.out.println("Please enter your height in meters");
        height = scanner.nextDouble();
        bc.calculateValue(weight, height);
    }




    private void trackOrGetHeight(HeightTrack ht) {
        double height;
        System.out.println("You can type 'get' "
                + "to get your height if you tracked your height before, otherwise, type 'track'");
        input = scanner.nextLine();
        if (input.equals("get")) {
            System.out.println("Your previously recorded height is " + ht.getMeasure() + "m");
        } else if (input.equals("track")) {
            System.out.println("Please enter your height in m");
            height = scanner.nextDouble();
            ht.trackMeasure(height);
            System.out.println("Your height of " + ht.getMeasure() + "m has been tracked");
        }
    }

    private void trackOrGetWeight(WeightTrack wt) {
        double weight;
        System.out.println("You can type 'get' "
                + "to get your weight if you tracked your weight before, otherwise, type 'track'");
        input = scanner.nextLine();
        if (input.equals("get")) {
            System.out.println("Your previously recorded weight is " + wt.getMeasure() + "kg");
        } else if (input.equals("track")) {
            System.out.println("Please enter your weight in kg");
            weight = scanner.nextDouble();
            wt.trackMeasure(weight);
            System.out.println("Your weight of " + wt.getMeasure() + "kg has been tracked");
        }
    }



    private void trackExercise(CalorieTrack ct) {
        int calories;
        System.out.println("Please enter the amount of calories you burnt");
        calories = scanner.nextInt();
        ct.burnCalories(calories);
        System.out.println("Your net calories today is " + ct.getCalories());
    }

    private void trackMeal(CalorieTrack ct) {
        int calories;
        System.out.println("Please enter the calorie amount of your meal");
        calories = scanner.nextInt();
        ct.addCalories(calories);
        System.out.println("Your net calories today is " + ct.getCalories());
    }

}



