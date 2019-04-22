package models;

public class DatabaseTranslator {

    public static int turnsToWin;
    public static int redWins;
    public static int yellowWins;
    public static int avgToWinRed;
    public static int avgToWinYellow;


    public static void saveData(int _turnsTaken) {
        DatabaseModel.saveData(_turnsTaken);
    }

    public static void loadData() {
        DatabaseModel.loadData();
        int statistics = DatabaseModel.getStatistics();
        turnsToWin = statistics;
    }

    public static int getTurnsToWin() {
        return turnsToWin;
    }

}
