package domain.events;

import domain.GameCurrency;

public class GameCurrencyChangedEvent extends DefaultEventImpl<GameCurrencyChangedEvent>
{
  private final GameCurrency currency;

  public GameCurrencyChangedEvent(GameCurrency currency) {this.currency = currency;}

  public GameCurrency getCurrency()
  {
	return currency;
  }
}
