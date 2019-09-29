package ui;

import model.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveFile {
    public static void main(String[] args) throws IOException {
        try {
            FileOutputStream saveFile = new FileOutputStream("saveFile.sav");
            ObjectOutputStream save = new ObjectOutputStream(saveFile);

            save.writeObject(BmiCalculator.bmi);
            save.writeObject(CalorieTrack.netCalories);
            save.writeObject(WeightTrack.weight);
            save.writeObject(HeightTrack.height);
            save.writeObject(DailyCalorieIntakeCalculator.recommendedIntake);
            save.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}




