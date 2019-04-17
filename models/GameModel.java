package models;

import javafx.scene.paint.Color;
import view.GamePage;

public class GameModel {

    public static final int BOARD_HEIGHT = 6;
    public static final int BOARD_WIDTH = 7;

    private static Tile[][] board = new Tile[BOARD_HEIGHT + 1][BOARD_WIDTH + 1];
    private static boolean redTurn = true;
    private static int turnsTaken = 0;
    private static int[] tilesInColumns = new int[7];


    public static void dropTile(Tile _tile, int _column) {

        if (tilesInColumns[_column] >= BOARD_HEIGHT) {
            return;
        }

        turnsTaken++;
        board[_column][tilesInColumns[_column]] = _tile;

        if (turnsTaken > 6) {
            if (check()) {
                GamePage.notifyVictory();
            }
        }

        tilesInColumns[_column]++;
        redTurn = !redTurn;
        GamePage.notifyTurnInTitle();
    }

    public static boolean check() {

        int streak;
        String turnColor = getTurnColorString();

        // check for vertical victory
        for (int i=0; i<7; i++) {
            streak = 0;
            for (int j=0; j<7; j++) {
                if (board[i][j] != null) {
                    if (board[i][j].getColor().equals(getTurnColor())) {
                        streak++;
                        if (streak >= 4) {
                            return true;
                        }
                    } else {
                        streak = 0;
                    }
                }
                else {
                    streak = 0;
                }
            }
        }

        // check for horizontal victory
        for (int i=0; i<6; i++) {
            streak = 0;
            for (int j=0; j<7; j++) {
                if (board[j][i] != null) {
                    if (board[j][i].getColor().equals(getTurnColor())) {
                        streak++;
                        if (streak >= 4) {
                            return true;
                        }
                    } else {
                        streak = 0;
                    }
                }
                else {
                    streak = 0;
                }
            }
        }

        // check for positive slope victory
        for (int i=0; i<4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != null) {
                    if (board[i][j].getColor().equals(getTurnColor())) {
                        if (board[i + 1][j + 1] != null && board[i + 1][j + 1].getColor().equals(getTurnColor())) {
                            if (board[i + 2][j + 2] != null && board[i + 2][j + 2].getColor().equals(getTurnColor())) {
                                if (board[i + 3][j + 3] != null && board[i + 3][j + 3].getColor().equals(getTurnColor())) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }

        // check for negative slope victory
        for (int i=0; i<4; i++) {
            for (int j = 3; j < 7; j++) {
                if (board[i][j] != null) {
                    if (board[i][j].getColor().equals(getTurnColor())) {
                        if (board[i + 1][j - 1] != null && board[i + 1][j - 1].getColor().equals(getTurnColor())) {
                            if (board[i + 2][j - 2] != null && board[i + 2][j - 2].getColor().equals(getTurnColor())) {
                                if (board[i + 3][j - 3] != null && board[i + 3][j - 3].getColor().equals(getTurnColor())) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }

        return false;

    }

    public static void setRedFirst(boolean _redFirst) {
        GameModel.redTurn = _redFirst;
    }

    public static int getTilesInColumn(int _column) {
        return tilesInColumns[_column];
    }

    public static boolean getRedTurn() {
        return redTurn;
    }

    public static Color getTurnColor() {
        return getRedTurn() ? Color.RED : Color.YELLOW;
    }

    public static String getTurnColorString() {
        return getRedTurn() ? "Red" : "Yellow";
    }

    public static void restartGame() {
        board = new Tile[BOARD_HEIGHT + 1][BOARD_WIDTH + 1];
        redTurn = true;
        turnsTaken = 0;
        tilesInColumns = new int[7];
    }

}
