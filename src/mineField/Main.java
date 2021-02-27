package mineField;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static final int DEFAULT_WIDTH = 25;
    private static final int DEFAULT_HEIGHT = 25;
    private static final int DEFAULT_BOMBS = 50;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Thread.currentThread().setName("Mine Field");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainView.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        controller.setFieldWidth(DEFAULT_WIDTH);
        controller.setFieldHeight(DEFAULT_HEIGHT);
        controller.setBombs(DEFAULT_BOMBS);

        primaryStage.setTitle("Mine Field");
        primaryStage.setScene(new Scene(root));
        primaryStage.setMinWidth(500);
        primaryStage.setMinHeight(500);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
