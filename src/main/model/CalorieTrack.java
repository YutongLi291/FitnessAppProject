package model;

public class CalorieTrack {

    public static int netCalories = 0;


    // REQUIRES: foodCalories to be a positive integer
    // MODIFIES: this
    // EFFECT:   adds the calories of eaten food to the net calories taken today
    public int addCalories(int foodCalories) {
        netCalories = foodCalories + netCalories;
        return netCalories;
    }

    // REQUIRES: exerciseCalories to be a positive integer
    // MODIFIES: this
    // EFFECT: decreases the calories burnt  from net calories
    public int burnCalories(int exerciseCalories) {

        netCalories = netCalories - exerciseCalories;

        if (netCalories < 0) {
            System.out.println("Eat some food!");
        }
        return netCalories;
    }
}

