package mineField;

public class GarbageCollector extends Thread {

    public GarbageCollector() {
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        super.run();
        System.gc();
        try {
            sleep(500);
        } catch (InterruptedException ignored) {}
    }
}
