package domain.events;

import java.time.Duration;

public class TickEvent extends DefaultEventImpl<TickEvent> {
    private Duration elapsed;

    public TickEvent() {
        super();
    }

    public void onElapsed(Duration elapsedMillis) {
        this.elapsed = elapsedMillis;
        super.notifyObservers();
    }

    public Duration getElapsed() {
        return elapsed;
    }
}
