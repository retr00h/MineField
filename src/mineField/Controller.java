package mineField;

import com.sun.rowset.internal.Row;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.io.ByteArrayInputStream;
import java.util.Base64;

public class Controller {
    private static final String TILE_ICON_BASE64 = "iVBORw0KGgoAAAANSUhEUgAAAfQAAAH0CAIAAABEtEjdAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAsrSURBVHhe7dQxbUMBFASwMOiY/YMojSAq9+y33nJ9smQMfv18HgCOkTvAQXIHOEjuAAfJHeAguQMcJHeAg+QOcJDcAQ6SO8BBcgc4SO4AB8kd4CC5Axwkd4CD5A5wkNwBDpI7wEFyBzhI7gAHyR3gILkDHCR3gIPkDnCQ3AEOkjvAQXIHOEjuAAfJHeAguQMcJHeAg+QOcJDcAQ6SO8BBcgc4SO4AB8kd4CC5Axwkd4CD5A5wkNwBDpI7wEFyBzhI7gAHyR3gILkDHCR3gIPkDnCQ3AEOkjvAQaO5v/9+Af6LGGyB3AFaMdgCuQO0YrAFcgdoxWAL5A7QisEWyB2gFYMtkDtAKwZbIHeAVgy2QO4ArRhsgdwBWjHYArkDtGKwBXIHaMVgC+QO0IrBFsgdoBWDLZA7QCsGWyB3gFYMtkDuAK0YbIHcAVox2AK5A7RisAVyB2jFYAvkDtCKwRbIHaAVgy2QO0ArBlsgd4BWDLZA7gCtGGyB3AFaMdgCuQO0YrAFcgdoxWAL5A7QisEWyB2gFYMtkDtAKwZbIHeAVgy2QO4ArRhsgdwBWjHYArkDtGKwBXIHaMVgC+QO0IrBFsgdoBWDLZA7QCsGWyB3gFYMtkDuAK0YbIHcAVox2AK5A7RisAVyB2jFYAvkDtCKwRbIHaAVgy2QO0ArBlsgd4BWDLZA7gCtGGyB3AFaMdgCuQO0YrAFcgdoxWAL5A7QisEWyB2gFYMtkDtAKwZbIHeAVgy2QO4ArRhsgdwBWjHYArkDtGKwBXIHaMVgC+QO0IrBFsgdoBWDLZA7QCsGWyB3gFYMtkDuAK0YbIHcAVox2AK5A7RisAVyB2jFYAvkDtCKwRbIHaAVgy2QO0ArBlsgd4BWDLZA7gCtGGyB3AFaMdgCuQO0YrAFcgdoxWAL5A7QisEWyB2gFYMtkDtAKwZbIHeAVgy2QO4ArRhsgdwBWjHYArkDtGKwBXIHaMVgC+QO0IrBFsgdoBWDLZA7QCsGWyB3gFYMtkDuAK0YbIHcAVox2AK5A7RisAVyB2jFYAvkDtCKwRbIHaAVgy2QO0ArBlsgd4BWDLZA7gCtGGyB3AFaMdgCuQO0YrAFcgdoxWAL5A7QisEWyB2gFYMtkDtAKwZbIHeAVgy2QO4ArRhsgdwBWjHYArkDtGKwBXIHaMVgC+QO0IrBFsgdoBWDLZA7QCsGWyB3gFYMtkDuAK0YbIHcAVox2AK5A7RisAVyB2jFYAvkDtCKwRbIHaAVgy2QO0ArBlsgd4BWDLZA7gCtGGyB3AFaMdgCuQO0YrAFcgdoxWAL5A7QisEWyB2gFYMtkDtAKwZbIHeAVgy2QO4ArRhsgdwBWjHYArkDtGKwBXIHaMVgC+QO0IrBFsgdoBWDLZA7QCsGWyB3gFYMtkDuAK0YbIHcAVox2AK5A7RisAVyB2jFYAvkDtCKwRbIHaAVgy2QO0ArBlsgd4BWDLZA7gCtGGyB3AFaMdgCuQO0YrAFcgdoxWAL5A7QisEWyB2gFYMtkDtAKwZbIHeAVgy2QO4ArRhsgdwBWjHYArkDtGKwBXIHaMVgC+QO0IrBFsgdoBWDLZA7QCsGWyB3gFYMtkDuAK0YbIHcAVox2AK5A7RisAVyB2jFYAvkDtCKwRbIHaAVgy2QO0ArBlsgd4BWDLZA7gCtGGyB3AFaMdgCuQO0YrAFcgdoxWAL5A7QisEWyB2gFYMtkDtAKwZbIHeAVgy2QO4ArRhsgdwBWjHYArkDtGKwBXIHaMVgC+QO0IrBFsgdoBWDLZA7QCsGWyB3gFYMtkDuAK0YbIHcAVox2AK5A7RisAVyB2jFYAvkDtCKwRbIHaAVgy2QO0ArBlsgd4BWDLZA7gCtGGyB3AFaMdgCuQO0YrAFcgdoxWAL5A7QisEWyB2gFYMtkDtAKwZbIHeAVgy2QO4ArRhsgdwBWjHYArkDtGKwBXIHaMVgC+QO0IrBFsgdoBWDLZA7QCsGWyB3gFYMtkDuAK0YbIHcAVox2AK5A7RisAVyB2jFYAvkDtCKwRbIHaAVgy2QO0ArBlsgd4BWDLZA7gCtGGyB3AFaMdgCuQO0YrAFcgdoxWAL5A7QisEWyB2gFYMtkDtAKwZbIHeAVgy2QO4ArRhsgdwBWjHYArkDtGKwBXIHaMVgC+QO0IrBFsgdoBWDLZA7QCsGWyB3gFYMtkDuAK0YbIHcAVox2AK5A7RisAVyB2jFYAvkDtCKwRbIHaAVgy2QO0ArBlsgd4BWDLZA7gCtGGyB3AFaMdgCuQO0YrAFcgdoxWAL5A7QisEWyB2gFYMtkDtAKwZbIHeAVgy2QO4ArRhsgdwBWjHYArkDtGKwBXIHaMVgC+QO0IrBFsgdoBWDLZA7QCsGWyB3gFYMtkDuAK0YbIHcAVox2AK5A7RisAVyB2jFYAvkDtCKwRbIHaAVgy2QO0ArBlsgd4BWDLZA7gCtGGyB3AFaMdgCuQO0YrAFcgdoxWAL5A7QisEWyB2gFYMtkDtAKwZbIHeAVgy2QO4ArRhsgdwBWjHYArkDtGKwBXIHaMVgC+QO0IrBFsgdoBWDLZA7QCsGWyB3gFYMtkDuAK0YbIHcAVox2AK5A7RisAVyB2jFYAvkDtCKwRbIHaAVgy2QO0ArBlsgd4BWDLZA7gCtGGyB3AFaMdgCuQO0YrAFcgdoxWAL5A7QisEWyB2gFYMtkDtAKwZbIHeAVgy2QO4ArRhsgdwBWjHYArkDtGKwBXIHaMVgC+QO0IrBFsgdoBWDLZA7QCsGWyB3gFYMtkDuAK0YbIHcAVox2AK5A7RisAVyB2jFYAvkDtCKwRbIHaAVgy2QO0ArBlsgd4BWDLZA7gCtGGyB3AFaMdgCuQO0YrAFcgdoxWAL5A7QisEWyB2gFYMtkDtAKwZbIHeAVgy2QO4ArRhsgdwBWjHYArkDtGKwBXIHaMVgC+QO0IrBFsgdoBWDLZA7QCsGWyB3gFYMtkDuAK0YbIHcAVox2AK5A7RisAVyB2jFYAvkDtCKwRbIHaAVgy2QO0ArBlsgd4BWDLZA7gCtGGyB3AFaMdgCuQO0YrAFcgdoxWAL5A7QisEWyB2gFYMtkDtAKwZbIHeAVgy2QO4ArRhsgdwBWjHYArkDtGKwBXIHaMVgC+QO0IrBFsgdoBWDLZA7QCsGWyB3gFYMtkDuAK0YbIHcAVox2AK5A7RisAVyB2jFYAvkDtCKwRbIHaAVgy2QO0ArBlsgd4BWDLZA7gCtGGyB3AFaMdgCuQO0YrAFcgdoxWAL5A7QisEWyB2gFYMtkDtAKwZbIHeAVgy2QO4ArRhsgdwBWjHYArkDtGKwBXIHaMVgC+QO0IrBFsgdoBWDLZA7QCsGWyB3gFYMtkDuAK0YbIHcAVox2AK5A7RisAVyB2jFYAvkDtCKwRbIHaAVgy2QO0ArBlsgd4BWDLZA7gCtGGyB3AFaMdgCuQO0YrAFcgdoxWAL5A7QisEWyB2gFYMtkDtAKwZbIHeAVgy2QO4ArRhsgdwBWjHYArkDtGKwBXIHaMVgC+QO0IrBFsgdoBWDLZA7QCsGWyB3gFYMtkDuAK0YbMFo7gA05A5wkNwBDpI7wEFyBzhI7gAHyR3gILkDHCR3gIPkDnCQ3AEOkjvAQXIHOEjuAAfJHeAguQMcJHeAg+QOcJDcAQ6SO8BBcgc4SO4AB8kd4CC5Axwkd4CD5A5wkNwBDpI7wEFyBzhI7gAHyR3gILkDHCR3gIPkDnCQ3AEOkjvAQXIHOEjuAAfJHeAguQMcJHeAg+QOcJDcAQ6SO8BBcgc4SO4AB8kd4CC5Axwkd4BzPs8XElUAzSqp398AAAAASUVORK5CYII=";
    private static final byte[] TILE_ICON_BYTEARRAY = Base64.getDecoder().decode(TILE_ICON_BASE64);
    public static final Image tileIcon = new Image(new ByteArrayInputStream(TILE_ICON_BYTEARRAY),25,25,true,true);


//    @FXML
//    private GridPane mineFieldGridPane;
//    private GameManager gameManager;
//    private int fieldWidth;
//    private int fieldHeight;
//    private int bombs;

