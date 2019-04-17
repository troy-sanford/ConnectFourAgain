package view;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.GameModel;
import models.Util;

public class StatisticsPage {

    protected static Pane root;
    protected static Stage primaryStage;

    public StatisticsPage(Stage stage) {
        MenuPage.primaryStage = stage;
        stage.setScene(new Scene(makeWindow()));
        stage.show();
    }

    public static Parent makeWindow() {

        MenuPage.primaryStage.setTitle("Statistics");

        FlowPane fp = Util.makeFlowPane();
        StatisticsPage.root = fp;

        Button returntoMenuButton = Util.makeReturnToMenuButton();
        Label lbl = new Label("This is where you can see your statistics");

        StatisticsPage.root.getChildren().add(returntoMenuButton);
        StatisticsPage.root.getChildren().add(lbl);

        return root;

    }
}
