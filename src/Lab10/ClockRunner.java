package Lab10;

public class ClockRunner implements Runnable {
    @Override
    public void run() {
        Clock clock = new Clock(500);
        while(true) {
            clock.setTime(System.currentTimeMillis());
        }
    }
}
