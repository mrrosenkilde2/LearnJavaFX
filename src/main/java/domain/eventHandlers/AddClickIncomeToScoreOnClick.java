package domain.eventHandlers;

import domain.GameCurrency;
import domain.events.IncomeClickEvent;
import util.Observer;

public class AddClickIncomeToScoreOnClick implements Observer<IncomeClickEvent> {
    private final GameCurrency baseCurrency;
    private final GameCurrency clickValue;

    public AddClickIncomeToScoreOnClick(GameCurrency baseCurrency, GameCurrency clickValue) {
        this.baseCurrency = baseCurrency;
        this.clickValue = clickValue;
    }

    @Override
    public void handleChange(IncomeClickEvent observable) {
        baseCurrency.add(clickValue);
    }
}
