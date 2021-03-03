package mineField;

import java.io.File;

// una specie di controller: agisce su Field ma è controllato dal Controller della GUI
public class GameManager extends Thread {
    private Field mineField;
    private boolean[][] flagField;

    private final int width;
    private final int height;
    private final int bombs;
    private int flags;

    private boolean gameOver = false;

    public GameManager(int width, int height, int bombs) {
        this.width = width;
        this.height = height;
        this.bombs = bombs;
        flags = bombs;
        initializeFlagField();
        setDaemon(true);
    }

    private void initializeFlagField() {
        flagField = new boolean[width][height];
    }

    @Override
    public void run() {
        super.run();

        mineField = new Field(width, height, bombs);
        // TODO: aspettare che il Main sblocchi la lock
        while (!gameOver) {
            
        }
        // TODO: qualcosa che indichi il game over
    }

    void gameOver() {
        gameOver = true;
    }

    public Field getField() {
        return mineField;
    }

    public boolean isFlag(int i, int j) {
        return flagField[i][j];
    }

    public boolean canFlag() {
        return flags > 0;
    }

    public void updateFlag(int i, int j) {
        flagField[i][j] = !flagField[i][j];
    }
}
