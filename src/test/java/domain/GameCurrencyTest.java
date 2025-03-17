package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameCurrencyTest
{
  @Test
  void isEqualToItself(){
    GameCurrency currency = GameCurrency.One();
    assertTrue(currency.equals(currency));
  }
  @Test
  void isEqualToAnotherCurrencyWithSameValue(){
    GameCurrency currency = GameCurrency.One();
    GameCurrency other = GameCurrency.fromInt(1);
    assertTrue(currency.equals(other));
  }
  @Test
  public void OneIsDifferentFromZero() {
    assertTrue(GameCurrency.One().isDifferentFrom(GameCurrency.Zero()));
  }
}
