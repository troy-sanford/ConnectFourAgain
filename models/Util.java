package models;

import javafx.scene.control.Button;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.FlowPane;
import view.MenuPage;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class Util {

    // constants for dimensions for board, shapes in board, etc
    public static final int TILE_SIZE = 80;
    public static final int SHAPE_CENTER = TILE_SIZE / 2;
    public static final int VERTICAL_PADDING = 7;
    public static final int HORIZONTAL_PADDING = 7;

    /**
     * creates a lighting effect to be used on shapes (board and tiles)
     * used in both Tile class and GamePage class
     */
    public static Lighting setLighting(double _azimuth, double _elevation, double _surfaceScale) {
        Light.Distant light = new Light.Distant();
        light.setAzimuth(_azimuth);
        light.setElevation(_elevation);

        Lighting lighting = new Lighting();
        lighting.setLight(light);
        lighting.setSurfaceScale(_surfaceScale);

        return lighting;
    }

    /**
     * creates a FlowPane
     * used in multiple views
     */
    public static FlowPane makeFlowPane() {
        FlowPane fp = new FlowPane();
        fp.setHgap(10);
        fp.setVgap(10);
        return fp;
    }

    /**
     * creates a return to main menu button
     * used in SettingsPage and StatisticsPage
     * @return button object that redirects user to MenuPage
     */
    public static Button makeReturnToMenuButton() {
        Button btn = new Button("Return to menu");
        btn.setOnAction(e -> MenuPage.primaryStage.setScene(new Scene(MenuPage.makeWindow())));
        return btn;
    }

}
