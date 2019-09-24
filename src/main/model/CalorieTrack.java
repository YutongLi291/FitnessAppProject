package model;

public class CalorieTrack {

    public int netCalories = 0;


    // REQUIRES: foodCalories to be a positive integer
    // MODIFIES: this
    // EFFECT:   adds the calories of eaten food to the net calories taken today
    public void addCalories(int foodCalories) {
        if (foodCalories > 0) {
            netCalories = foodCalories + netCalories;
        } else {
            System.out.println("Please enter a positive number!");
        }

    }

    // REQUIRES: exerciseCalories to be a positive integer
    // MODIFIES: this
    // EFFECT: decreases the calories burnt  from net calories
    public void burnCalories(int exerciseCalories) {
        if (exerciseCalories > 0) {
            this.netCalories = this.netCalories - exerciseCalories;

            if (netCalories < 0) {
                System.out.println("Eat some food!");
            }
        } else {
            System.out.println("Please enter a positive number!");
        }

    }

    public int getCalories() {
        return netCalories;
    }
}
