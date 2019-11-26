package ui;

import model.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import static ui.Gui.bc;
import static ui.Gui.dcic;

public class LoadFile {

    //save load functions are built step by step with instructions from　beginwithjava.blogspot.com
    public static void main(String[] args) {

        try {
            FileInputStream saveFile = new FileInputStream("saveFile.sav");
            ObjectInputStream restore = new ObjectInputStream(saveFile);
            bc.trackMeasure((double) restore.readObject());
            Gui.ct.netCalories = (int) restore.readObject();
            Gui.wt.measure = (double) restore.readObject();
            Gui.ht.measure = (double) restore.readObject();
            dcic.trackMeasure((double) restore.readObject());

            restore.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
