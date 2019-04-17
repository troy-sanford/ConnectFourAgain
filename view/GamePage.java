package view;

import controllers.GameController;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import models.GameModel;
import models.Tile;
import models.Util;
import java.util.Optional;
import java.awt.geom.Rectangle2D;
import javafx.stage.Screen;

import java.util.ArrayList;
import java.util.List;

public class GamePage {

    protected static Pane root;
    protected static Stage primaryStage;

    public GamePage(Stage stage) {
        GamePage.primaryStage = stage;
        stage.setScene(new Scene(makeBoard()));
        notifyTurnInTitle();
        stage.show();
    }

    public static Parent makeBoard() {

        GamePage.root = new Pane();

        Shape grid = makeGrid();
        GamePage.root.getChildren().addAll(makeColumnIndicator());
        GamePage.root.getChildren().add(grid);

        return root;

    }

    private static Shape makeGrid() {

        Shape grid = new Rectangle((GameModel.BOARD_WIDTH + 1) * Util.TILE_SIZE, (GameModel.BOARD_HEIGHT + 1) * Util.TILE_SIZE);

        for (int y=0; y<GameModel.BOARD_HEIGHT; y++) {

            for (int x=0; x<GameModel.BOARD_WIDTH; x++) {

                Circle circle = new Circle(Util.SHAPE_CENTER);
                circle.setCenterX(Util.SHAPE_CENTER);
                circle.setCenterY(Util.SHAPE_CENTER);
                circle.setTranslateX(x * (Util.TILE_SIZE + Util.HORIZONTAL_PADDING) + Util.TILE_SIZE / 4);
                circle.setTranslateY(y * (Util.TILE_SIZE + Util.VERTICAL_PADDING) + Util.TILE_SIZE / 4);

                grid = grid.subtract(grid, circle);

            }
        }

        grid.setFill(Color.BLUE);
        grid.setEffect(Util.setLighting(35.0, 60.0, 5.0));

        return grid;

    }

    private static List<Rectangle> makeColumnIndicator() {

        List<Rectangle> indicator = new ArrayList<>();

        for (int x=0; x<GameModel.BOARD_WIDTH; x++) {

            Rectangle column = new Rectangle(Util.TILE_SIZE, (GameModel.BOARD_HEIGHT + 1) * Util.TILE_SIZE);
            column.setTranslateX(x * (Util.TILE_SIZE + Util.HORIZONTAL_PADDING) + Util.TILE_SIZE / 4);
            column.setFill(Color.TRANSPARENT);

            column.setOnMouseEntered(e -> column.setFill(Color.rgb(200, 200, 50, 0.4)));
            column.setOnMouseExited(e -> column.setFill(Color.TRANSPARENT));

            final int selection = x;
            column.setOnMouseClicked(e -> dropTile(new Tile(), selection));

            indicator.add(column);
        }

        return indicator;

    }

    public static void dropTile(Tile _tile, int _column) {

        GameController.dropTile(_tile, _column);

        _tile.setTranslateX(_column * (Util.TILE_SIZE + Util.HORIZONTAL_PADDING) + Util.TILE_SIZE / 4);
        _tile.setTranslateY((GameModel.BOARD_HEIGHT - GameController.getTilesInColumn(_column)) * (Util.TILE_SIZE + Util.VERTICAL_PADDING) + Util.TILE_SIZE / 4);

        GamePage.root.getChildren().add(_tile);

        GameController.checkForVictory();
        notifyTurnInTitle();
    }

    public static void notifyVictory() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("GAME OVER");
        alert.setHeaderText(null);
        alert.setContentText(GameController.getTurnColorString() + " wins!");

        ButtonType backToMenu = new ButtonType("Back to Menu");
        ButtonType playAgain = new ButtonType("Play Again");

        alert.getButtonTypes().setAll(backToMenu, playAgain);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == backToMenu){
            MenuPage.primaryStage.setScene(new Scene(MenuPage.makeWindow()));
        } else {
            MenuPage.primaryStage.setScene(new Scene(GamePage.makeBoard()));
        }

        alert.show();
        GameController.restartGame();
        alert.close();

    }

    public static void notifyTurnInTitle() {
        MenuPage.primaryStage.setTitle(GameController.getTurnColorString() + "'s turn");
    }


}
