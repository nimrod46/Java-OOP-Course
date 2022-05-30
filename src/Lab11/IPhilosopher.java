package Lab11;

/**
 * Tel Hai College
 *
 * @author Ron Sivan (ronny.sivan@gmail.com)
 * @date 18 May 2014 20:50:44
 */

/**
 * Philosopher - interface for the Dining Philosophers exercise
 *
 * The problem: 
 * Five philosophers sit around a round table at equal distance from each other. 
 * They spend their time doing one of two things: think, or eat spaghetti. 
 * Between every two philosophers there is a fork. One requires two forks in order to eat
 * spaghetti, so each philosopher who wishes to eat must first obtain the forks on both 
 * his sides. While he is eating, neither of his neighbors can eat.
 *
 * The system: The setup consists of several classes:
 *
 * 1. This interface
 *
 * 2. A class implementing this interface which needs to be written as part of the
 *    exercise. This class must simulate the behavior of the Dining Philosophers 
 *    in a way that avoids deadlock. Deadlock may occur if each of the five 
 *    philosophers holds one fork, waiting for another to become available, 
 *    which will never happen. Five instances of that class are made to run 
 *    concurrently.
 *
 * 3. class Fork which implements the behavior of a fork. Basically, a fork is either 
 *    free or is in the hands of a philosopher.
 *
 * 4. class RandomSleep which implements a method named sleep() which may be used to
 *    cause a thread to suspend for a random period of time between 0 and 8 milliseconds.
 *    (The reason that this is not done using the standard Math.random() and Thread.sleep()
 *    methods is because Math.random() is a synchronized method which may interfere with 
 *    the behavior of this exercise. See the implementation of RandomSleep to see how it
 *    avoids this difficulty.)  
 *
 * 5. class Monitor which is a little GUI widget displaying the state of the philosophers
 *    in real time. Each philosopher is depicted by a small circle, that is empty when 
 *    the corresponding philosopher is thinking, and red when he is eating. This class 
 *    does not interfere in the way the philosophers work, it only displays their states.
 *    It also indicates the total number of think-eat cycles the philosophers have 
 *    collectively gone through. It uses the methods of this interface to query the state 
 *    of the system.   
 *
 * 6. class Main which runs the whole thing.
 */
public interface IPhilosopher extends Runnable {
    /**
     * PHIL_CNT - number of philosophers
     */
    public static final int PHIL_CNT = 5;


    /**
     * isEating - a predicate returning the philosopher's state
     *
     * @return true if the philosopher is eating, false if he is thinking
     */
    public boolean isEating();


    /**
     * getPlace - reveals the position of the philosopher around the table
     *
     * @return 1 - 5, depending on where the philosopher is sitting
     */
    public int getPlace();


    /**
     * getCount - reveals the number of eat-think cycles the philosopher has gone through
     *
     * @return the number of times the philosopher has changed from eating to thinking and back.
     */
    public int getCount();

}
