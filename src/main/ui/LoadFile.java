package ui;

import model.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadFile {

    public static void main(String[] args) {
        try {
            FileInputStream saveFile = new FileInputStream("saveFile.sav");
            ObjectInputStream restore  = new ObjectInputStream(saveFile);
            BmiCalculator.bmi = (double) restore.readObject();
            CalorieTrack.netCalories = (int) restore.readObject();
            WeightTrack.weight = (double) restore.readObject();
            HeightTrack.height = (double) restore.readObject();
            DailyCalorieIntakeCalculator.recommendedIntake = (double) restore.readObject();

            restore.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
