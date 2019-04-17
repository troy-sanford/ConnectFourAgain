package view;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.FlowPane;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import models.Util;

public class MenuPage {

    protected static Pane root;
    public static Stage primaryStage;

    public MenuPage(Stage stage) {
        MenuPage.primaryStage = stage;
        stage.setScene(new Scene(makeWindow()));
        stage.show();
    }

    public static Parent makeWindow() {

        MenuPage.primaryStage.setTitle("Menu");

        FlowPane fp = Util.makeFlowPane();
        MenuPage.root = fp;

        Button twoPlayerButton = new Button("Two Player");
        Button settingsButton = new Button("Settings");
        Button statisticsButton = new Button("Statistics");

        twoPlayerButton.setOnAction(e -> { MenuPage.primaryStage.setScene(new Scene(GamePage.makeBoard()));
                                            GamePage.notifyTurnInTitle();});
        settingsButton.setOnAction(e -> MenuPage.primaryStage.setScene(new Scene(SettingsPage.makeWindow())));
        statisticsButton.setOnAction(e -> MenuPage.primaryStage.setScene(new Scene(StatisticsPage.makeWindow())));

        MenuPage.root.getChildren().add(twoPlayerButton);
        MenuPage.root.getChildren().add(settingsButton);
        MenuPage.root.getChildren().add(statisticsButton);

        return root;

    }


}
