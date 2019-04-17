package controllers;

import models.GameModel;
import models.Tile;

public class GameController {

    public static void dropTile(Tile _tile, int _column) {
        GameModel.dropTile(_tile, _column);
    }

}
