package view;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Util;
import models.DatabaseTranslator;

public class StatisticsPage {

    protected static Pane root;
    protected static Stage primaryStage;

    public StatisticsPage(Stage stage) {
        MenuPage.primaryStage = stage;
        stage.setScene(new Scene(makeWindow()));
        stage.show();
    }

    /**
     * creates a Statistics page which will display game statistics
     */
    public static Parent makeWindow() {

        MenuPage.primaryStage.setTitle("Statistics");

        FlowPane fp = Util.makeFlowPane();
        StatisticsPage.root = fp;

        Button returntoMenuButton = Util.makeReturnToMenuButton();
        Label redWins = new Label("red wins: " + DatabaseTranslator.getRedWins());
        Label yellowWins = new Label("yellow wins: " + DatabaseTranslator.getYellowWins());

        StatisticsPage.root.getChildren().add(returntoMenuButton);
        StatisticsPage.root.getChildren().add(redWins);
        StatisticsPage.root.getChildren().add(yellowWins);

        return root;

    }
}
