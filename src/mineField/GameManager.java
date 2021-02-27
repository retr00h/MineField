package mineField;

import java.io.File;

// una specie di controller: agisce su Field ma è controllato dal Controller della GUI
public class GameManager extends Thread {
    private Field mineField;

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
        mineField = new Field(width, height, bombs);
    }

    @Override
    public void run() {
        super.run();
        while (!gameOver) {
            
        }
    }

    public Field getField() {
        return mineField;
    }
}
