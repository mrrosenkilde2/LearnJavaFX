package domain;

import java.time.Duration;

public class Generator
{
  private final GameCurrency generatesAmount;
  private final Duration whenElapsed;
  private Duration elapsed;

  public Generator(GameCurrency generatesAmount, Duration whenElapsed){
	this.generatesAmount = generatesAmount;
	this.whenElapsed = whenElapsed;
	this.elapsed = Duration.ZERO;
  }
  public void incrementElapsed(Duration with) {
	setElapsed(elapsed.plus(with));
  }

  public GameCurrency getGeneratesAmount() { return generatesAmount; }
  public Duration getWhenElapsed() { return whenElapsed; }
  public Duration getElapsed() { return this.elapsed; }
  public void setElapsed(Duration elapsed) { this.elapsed = elapsed; }
}
