package models;

import javafx.scene.paint.Color;
import view.GamePage;

public class GameModel {

    // set constants for board height and width
    public static final int BOARD_HEIGHT = 6;
    public static final int BOARD_WIDTH = 7;

    // create a two dimensional array of tile objects to represent the game board
    private static Tile[][] board = new Tile[BOARD_HEIGHT + 1][BOARD_WIDTH + 1];
    // variable to track which turn it is (red goes first by default)
    private static boolean redTurn = true;
    // variable to track number of turns taken, initialized at 0 (obviously)
    private static int turnsTaken = 0;
    // variable to track number of tiles in each column
    private static int[] tilesInColumns = new int[7];

    /**
     * switch turns
     */
    public static void changeTurns() {
        redTurn = !redTurn;
    }

    /**
     * adds Tile objects to the board array
     * @param _tile a new Tile object
     * @param _column integer representing which column the Tile should be 'dropped' in
     */
    public static void dropTile(Tile _tile, int _column) {

        // if this column is full, return (invalid move)
        if (tilesInColumns[_column] >= BOARD_HEIGHT) {
            return;
        }

        // if we get here, a valid column was selected...

        // increment number of turns taken
        turnsTaken++;
        // set the lowest available slot in the selected column to the Tile being "dropped"
        board[_column][tilesInColumns[_column]] = _tile;

        // increment the number of tiles in this column so that the next time this column is selected,
        // the new tile will go in the lowest available slot
        tilesInColumns[_column]++;
    }

    /**
     * helper method for the check method
     */
    public static void checkHelper() {
        // only check for victory after 6 turns have been taken (earliest possible victory)
        if (turnsTaken > 6) {
            if (check()) {
                GamePage.notifyVictory();
            }
        }
        // putting this here prevents me from having to put it before every return statement in the check() method
        changeTurns();
    }

    /**
     * checks for four tiles in a row that are all the color of the turn that was JUST taken
     */
    public static boolean check() {

        // variable to track the number of same-colored tiles in a row
        int streak;

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

    /**
     * function that allows Settings page to change which color goes first
     * @param _redFirst if true, red goes first
     */
    public static void setRedFirst(boolean _redFirst) {
        GameModel.redTurn = _redFirst;
    }

    /**
     * returns number of tiles in given column
     * @param _column integer representing a column of the board
     * @return number of tiles in given column
     */
    public static int getTilesInColumn(int _column) {
        return tilesInColumns[_column];
    }

    /**
     * determines which turn it is
     * @return true - red's turn, false - yellow's turn
     */
    public static boolean getRedTurn() {
        return redTurn;
    }

    /**
     * @return Color object correlating to current turn
     */
    public static Color getTurnColor() {
        return getRedTurn() ? Color.RED : Color.YELLOW;
    }

    /**
     * @return String representing current turn (used for text views)
     */
    public static String getTurnColorString() {
        return getRedTurn() ? "Red" : "Yellow";
    }

    /**
     * starts a new game
     */
    public static void restartGame() {
        // set game board to an empty two dimensional array
        board = new Tile[BOARD_HEIGHT + 1][BOARD_WIDTH + 1];
        // set turns taken to 0
        turnsTaken = 0;
        // each column has 0 tiles in it, so set tilesInColumns to an empty array
        tilesInColumns = new int[7];
    }

}
