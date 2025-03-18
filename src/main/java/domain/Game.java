package domain;

import domain.eventHandlers.AddElapsedToGeneratorsOnTick;
import domain.eventHandlers.ApplyGeneratorIncomeOnTick;
import domain.events.EventManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Game {
    private final GameState state;
    private final EventManager eventManager;
    private final GameClock clock;
    private final List<Generator> generators;

    public Game(GameState state, EventManager events, GameClock clock, List<Generator> generatorList){
        this.state = state;
        this.eventManager = events;
        this.clock = clock;
	    this.generators = generatorList;
        this.eventManager.getTickEvent().addObserver(
            new AddElapsedToGeneratorsOnTick(this.generators)
        );
        this.eventManager.getTickEvent().addObserver(
            new ApplyGeneratorIncomeOnTick(this.generators, this.state)
        );
	}

    public static Game freshGame(){
        GameState state = new GameState(GameCurrency.Zero(), GameCurrency.One());
        EventManager events = new EventManager(state);
        return new Game(
            state,
            events,
            new GameClock(
                events.getTickEvent()::onElapsed,
                20L,
                state
            ),
            new ArrayList<>()
        );
    }

    public GameCurrency getBaseCurrency() { return state.baseCurrency(); }
    public GameCurrency getClickValue() {
        return state.clickValue();
    }
    public EventManager getEventManager() {
        return eventManager;
    }
    public GameClock getClock() { return clock; }
    public List<Generator> getGenerators() { return generators; }
}
