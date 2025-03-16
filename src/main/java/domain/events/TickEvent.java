package domain.events;

public class TickEvent extends DefaultEventImpl<TickEvent> {
    private float elapsed;

    public TickEvent() {
        super();
    }

    public void onElapsedChanged(float new_elapsed) {
        this.elapsed = new_elapsed;
        super.notifyObservers();
    }

    public float getElapsed() {
        return elapsed;
    }
}
