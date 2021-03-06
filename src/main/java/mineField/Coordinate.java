package mineField;

public class Coordinate {
    private final byte x;
    private final byte y;

    public Coordinate(byte i, byte j) {
        x = i;
        y = j;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
