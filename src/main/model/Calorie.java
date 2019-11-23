package model;

import exceptions.NegativeEntryException;

public class Calorie {

    public int netCalories = 0;


    // MODIFIES: this
    // EFFECT:   adds the calories of eaten food to the net calories taken today
    public void addCalories(int foodCalories) throws NegativeEntryException {
        if (foodCalories >= 0) {
            netCalories = foodCalories + netCalories;
        } else {
            throw new NegativeEntryException();
        }

    }

    // MODIFIES: this
    // EFFECT: decreases the calories burnt  from net calories
    public void burnCalories(int exerciseCalories) throws NegativeEntryException {
        if (exerciseCalories > 0) {
            this.netCalories = this.netCalories - exerciseCalories;

            if (netCalories < 0) {
                System.out.println("Eat some food!");
            }
        } else {
            throw new NegativeEntryException();
        }

    }

    //Effect: gets the netcalories consumed
    public int getNetCalories() {
        return netCalories;
    }
}

