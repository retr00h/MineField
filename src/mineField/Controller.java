package mineField;

import javafx.fxml.FXML;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class Controller {

    @FXML
    private GridPane mineFieldGridPane;
    private GameManager gameManager;
    private int fieldWidth;
    private int fieldHeight;
    private int bombs;

    public Controller() {

    }

    public void initialize() {
        gameManager = new GameManager(fieldWidth, fieldHeight, bombs);
        gameManager.setName("Game Manager");
        gameManager.start();

        RowConstraints rowConstraints = mineFieldGridPane.getRowConstraints().get(0);
        ColumnConstraints columnConstraints = mineFieldGridPane.getColumnConstraints().get(0);

        Field field = new Field(20,20,50);
        System.out.println(field.toString());
    }

    public void setFieldWidth(int width) {
        fieldWidth = width;
    }

    public void setFieldHeight(int height) {
        fieldHeight = height;
    }

    public void setBombs(int bombs) {
        this.bombs = bombs;
    }
}
