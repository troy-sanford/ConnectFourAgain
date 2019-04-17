package view;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        MenuPage game = new MenuPage(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
