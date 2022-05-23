package Lab10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lab10Test {
    public static void main(String[] args) {
        ClockRunner clockRunner = new ClockRunner();
        FileCopier fileCopier = new FileCopier();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(clockRunner);
        executorService.execute(fileCopier);
    }
}
