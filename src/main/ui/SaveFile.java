package ui;

import model.*;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SaveFile {


    public static void main(String[] args) {
        Calculator bc = FitnessTracker.bc;
        Calorie ct = FitnessTracker.ct;
        WeightTrack wt = FitnessTracker.wt;
        HeightTrack ht = FitnessTracker.ht;
        Calculator dcic = new DailyCalorieIntakeCalculator();
        try {
            FileOutputStream saveFile = new FileOutputStream("saveFile.sav");
            ObjectOutputStream save = new ObjectOutputStream(saveFile);

            save.writeObject(bc.getMeasure());
            save.writeObject(ct.getCalories());
            save.writeObject(wt.getMeasure());
            save.writeObject(ht.getMeasure());
            save.writeObject(dcic.getMeasure());
            save.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}




