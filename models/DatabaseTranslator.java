package models;

public class DatabaseTranslator {

    // int array because only one object can be returned from load function
    public static int[] wins = new int[2];
    // variables to store number of wins per color
    public static int redWins;
    public static int yellowWins;

    /**
     * function to save number of wins for red and yellow
     */
    public static void saveData() {
        // update redWins and yellowWins variables to that they can be incremented
        DatabaseTranslator.loadData();
        DatabaseModel.saveData(DatabaseTranslator.getRedWins(), DatabaseTranslator.getYellowWins());
    }

    /**
     * function to load number of red wins and yellow wins, save data to variables
     */
    public static void loadData() {
        DatabaseModel.loadData();
        wins = DatabaseModel.getStatistics();
        redWins = wins[0];
        yellowWins = wins[1];
    }

    /**
     * @return number of red wins as loaded from .dat file
     */
    public static int getRedWins() {
        return redWins;
    }

    /**
     * @return number of yellow wins as loaded from .dat file
     */
    public static int getYellowWins() { return yellowWins;}

}
