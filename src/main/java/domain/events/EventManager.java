package domain.events;


import domain.Game;
import domain.GameState;
import domain.eventHandlers.AddElapsedToGeneratorsOnTick;

public class EventManager {
    private final IncomeClickEvent clickEvent;
    private final TickEvent tickEvent;
    private final GameCurrencyChangedEvent baseCurrencyChangedEvent;
    private final GameCurrencyChangedEvent clickValueChangedEvent;
    public EventManager(GameState game){
        this.clickEvent = new IncomeClickEvent();
        tickEvent = new TickEvent();
        baseCurrencyChangedEvent = new GameCurrencyChangedEvent(game.baseCurrency());
        clickValueChangedEvent = new GameCurrencyChangedEvent(game.clickValue());
	}

    public IncomeClickEvent getIncomeClickEvent() { return clickEvent; }
    public TickEvent getTickEvent() {
        return tickEvent;
    }
    public GameCurrencyChangedEvent getBaseCurrencyChangedEvent() { return baseCurrencyChangedEvent; }
    public GameCurrencyChangedEvent getClickValueChangedEvent() { return clickValueChangedEvent; }
}
