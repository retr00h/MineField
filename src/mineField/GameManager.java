package mineField;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class GameManager extends Thread {
    private byte[][] mineField;
    private boolean[][] flagField;
    private boolean[][] discoveredField;

    private final int width;
    private final int height;
    private final int bombs;
    private int flags;

    public GameManager(int width, int height, int bombs) {
        this.width = width;
        this.height = height;
        this.bombs = bombs;
        flags = bombs;
    }

    private void initializeMineField() {
        mineField = new byte[width][height];

        int n = 0;
        Random generator = new Random();
        while (n <= bombs) {
            int i = generator.nextInt(width);
            int j = generator.nextInt(height);
            if (getCell(i, j) != -1) {
                setCell((byte) -1, i, j);
            }
            n++;
        }

        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++) {
                if (getCell(i, j) == 0) {
                    byte val = computeNumber(i, j);
                    setCell(val, i, j);
                }
            }
        }
    }

    private byte computeNumber(int i, int j) {
        int width = getWidth();
        int height = getHeight();
        byte n = 0;
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k >= 0 && l >= 0 && k < width && l < height) {
                    if (getCell(k, l) == -1) n++;
                }
            }
        }
        return n;
    }

    private void setCell(byte value, int i, int j) {
        if (i < getWidth() && j < getHeight()) mineField[i][j] = value;
    }

    byte getCell(int i, int j) {
        if (i < getWidth() && j < getHeight()) return mineField[i][j];
        else return -5;
    }

    private void initializeFlagField() {
        flagField = new boolean[width][height];
    }

    @Override
    public void run() {
        super.run();

        initializeMineField();
        initializeFlagField();
        initializeDiscoveredField();

//        try {
//            sem.acquire();
//        } catch (InterruptedException ignored) { }
    }

    private void initializeDiscoveredField() {
        discoveredField = new boolean[width][height];
    }

//    void gameOver() {
//        wake();
//    }

    public byte[][] getField() {
        return mineField;
    }

    private int getWidth() {
        return width;
    }

    private int getHeight() {
        return height;
    }

    public boolean isFlag(int i, int j) {
        return flagField[i][j];
    }

    public boolean isBomb(int i, int j) {
        return mineField[i][j] == -1;
    }

    public void updateFlag(int i, int j) {
        if (!flagField[i][j]) {
            flags--;
            flagField[i][j] = true;
        } else {
            flags++;
            flagField[i][j] = false;
        }
    }

    public boolean canFlag() {
        return flags > 0;
    }

    public byte discover(int i, int j) {
        discoveredField[i][j] = true;
        return getCell(i, j);
    }

    boolean isDiscovered(int i, int j) {
        return discoveredField[i][j];
    }

//    private void wake() {
//        sem.release();
//    }
}
