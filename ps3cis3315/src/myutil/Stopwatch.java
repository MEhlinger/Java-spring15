package myutil;

/**
 *
 * Stopwatch class provides calls System.currentTimeMillis,
 and compares those calls to get elapsed time periods.
 *
 * @author Marshall Ehlinger
 */
public class Stopwatch {
    
    private long startWatchTime, stopWatchTime;
    
    public void setStopWatch() {
        // Sets startTime to currentTimeMillis to begin counting up time
        startWatchTime = System.currentTimeMillis();
    }
    
    public long getStopWatch() {
        // Sets stop time for timed period and returns difference / elapsed time
        stopWatchTime = System.currentTimeMillis();
        return stopWatchTime - startWatchTime;
    }
    
}
