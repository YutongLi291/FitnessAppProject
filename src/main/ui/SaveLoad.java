package ui;

import model.BmiCalculator;
import model.CalorieTrack;
import model.WeightTrack;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveLoad {
    FileOutputStream saveFile = new FileOutputStream("saveFile.sav");
    ObjectOutputStream save = new ObjectOutputStream(saveFile);

    public SaveLoad() throws IOException {
        save.writeObject(BmiCalculator.bmi);
        save.writeObject(CalorieTrack.netCalories);
        save.writeObject(WeightTrack.weight);

    }
}
