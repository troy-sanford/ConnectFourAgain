package models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DatabaseModel {

    // variable for filepath to save data .dat file
    public static final String FILEPATH = "/Users/emilybaker/Desktop/ConnectFourData";
    // array to store number of wins per color, index 0 for red, index 1 for yellow
    public static int[] statistics = new int[2];

    /**
     * function to increment red wins or red wins appropriately, and save data to .dat file
     * @param _redWins number of red wins, as loaded from the file
     * @param _yellowWins number of yellow wins, as loaded from the file
     */
    public static void saveData(int _redWins, int _yellowWins) {

        try {
            FileOutputStream fileOut = new FileOutputStream(FILEPATH);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            // if red won, increment red wins, keep yellow wins the same
            if (GameModel.getRedTurn()) {
                objectOut.write(_redWins + 1);
                objectOut.write(_yellowWins);
            }
            // if yellow won, increment yellow wins, keep red wins the same
            else {
                objectOut.write(_redWins);
                objectOut.write(_yellowWins + 1);
            }

            objectOut.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * function to load data from .dat file, return data in an integer array
     */
    public static void loadData() {

        try {
            FileInputStream fileIn = new FileInputStream(FILEPATH);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            statistics[0] = objectIn.read();
            statistics[1] = objectIn.read();
            objectIn.close();

        } catch (java.io.FileNotFoundException e) {
            statistics = new int[2];
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return array containing redWins, yellowWins
     */
    public static int[] getStatistics() {return statistics;}
}
