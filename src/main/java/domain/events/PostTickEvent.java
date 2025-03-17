package domain.events;

import domain.GameCurrency;
import domain.GameState;

public class PostTickEvent extends DefaultEventImpl<PostTickEvent>{
    private GameState previousState;
    private GameState currentState;

    public PostTickEvent(){
        previousState = new GameState(new GameCurrency(), new GameCurrency());
    }

    public void notifyObserversGameStateChanged(GameState newGameState){
        this.currentState = newGameState;
        super.notifyObservers();
        setPreviousState(newGameState);
    }

    public GameState getPreviousState() {
        return previousState;
    }

    public void setPreviousState(GameState previousState) {
        this.previousState = previousState.deepCopy();
    }

    public GameState getCurrentState() {
        return currentState;
    }

    public boolean baseCurrencyChanged(){
        return this.getCurrentState().baseCurrencyIsDifferentFrom(this.getPreviousState().baseCurrency());
    }
    public boolean clickValueChanged() {
        return this.getCurrentState().clickValueIsDifferentFrom(this.getPreviousState().clickValue());
    }
}
