package ui;

import model.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import static ui.FitnessTracker.bc;

public class LoadFile {

    public static void main(String[] args) {

        try {
            FileInputStream saveFile = new FileInputStream("saveFile.sav");
            ObjectInputStream restore  = new ObjectInputStream(saveFile);
            FitnessTracker.bc.bmi = (double) restore.readObject();
            FitnessTracker.ct.netCalories = (int) restore.readObject();
            FitnessTracker.wt.weight = (double) restore.readObject();
            FitnessTracker.ht.height = (double) restore.readObject();
            FitnessTracker.dcic.recommendedIntake = (double) restore.readObject();

            restore.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
