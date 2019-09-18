package ui;

import model.CalorieTrack;
import model.WeightTrack;

import java.util.Scanner;

public class FitnessTracker {

    private static final String CONFIRM = "ok";
    private static final String TRACK_MEAL = "trackmeal";
    private static final String TRACK_EXERCISE = "trackexercise";
    private static final String QUIT_COMMAND = "quit";
    private Scanner scanner;

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

        System.out.println("You can enter 'quit' to quit this application");
    }
    //MODIFIES: this, CalorieTrack, WeightTrack
    //EFFECT: prompts the user to enter commands and directs the user to the right menu
    //mostly referenced from SimpleCalculatorStarterLecture code

    private void enterCommands() {
        String input;
        int calories;
        scanner = new Scanner(System.in);
        CalorieTrack f = new CalorieTrack();
        WeightTrack w = new WeightTrack();

        while (true) {
            input = scanner.nextLine();
            if (input.equals(QUIT_COMMAND)) {
                break;
            } else if (input.equals(TRACK_MEAL)) {
                trackMeal(f);
            } else if (input.equals(TRACK_EXERCISE)) {
                trackExercise(f);

            }
        }
    }

    private void trackExercise(CalorieTrack f) {
        int calories;
        System.out.println("Please enter the amount of calories you burnt");
        calories = scanner.nextInt();
        f.burnCalories(calories);
        System.out.println("Your net calories today is " + f.netCalories);
    }

    private void trackMeal(CalorieTrack f) {
        int calories;
        System.out.println("Please enter the calorie amount of your meal");
        calories = scanner.nextInt();
        f.addCalories(calories);
        System.out.println("Your net calories today is " + f.netCalories);
    }
}



