package domain;

public record GameState(
        GameCurrency baseCurrency,
        GameCurrency clickValue
){
    public GameState deepCopy(){
        return new GameState(
            this.baseCurrency.deepCopy(),
            this.clickValue.deepCopy()
        );
    }
    public boolean baseCurrencyIsDifferentFrom(GameCurrency other){
        return baseCurrency.isDifferentFrom(other);
    }

    public boolean clickValueIsDifferentFrom(GameCurrency gameCurrency) {
        return clickValue.isDifferentFrom(gameCurrency);
    }
}
