package mineField;

public abstract class Cell {
    boolean isBomb() {
        return this instanceof Bomb;
    }
}
