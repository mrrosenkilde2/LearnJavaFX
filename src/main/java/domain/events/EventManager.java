package domain.events;


public class EventManager {
    private final IncomeClickEvent clickEvent;
    private final TickEvent tickEvent;
    public EventManager(){
        this.clickEvent = new IncomeClickEvent();
        tickEvent = new TickEvent();
    }

    public IncomeClickEvent getIncomeClickEvent() {
        return clickEvent;
    }

    public TickEvent getTickEvent() {
        return tickEvent;
    }
}
