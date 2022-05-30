package Lab11;

import java.util.List;
import java.util.concurrent.locks.Lock;

public class Philosopher implements IPhilosopher {
    private final int place;
    private final List<Fork> forks;
    private final int meals;
    private boolean isEating;
    private final RandomSleep randomSleep;
    private final Lock lock;
    private int count;


    public Philosopher(int place, List<Fork> forks, int meals, Lock lock) {
        this.place = place;
        this.forks = forks;
        this.meals = meals;
        this.lock = lock;
        isEating = false;
        count = 0;
        randomSleep = new RandomSleep(place);
    }

    @Override
    public boolean isEating() {
        return isEating;
    }

    @Override
    public int getPlace() {
        return place;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        while (count < meals) {
            randomSleep.sleep();
            Fork f1 = forks.get(place % forks.size());
            Fork f2 = forks.get((place + 1) % forks.size());
            lock.lock();
            synchronized (f1) {
                f1.setOwner(place);
                synchronized (f2) {
                    f2.setOwner(place);
                    lock.unlock();
                    isEating = true;
                    count++;
                    randomSleep.sleep();
                }
                f2.setOwner(0);
            }
            f1.setOwner(0);
            isEating = false;
        }
    }
}
