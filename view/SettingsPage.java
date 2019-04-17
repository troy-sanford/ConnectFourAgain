package view;

import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import models.GameModel;
import models.Util;

public class SettingsPage {

    protected static Pane root;
    protected static Stage primaryStage;

    public SettingsPage(Stage stage) {
        stage.setScene(new Scene(makeWindow()));
        stage.show();
    }

    /**
     * creates a Settings menu that allows the user to edit which tile color goes first
     */
    public static Parent makeWindow() {

        MenuPage.primaryStage.setTitle("Settings");

        FlowPane fp = Util.makeFlowPane();
        SettingsPage.root = fp;

        Button returnToMenuButton = new Button("Return to menu");
        // call controller, not model <3
        Button redFirstButton = new Button(GameModel.getRedTurn() ? "Red Moves First" : "Yellow Moves First");

        returnToMenuButton.setOnAction(e -> MenuPage.primaryStage.setScene(new Scene(MenuPage.makeWindow())));

        redFirstButton.setOnAction(e -> { GameModel.setRedFirst(!GameModel.getRedTurn());;
                                        redFirstButton.setText(GameModel.getRedTurn() ? "Red Moves First" : "Yellow Moves First");});
        redFirstButton.setWrapText(true);

        SettingsPage.root.getChildren().add(returnToMenuButton);
        SettingsPage.root.getChildren().add(redFirstButton);

        return root;

    }


}
