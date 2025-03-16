package domain;

import domain.events.EventManager;

import java.util.Optional;


public class Game {
    private final GameState state;
    private final EventManager eventManager;
    private final GameClock clock;

    public Game(GameState state, Optional<Long> clockSpeedMillis){
        this.state = state;
        this.eventManager = new EventManager();
        clock = new GameClock(
                eventManager.getTickEvent()::onElapsedChanged,
                clockSpeedMillis.orElse(20L),
                state
        );
    }

    public GameCurrency getBaseCurrency() {
        return state.baseCurrency();
    }

    public GameCurrency getClickValue() {
        return state.clickValue();
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public GameClock getClock() {
        return clock;
    }
}
