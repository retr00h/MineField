package mineField;

import java.util.Random;

public class GameManager extends Thread {

    private byte[][] mineField;
    private Coordinate[][][] adjacent;
    private boolean[][] flagField;
    private boolean[][] discoveredField;

    private final int width;
    private final int height;
    private final int bombs;
    private int flags;
    private int discovered;

    @Override
    public void run() {
        super.run();
        initializeMineField();
        initializeAdjacent();
        initializeFlagField();
        initializeDiscoveredField();
    }

    public GameManager(int width, int height, int bombs) {
        this.width = width;
        this.height = height;
        this.bombs = bombs;
        flags = bombs;
        discovered = 0;
    }

    private void initializeMineField() {
        mineField = new byte[width][height];

        int n = 0;
        Random generator = new Random();
        while (n < bombs) {
            int i = generator.nextInt(width);
            int j = generator.nextInt(height);
            if (getCell(i, j) != -1) {
                setCell((byte) -1, i, j);
                n++;
            }
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

    // matrice tridimensionale usata per trovare le celle adiacenti ad una data cella.
    // lo scopo è quello di accedere all'array nella cella (i, j) quando una cella viene cliccata,
    // in modo da scoprire tutte le celle adiacenti (ricorsivamente) se la cella cliccata è una cella
    // senza bombe nelle celle adiacenti (vedere Main.discover())
    private void initializeAdjacent() {
        adjacent = new Coordinate[width][height][9];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int index = 0;
                if (getCell(i, j) == 0) {
                    for (int k = i - 1; k <= i + 1; k++) {
                        for (int l = j - 1; l <= j + 1; l++) {
                            if (k >= 0 && l >= 0 && k < width && l < height) {
                                if (!(k == i && l == j)) {
                                    adjacent[i][j][index] = new Coordinate((byte) k, (byte) l);
                                    index++;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.gc();
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

    private void initializeDiscoveredField() {
        discoveredField = new boolean[width][height];
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
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
        Main.updateFlags(flags);
    }

    public boolean canFlag() {
        return flags > 0;
    }

    public byte discover(int i, int j) {
        discoveredField[i][j] = true;
        discovered++;
        return getCell(i, j);
    }

    boolean isDiscovered(int i, int j) {
        return discoveredField[i][j];
    }

    public Coordinate[] getAdjacent(int i, int j) {
        return adjacent[i][j];
    }

    public boolean computeVictory() {
        if (discovered / (width * height) < (90/100)) return false;
        int n = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (flagField[i][j] && isBomb(i, j)) {
                    n++;
                }
            }
        }

        return n == bombs;
    }
}
