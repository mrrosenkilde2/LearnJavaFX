package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameCurrencyTest
{
  @Test
  void isEqualToItself(){
    GameCurrency currency = GameCurrency.One();
    assertEquals(currency, currency);
  }
  @Test
  void isEqualToAnotherCurrencyWithSameValue(){
    GameCurrency currency = GameCurrency.One();
    GameCurrency other = GameCurrency.fromInt(1);
    assertEquals(currency, other);
  }
  @Test
  public void OneIsDifferentFromZero() {
    assertTrue(GameCurrency.One().isDifferentFrom(GameCurrency.Zero()));
  }
}