    public Controller() {

    }

    public void initialize() {
//        gameManager = new GameManager(fieldWidth, fieldHeight, bombs);
//        gameManager.setName("Game Manager");
//        gameManager.start();

//        // TODO: sostituire con lock
//        while(gameManager.getField() == null) {
//
//        }
//
//        RowConstraints rowConstraints = new RowConstraints();
//        rowConstraints.setMinHeight(50);
//
////        ImageView tileImage = new ImageView(tileIcon);
//        for (int i = 0; i < fieldWidth; i++) {
//            for (int j = 0; j < fieldHeight; j++) {
//                mineFieldGridPane.add(new ImageView(tileIcon), i, j, 1, 1);
//            }
////            addRowToFieldGridPane(rowConstraints, i);
//        }

    }

//    private void addRowToFieldGridPane(RowConstraints rowConstraints, int r) {
//        ImageView imageView = new ImageView(tileIcon);
//
//        Node[] nodes = new Node[fieldWidth];
//        for (int i = 0; i < fieldWidth; i++) {
//            nodes[i] = imageView;
//        }
//
//        for (int j = 0; j < nodes.length; j++) {
//            mineFieldGridPane.add(nodes[j], j, r);
//        }
//        mineFieldGridPane.getRowConstraints().add(rowConstraints);
//    }

//    public void setFieldWidth(int width) {
//        fieldWidth = width;
//    }
//
//    public void setFieldHeight(int height) {
//        fieldHeight = height;
//    }
//
//    public void setBombs(int bombs) {
//        this.bombs = bombs;
//    }
}
