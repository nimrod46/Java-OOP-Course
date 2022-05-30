/**
 * Tel Hai College
 *
 * @author rsivan (ronny.sivan@gmail.com)
 * @date 25 May 2014 23:35:15
 */

package Lab11;

import java.util.Random;

/**
 * RandomSleep - implement a method which suspends its caller for a 
 *               random period of time between 0 and 8 milliseconds
 *
 */
public class RandomSleep {
    private final int[] millis;
    private final int[] nanos;

    private final int randlen;
    private int randix;

    /**
     * Constructor -
     *
     * @param seed - an integer used to both initialize the random number
     *               generator, so that instantiating the class with
     *               different seeds produces different delays.
     *               It also determines the number of saved random values,
     *               so that distinct instantiations have different cycles,
     *               further delaying the coincidence values from diffrent
     *               instances of the class.
     */
    public RandomSleep(int seed) {
        this.randlen = 100000 - seed;
        this.randix = 0;

        Random rand = new Random(seed);
        this.millis = new int[this.randlen];
        for (int i = 0; i < this.randlen; i++) {
            int r = rand.nextInt() % 100;
            this.millis[i] = r > 0 ? r : -r;
        }

        this.nanos = new int[this.randlen];
        for (int i = 0; i < this.randlen; i++) {
            int r = rand.nextInt() % 1000000;
            this.nanos[i] = r > 0 ? r : -r;
        }
    }

    public void sleep() {
        try {
            Thread.sleep(millis[randix], nanos[randix]);
            randix = (randix + 1) % randlen;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
