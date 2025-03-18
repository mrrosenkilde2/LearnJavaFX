package domain;

import domain.events.PostTickEvent;
import util.Runnable;
import util.Stopwatch;

import java.time.Duration;
import java.util.concurrent.*;

public class GameClock {
    private final ScheduledExecutorService scheduler;
    private ScheduledFuture<?> future;
    private final Runnable<Duration> event;
    private final Stopwatch stopwatch;
    private final long intervalMillis;
    private final GameState stateRef;
    private final PostTickEvent postTickEvent;

    public GameClock(Runnable<Duration> event, long intervalMillis, GameState stateRef) {
        this.event = event;
        this.intervalMillis = intervalMillis;
        this.stateRef = stateRef;
        scheduler = Executors.newSingleThreadScheduledExecutor();
        stopwatch = new Stopwatch();
        postTickEvent = new PostTickEvent();
    }
    public void start(){
        stopwatch.start();
        future = scheduler.scheduleAtFixedRate(
                this::tick, 0, intervalMillis, TimeUnit.MILLISECONDS
        );
    }
    public void stop() {
        if(future != null)
            future.cancel(true);
        stopwatch.stop();
    }

    private void tick() {
        event.run(stopwatch.getElapsed());
        postTickEvent.notifyObserversGameStateChanged(stateRef);
    }
    public PostTickEvent getPostTickEvent() { return postTickEvent; }
}
