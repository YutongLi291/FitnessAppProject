package model;

public class FoodCalories {



    // adds the calories of eaten food to the net calories taken today
    public int addCalories(int foodCalories) {

        this.netCalories = foodCalories + this.netCalories;
    }

}
