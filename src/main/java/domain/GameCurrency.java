package domain;

import java.math.BigDecimal;

public class GameCurrency {
    public static GameCurrency One() { return new GameCurrency(BigDecimal.ONE); }
    public static GameCurrency Zero() { return new GameCurrency(); }
    private BigDecimal value;

    public GameCurrency() {
        this(BigDecimal.ZERO);
    }
    private GameCurrency(BigDecimal value) {
        this.value = value;
    }

    public static GameCurrency fromInt(int value) { return new GameCurrency(BigDecimal.valueOf(value)); }

    public void add(GameCurrency currency) {
        value = value.add(currency.value);
    }

    public int asInt() { return value.intValue(); }

    public String format() { return value.toString(); }

    public boolean equals(GameCurrency other){
        return value.equals(other.value);
    }

    public boolean isDifferentFrom(GameCurrency other){
        return !this.equals(other);
    }

    public GameCurrency deepCopy() {
        return new GameCurrency(value);
    }
}

