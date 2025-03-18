package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

public class GeneratorTest
{
  private Game game;
  @BeforeEach
  void setup(){
	this.game = Game.freshGame();
	this.game.getGenerators().add(
		new Generator(GameCurrency.One(), Duration.ofSeconds(1))
	);
	assertEquals(GameCurrency.Zero(), this.game.getBaseCurrency());
  }

  @Test
  void generatorsIncreasesScoreWithAmountWhenElapsedTimeHasElapsed(){
	this.game.getEventManager().getTickEvent().onElapsed(Duration.ofSeconds(1));
	assertEquals(1, this.game.getBaseCurrency().asInt());
  }
  @Test
  void GeneratorsDoesNotIncreaseScoreWithAmountWhenElapsedTimeIsLessThenTheSpecifiedTimeOnTheGenerator(){
	this.game.getEventManager().getTickEvent().onElapsed(Duration.ofMillis(999));
	assertEquals(0, this.game.getBaseCurrency().asInt());
  }
  @Test
  void GeneratorsGenerateIncomeMultipleTimesIfAlotOfTimeHasPassed(){
	this.game.getEventManager().getTickEvent().onElapsed(Duration.ofMinutes(1));
	assertEquals(60, this.game.getBaseCurrency().asInt());
  }
  @Test
  void GameGeneratesIncomeFromAllGenerators(){
	this.game.getGenerators().clear();
	for(int i = 0; i < 5; i++)
	  this.game.getGenerators().add(
		  new Generator(GameCurrency.One(), Duration.ofSeconds(1))
	  );
	this.game.getEventManager().getTickEvent().onElapsed(Duration.ofSeconds(1));
	assertEquals(5, game.getBaseCurrency().asInt());
  }
}
