package models;

/*
    last edited: 04/30/19
    author: Troy Sanford
    purpose: Translator class that reroutes data to/from the DatabaseModel
*/

public class DatabaseTranslator {

    // int array because only one object can be returned from load function
    public static int[] wins = new int[2];
    // variables to store number of wins per color
    public static int redWins;
    public static int yellowWins;

    /**
     * @return number of red wins as loaded from .dat file
     */
    public static int getRedWins() {
        return DatabaseTranslator.redWins;
    }

    /**
     * @return number of yellow wins as loaded from .dat file
     */
    public static int getYellowWins() { return DatabaseTranslator.yellowWins;}

    //================================================================================================================

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
        DatabaseTranslator.wins = DatabaseModel.getStatistics();
        DatabaseTranslator.redWins = wins[0];
        DatabaseTranslator.yellowWins = wins[1];
    }

}
