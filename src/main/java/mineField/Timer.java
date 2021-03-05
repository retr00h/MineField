package mineField;

public class Timer extends Thread {
    private final Main main;

    public Timer (Main main) {
        setDaemon(true);
        this.main = main;
        start();
    }

    @Override
    public void run() {
        super.run();
        long startTime;
        long currentTime;

        do {
            startTime = System.currentTimeMillis();
            try {
                sleep(500);
            } catch (InterruptedException e) {
                interrupt();
                break;
            }

            currentTime = System.currentTimeMillis();

            while (currentTime - startTime < 1000) {
                try {
                    sleep(200);
                } catch (InterruptedException e) {
                    interrupt();
                    break;
                }
                currentTime = System.currentTimeMillis();
            }
            main.updateTimerLabel();
        } while (!main.isGameOver());
    }
}