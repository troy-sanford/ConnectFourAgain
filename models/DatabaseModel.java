package models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DatabaseModel {

    public static final String FILEPATH = "/Users/emilybaker/Desktop/ConnectFourData";
    public static int turnsTaken;

    public static void saveData(int _turnsTaken) {

        try {
            FileOutputStream fileOut = new FileOutputStream(FILEPATH);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.write(_turnsTaken);
            objectOut.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadData() {

        try {
            FileInputStream fileIn = new FileInputStream(FILEPATH);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            turnsTaken = objectIn.readInt();
            objectIn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getStatistics() {
        return turnsTaken;
    }
}
