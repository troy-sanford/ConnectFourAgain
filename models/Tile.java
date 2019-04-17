package models;

import javafx.scene.paint.Color;

public class Tile extends javafx.scene.shape.Circle {

    private Color color;

    public Tile() {

        super(Util.TILE_SIZE / 2, GameModel.getRedTurn() ? Color.RED : Color.YELLOW);

        this.color = GameModel.getRedTurn() ? Color.RED : Color.YELLOW;

        setCenterX(Util.SHAPE_CENTER);
        setCenterY(Util.SHAPE_CENTER);

        this.setEffect(Util.setLighting(45.0, 70.0, 5.0));

    }

    public Color getColor() {
        return color;
    }

    public String getColorString() {
        if (this.color == Color.RED) {
            return "RED";
        }
        else if (this.color == Color.YELLOW) {
            return "YELLOW";
        }
        else {
            return "error";
        }
    }

}
