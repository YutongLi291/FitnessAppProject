package model;

import network.FoodCalorieInformation;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class FoodCalories {
    FoodCalorieInformation fci;

    //REQUIRES: search string be valid food
    //Effects: looks up calories of given string
    public void lookupCalories(String search) {
        fci = new FoodCalorieInformation(search);
        try {
            fci.searchFoodThenGetCalories();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }



}
