package ui;

import model.*;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SaveFile {

    ///save load functions are built step by step with instructions from　beginwithjava.blogspot.com
    public static void main(String[] args) {
        Calculator bc = Gui.bc;
        Calorie ct = Gui.ct;
        WeightTrack wt = Gui.wt;
        HeightTrack ht = Gui.ht;
        Calculator dcic = new DailyCalorieIntakeCalculator();
        try {
            FileOutputStream saveFile = new FileOutputStream("saveFile.sav");
            ObjectOutputStream save = new ObjectOutputStream(saveFile);

            save.writeObject(bc.getMeasure());
            save.writeObject(ct.getNetCalories());
            save.writeObject(wt.getMeasure());
            save.writeObject(ht.getMeasure());
            save.writeObject(dcic.getMeasure());
            save.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}




