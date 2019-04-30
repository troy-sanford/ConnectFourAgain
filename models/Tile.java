package models;

/*
    last edited: 04/30/19
    author: Troy Sanford
    purpose: Extends java Circle class, to add a color attribute
                (because the java Circle class does not contain a getColor() method)
*/

import javafx.scene.paint.Color;

public class Tile extends javafx.scene.shape.Circle {

    // attribute for Color of tile (Circle class does not include getColor() method...)
    private Color color;

    /**
     * @return value of color attribute
     * Circle class doesn't include getColor() method...
     */
    public Color getColor() {
        return this.color;
    }

    //================================================================================================================

    /**
     * default constructor
     */
    public Tile() {

        // call Circle constructor to set dimensions and color of circle
        super(Util.TILE_SIZE / 2, GameModel.getRedTurn() ? Color.RED : Color.YELLOW);

        // set color attribute to appropriate color object
        this.color = GameModel.getRedTurn() ? Color.RED : Color.YELLOW;

        setCenterX(Util.SHAPE_CENTER);
        setCenterY(Util.SHAPE_CENTER);

        this.setEffect(Util.setLighting(45.0, 70.0, 5.0));

    }

}
