package model;

public class FoodCalories {



    // adds the calories of eaten food to the net calories taken today
    public int addCalories(int foodCalories, int netCalories) {

        netCalories = foodCalories + netCalories;
        return netCalories;
    }

}
