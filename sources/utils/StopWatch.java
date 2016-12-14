package sources.utils;

import java.time.Duration;
import java.time.Instant;

/**
 * Created by mman on 10.12.16.
 */
public class StopWatch {
    private Instant startTime = null;
    private Duration elapsedTime = null;
    private boolean started = false;

    public void StopWatch() {
        reset();
    }

    public void start() {
        if (started) {
            return;
        }
        started = true;
        startTime = Instant.now();
    }

    public void stop() {
        if (!started) {
            return;
        }
        started = false;
        Instant stopTime = Instant.now();
        elapsedTime = Duration.between(startTime, stopTime);
    }

    public String getResult() {
        if (started) {
            Instant now = Instant.now();
            elapsedTime = Duration.between(startTime, now);
        }
        return elapsedTime.toString();
    }

    public void reset() {
        startTime = null;
        elapsedTime = null;
        started = false;
    }
}
