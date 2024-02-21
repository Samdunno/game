
/**Class for a cooldown. */
public class Cooldown {
    private long start;
    private int timerLength;
    /**
     * Create a new cooldown that lasts for some seconds.
     * @param seconds
     */
    public Cooldown(int seconds) {
        timerLength = seconds;
    }
    /**Starts the timer. */
    public void startTimer() {
        start = System.currentTimeMillis();
    }
    /**
     * Checks if the time is up.
     * @return
     */
    public boolean timeUp() {
        return System.currentTimeMillis() - start > timerLength * 1000;
    }
}
