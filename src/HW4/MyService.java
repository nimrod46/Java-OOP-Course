package HW4;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService implements Service {
    private final Queue<Runnable> taskQueue;
    private final Lock lock;
    private final Map<Integer, Boolean> threadStateById;
    private final List<Thread> threadPool;
    private final Condition cond;
    private boolean isShutdown;

    public MyService(int threadPoolSize) {
        lock = new ReentrantLock();
        isShutdown = false;
        taskQueue = new ConcurrentLinkedQueue<>();
        threadStateById = new HashMap<>();
        threadPool = new ArrayList<>();
        cond = lock.newCondition();
        for (int i = 0; i < threadPoolSize; i++) {
            threadPool.add(startTaskExecutor(i));
            threadStateById.put(i, false);
        }
    }

    @Override
    public void execute(Runnable r) {
        if (isShutdown) {
            return;
        }
        taskQueue.add(r);
        lock.lock();
        cond.signal();
        lock.unlock();
    }

    @Override
    public void awaitTermination() throws InterruptedException {
        while (isStillWorking()) {
            lock.lock();
            cond.await();
            lock.unlock();
        }
    }

    @Override
    public void shutdown() {
        isShutdown = true;
    }

    @Override
    public void shutdownNow() {
        isShutdown = true;
        for (Thread th : threadPool) {
            th.interrupt();
        }
    }

    @Override
    public boolean isShutdown() {
        return isShutdown;
    }

    private Thread startTaskExecutor(int id) {
        Thread th = new Thread(() -> {
            while (!isShutdown) {
                Runnable r;
                try {
                    lock.lock();
                    while (taskQueue.isEmpty())
                        cond.await();
                    r = taskQueue.poll();
                    threadStateById.put(id, true);

                } catch (InterruptedException e) {
                    return;
                }
                finally {
                    lock.unlock();
                }
                r.run();
                threadStateById.put(id, false);
                lock.lock();
                cond.signal(); //Signal that the thread finished, used for "awaitTermination"
                lock.unlock();
            }
        });
        th.start();
        return th;
    }

    private boolean isStillWorking() {
        return !taskQueue.isEmpty() || threadStateById.values().stream().allMatch(i -> i);
    }
}
