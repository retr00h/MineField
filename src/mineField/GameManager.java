package mineField;

// una specie di controller: agisce su Field ma è controllato dal Controller della GUI
public class GameManager extends Thread {
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
    }

    @Override
    public void run() {
        super.run();
        while (!gameOver) {
            
        }
    }
}
