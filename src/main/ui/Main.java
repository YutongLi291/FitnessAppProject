package ui;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final String CONFIRM = "ok";
    private static final String TRACK_MEAL = "trackmeal";
    private static final String QUIT_COMMAND = "quit";
    private Scanner scanner;

    public  void main(String[] args) {
        Main m = new Main();
        m.welcome();
        enterCommands();
    }
    private void enterCommands() {
        String input;
        scanner = new Scanner(System.in);

        while (true) {
            input = scanner.nextLine();
            if (input == QUIT_COMMAND) {
                break;
            }
        }
    }


    public void welcome() {

        System.out.println("Welcome to Fitness Planner!");
        System.out.println("You can do the following things:");
        System.out.println("You can enter 'trackmeal' to record your meal");

    }
}



