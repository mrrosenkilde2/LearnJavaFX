package domain.events;


import domain.Game;

public class EventManager {
    private final IncomeClickEvent clickEvent;
    private final TickEvent tickEvent;
    private final GameCurrencyChangedEvent baseCurrencyChangedEvent;
    private final GameCurrencyChangedEvent clickValueChangedEvent;
    public EventManager(Game game){
        this.clickEvent = new IncomeClickEvent();
        tickEvent = new TickEvent();
        baseCurrencyChangedEvent = new GameCurrencyChangedEvent(game.getBaseCurrency());
        clickValueChangedEvent = new GameCurrencyChangedEvent(game.getClickValue());
	}

    public IncomeClickEvent getIncomeClickEvent() { return clickEvent; }
    public TickEvent getTickEvent() {
        return tickEvent;
    }
    public GameCurrencyChangedEvent getBaseCurrencyChangedEvent() { return baseCurrencyChangedEvent; }
    public GameCurrencyChangedEvent getClickValueChangedEvent() { return clickValueChangedEvent; }
}
