package controllers;

/*
    last edited: 04/30/19
    author: Troy Sanford
    purpose: Controller class to reroute data between Views and GameModel
*/

import models.GameModel;
import models.Tile;

public class GameController {

    public static int getTilesInColumn(int _column) {
        return GameModel.getTilesInColumn(_column);
    }

    public static void dropTile(Tile _tile, int _column) {
        GameModel.dropTile(_tile, _column);
    }

    public static void restartGame() {
        GameModel.restartGame();
    }

    public static String getTurnColorString() {
        return GameModel.getTurnColorString();
    }

    public static void checkForVictory() {
        GameModel.checkHelper();
    }

}
