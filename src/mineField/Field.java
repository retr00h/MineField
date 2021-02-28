package mineField;

import java.util.Random;

// contiene il campo minato effettivo, verrà aggiornato ogni volta che l'utente interagisce con la GUI
public class Field {
    private Cell[][] field;
    private final int width;
    private final int height;

    public Field (int width, int height, int bombs) {
        this.width = width;
        this.height = height;
        initialize(width, height, bombs);
    }

    private void initialize(int width, int height, int bombs) {
        field = new Cell[width][height];

        int n = 0;
        Random generator = new Random();
        while (n < bombs) {
            int i = generator.nextInt(width);
            int j = generator.nextInt(height);
            if (getCell(i, j) == null) {
                setCell(new Bomb(), i, j);
            }
            n++;
        }

        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++) {
                if (getCell(i, j) == null) {
                    Number num = new Number(computeNumber(i, j));
                    setCell(num, i, j);
                }
            }
        }
    }

    private int computeNumber(int i, int j) {
        int width = getWidth();
        int height = getHeight();
        int n = 0;
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k >= 0 && l >= 0 && k < width && l < height) {
                    if (getCell(k, l) instanceof Bomb) n++;
                }
            }
        }
        return n;
    }

    private void setCell(Cell cell, int i, int j) {
        if (i < getWidth() && j < getHeight()) field[i][j] = cell;
    }

    Cell getCell(int i, int j) {
        if (i < getWidth() && j < getHeight()) return field[i][j];
        else return null;
    }

    public String toString() {
        String str = "";
        int width = getWidth();
        int height = getHeight();

        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++) {
                if (getCell(i, j) instanceof Bomb) str += "B ";
                else {
                    str += ((Number) getCell(i, j)).getValue() + " ";
                }
            }
            str += "\n";
        }
        return str;
    }

    private int getWidth() {
        return width;
    }

    private int getHeight() {
        return height;
    }
}
