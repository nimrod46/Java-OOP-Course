/**
 * Tel Hai College
 *
 * @author Ron Sivan (ronny.sivan@gmail.com)
 * @date 19 May 2014 07:03:37
 */

package Lab11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lab11Test {
    /**
     * main -
     *
     * @param args
     */
    public static void main(String[] args) {
        /*
         * Create an array of Fork
         */
        List<Fork> forks = new ArrayList<Fork>();
        for (int i = 0; i < IPhilosopher.PHIL_CNT; i++)
            forks.add(new Fork());


        /*
         * create the philosophers and start them running
         */
        List<IPhilosopher> philos = new ArrayList<IPhilosopher>();
        for (int i = 1; i <= IPhilosopher.PHIL_CNT; i++)
            philos.add(new Philosopher(i, forks, 24, new ReentrantLock()));

        for (IPhilosopher ph : philos)
            new Thread(ph).start();

        /*
         * start the monitor thread to display the system state
         */
        new Thread(new Monitor(philos, forks)).start();
    }
}
