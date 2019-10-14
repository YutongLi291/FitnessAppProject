package ui;

import exceptions.ImpossibleMeasureException;
import exceptions.NegativeEntryException;
import model.*;

import java.io.IOException;
import java.util.Scanner;


public class FitnessTracker {

    private static final String CONFIRM = "ok";
    private static final String TRACK = "t";
    private static final String QUIT_COMMAND = "quit";
    private static final String WEIGHT = "w";
    private static final String HEIGHT = "h";
    private static final String CALCULATE_BMI = "bmi";
    private Scanner scanner;
    public String input;
    public static Calorie ct = new Calorie();
    public static WeightTrack wt = new WeightTrack();
    public static Calculator bc = new BmiCalculator();
    public static Calculator dcic = new DailyCalorieIntakeCalculator();
    public static HeightTrack ht = new HeightTrack();


    public static void main(String[] args) throws IOException {

        FitnessTracker ft = new FitnessTracker();
        LoadFile.main(new String[]{"main"});

        ft.welcome();
        ft.enterCommands();
    }

    public void welcome() {

        System.out.println("Welcome to Fitness Planner!");
        System.out.println("You can do the following things:");

        System.out.println("You can enter 't' to record your meal, exercise, height, or weight");
        System.out.println("You can enter 'bmi' to calculate your bmi");
        System.out.println("Enter 'help' at any time to show this menu again");
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
                SaveFile.main(new String[]{"main"});
                break;
            } else if (input.equals("help")) {
                welcome();
            } else if (input.equals(TRACK)) {
                trackAnything();
            } else if (input.equals(CALCULATE_BMI)) {
                calculatorFunction(bc);
            }

        }
    }


    public void trackAnything() {
        System.out.println("Enter m to track meal, e to track exercise, h to track height, w to track weight");
        input = scanner.nextLine();
        try {
            if (input.equals("m")) {
                trackMeal(ct);
            } else if (input.equals("e")) {
                trackExercise(ct);
            } else if (input.equals("h")) {
                trackOrGetHeight(ht);
            } else if (input.equals("w")) {
                trackOrGetWeight(wt);
            }
        } catch (NegativeEntryException e) {
            System.out.println("Please enter positive numbers!");
        }
    }
//    private void trackMealOrExercise(Calorie ct) {
//        System.out.println("Enter 'trackmeal' to track your meal or 'trackexercise' to track your exercise");
//        input = scanner.nextLine();
//        if (input.equals("trackmeal")) {
//            trackMeal(ct);
//        } else if (input.equals("trackexercise")) {
//            trackExercise(ct);
//        }
//    }

    private void calculatorFunction(Calculator calculator) {
        double weight;
        double height;
        System.out.println("Please enter your weight in kg");
        weight = scanner.nextDouble();
        System.out.println("Please enter your height in meters");
        height = scanner.nextDouble();
        try {
            calculator.calculateValue(weight, height);
        } catch (NegativeEntryException e) {
            System.out.println("Please enter a positive number!");
        } catch (ImpossibleMeasureException e) {
            System.out.println("Those numbers are impossible!");
        }

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
            try {
                ht.trackMeasure(height);
            } catch (NegativeEntryException e) {
                System.out.println("Please enter a positive number!");
            }
            ht.printMeasure();
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
            try {
                wt.trackMeasure(weight);
            } catch (NegativeEntryException e) {
                System.out.println("Please enter a positive number!");
            }
            wt.printMeasure();
        }
    }


    private void trackExercise(Calorie ct) throws NegativeEntryException {
        int calories;
        System.out.println("Please enter the amount of calories you burnt");
        calories = scanner.nextInt();
        ct.burnCalories(calories);

        System.out.println("Your net calories today is " + ct.getCalories());
    }

    private void trackMeal(Calorie ct) throws NegativeEntryException {
        int calories;
        System.out.println("Please enter the calorie amount of your meal");
        calories = scanner.nextInt();

        ct.addCalories(calories);

        System.out.println("Your net calories today is " + ct.getCalories());
    }
}




