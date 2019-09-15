package ui;

import java.util.Scanner;

import model.FoodCalories;

public class FitnessTracker {

    private static final String CONFIRM = "ok";
    private static final String TRACK_MEAL = "trackmeal";
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
        System.out.println("You can enter 'quit' to quit this application");

    }

    //mostly referenced from SimpleCalculatorStarterLecture code
    private void enterCommands() {
        String input;
        String calories;
        scanner = new Scanner(System.in);
        FoodCalories f = new FoodCalories();

        while (true) {
            input = scanner.nextLine();
            if (input.equals(QUIT_COMMAND)) {
                break;
            } else if (input.equals(TRACK_MEAL)) {
                System.out.println("Please enter the calorie amount of your meal");
                calories = scanner.nextLine();
                f.addCalories(calories);
                System.out.println("Your net calories today is " + f.netCalories);
            }
        }
    }
}



