package util;

import java.time.Duration;

public class Stopwatch {
    private long startTime;
    private long endTime;
    private boolean isRunning;

    public void start() {
        if (isRunning) {
            throw new IllegalStateException("StopWatch is already running.");
        }
        startTime = System.nanoTime();
        isRunning = true;
    }

    public void stop() {
        if (!isRunning) {
            throw new IllegalStateException("StopWatch is not running.");
        }
        endTime = System.nanoTime();
        isRunning = false;
    }

    public void reset() {
        startTime = 0;
        endTime = 0;
        isRunning = false;
    }

    private long getElapsedTimeNanos() {
        if (isRunning) {
            return System.nanoTime() - startTime;
        } else {
            return endTime - startTime;
        }
    }

    public Duration getElapsed() {
        return Duration.ofNanos(getElapsedTimeNanos());
    }

}
