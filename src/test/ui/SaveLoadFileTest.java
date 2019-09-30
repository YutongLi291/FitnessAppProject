package ui;

import org.junit.jupiter.api.Test;

import java.io.*;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaveLoadFileTest {


    @Test
    public void SaveLoadFileTest() throws IOException, ClassNotFoundException {

        FileOutputStream saveFile = new FileOutputStream("testSave.sav");
        ObjectOutputStream save = new ObjectOutputStream(saveFile);
        save.writeObject("Hi this is the first line");
        save.writeObject(true);
        save.writeObject(2000);
        save.writeObject(1949);
        save.writeObject("This is the last line");
        save.close();

        FileInputStream loadFile = new FileInputStream("testSave.sav");
        ObjectInputStream restore  = new ObjectInputStream(loadFile);
        String firstLine = (String) restore.readObject();
        Boolean secondLine = (boolean) restore.readObject();
        int thirdLine = (int) restore.readObject();
        int fourthLine = (int) restore.readObject();
        String lastLine = (String) restore.readObject();
        restore.close();

        assertEquals(firstLine, "Hi this is the first line");
        assertEquals(secondLine, true);
        assertEquals(thirdLine, 2000);
        assertEquals(fourthLine, 1949);
        assertEquals(lastLine, "This is the last line");


    }
}
