package model;

public class FoodCalories {

    public int netCalories = 0;


    // adds the calories of eaten food to the net calories taken today
    public int addCalories(String foodCalories) {
        int foodCaloriesInt = Integer.parseInt(foodCalories);
        netCalories = foodCaloriesInt + netCalories;
        return netCalories;
    }
}
