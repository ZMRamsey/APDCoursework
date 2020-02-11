package semaphore;

/**
 * Blocking bounded semaphores.
 * A bounded semaphore has an upper limit for its value as well as
 * the lower limit of zero.
 * A blocking bounded semaphore will not only sleep when a process tries
 * to decrease its value below its lower limit (zero), but also sleep if a
 * process attempts to increase its value beyond its upper limit - the acquire
 * and release methods become symmetric.
* 
 * @author Hugh Osborne
 * @version January 2020
 * 
 */
public class BlockingSemaphore implements SemaphoreInterface
{
    /**
     * This semaphore's name.
     */
    private String name;

    /**
     *     The upper limit for the value of this semaphore. The default is set to the largest integer.
     */
    private int limit = java.lang.Integer.MAX_VALUE;

    /**
     * The internal value of the semaphore.  Note: this <i>is</i> allowed to fall below
     * zero.  The additive inverse of a negative value is equivalent to the number of processes
     * sleeping on this semaphore due to attempts to acquire it when it has reached its minimum.
     * The internal value <i>is</i> allowed to exceed the value of
     * <tt>limit</tt> in this implementation of bounded semaphores.  The difference between the
     * semaphore's internal value and its limit indicates, if it is positive, the number of
     * processes sleeping on this semaphore due to attempts to release it when it has reached
     * its maximum.
     */
    private int value;
    
    /**
     * Initialise the semaphore.
     * @param name the name of this semaphore
     * @param initialValue the initial value for this semaphore
     * @param limit limit value for the semaphore
     * If the initial value is specified as being greater than the limit
     * the value will be initialised to the limit.
     *
     * @throws SemaphoreError if the initial value is negative, or greater than the limit.
     */
    public BlockingSemaphore(String name,int initialValue,int limit) throws SemaphoreError {
        if (initialValue < 0) {
            throw new SemaphoreError("A semaphore cannot have a negative intial value");
        }
        if (initialValue > limit) {
            throw new SemaphoreError("A bounded semaphore cannot have an initial value greater than its limiting value");
        }
        this.name = name;
        value = initialValue;
        this.limit = limit;
    }
    
    /**
     * Initialise the semaphore. Use the largest integer as the upper limit.
     * @param name the name of this semaphore
     * @param initialValue the initial value for this semaphore
     *
     * @throws SemaphoreError if the given initial value is negative.
     */
    public BlockingSemaphore(String name,int initialValue) throws SemaphoreError {
        this(name,initialValue,Integer.MAX_VALUE);
    }

    /**
     * Get the name of this semaphore.
     * @return the name of this semaphore
     */
    public String getName() {
        return name;
    }
    
    /**
     * Acquire this semaphore.
     * If the current thread:
     * <ul>
     *  <li>has its interrupted status set on entry to this method; or</li>
     *  <li>is interrupted while waiting for a permit,</li>
     * </ul>
     * then InterruptedException is thrown and the current thread's interrupted status is cleared.
     */
    public synchronized void poll() throws InterruptedException {
        value--; // decrease the (internal) value
        if (value < 0) { // if the value is less than zero the process trying to acquire
            // this semaphore must sleep
            System.out.println(Thread.currentThread().getName() + " is blocked on " + getName() + ".poll()");
            wait();
        }
        if (value >= limit) { // if the internal value was above the semaphore's upper limit before the decrease
            // then there was a process sleeping on this semaphore due to a call of release() - wake one of these processes
            notify();
        }
    }
    
    /**
     * Release this semaphore.
     *
     * @throws InterruptedException (for blocking bounded semaphores) The current thread was interrupted.
     * As this is an implementation of a blocking bounded semaphore, it may wait on a vote when it has
     *      reached its maximum value.  If it does, an InterruptedException could be raised, and the current thread's
     *      interrupted status cleared, if the current thread:
     *      <ul>
     *          <li>has its interrupted status set on entry to this method; or</li>
     *          <li>is interrupted while waiting for a permit,</li>
     *      </ul>
     */
    public synchronized void vote() throws InterruptedException {
        value++; // increase the (internal) value
        if (value > limit) { // if the value is greater than the semaphore's upper limit the process trying to release
            // this semaphore must sleep
            System.out.println(Thread.currentThread().getName() + " is blocked on " + getName() + ".vote()");
            wait();
        }
        if (value <= 0) { // if the internal value was below zero before the increase
            // then there was a process sleeping on this semaphore due to a call of acquire() - wake one of these processes
            notify();
        }
    }
}