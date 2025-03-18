package domain.eventHandlers;

import domain.GameState;
import domain.Generator;
import domain.events.TickEvent;
import util.Observer;

import java.util.List;

public class ApplyGeneratorIncomeOnTick implements Observer<TickEvent>
{
  private final List<Generator> generators;
  private final GameState state;

  public ApplyGeneratorIncomeOnTick(List<Generator> generators, GameState state) {
	this.generators = generators;
	this.state = state;
  }

  @Override
  public void handleChange(TickEvent observable)
  {
	for(Generator generator : generators){
	  this.state.baseCurrency().add(
		generator.getGeneratesAmount().multiply(
			generator.getElapsed().dividedBy(generator.getWhenElapsed())
		)
	  );
	}
  }

  @Override
  public int getPriority()
  {
	return AddElapsedToGeneratorsOnTick.priority + 1; //runs after AddElapsedToGeneratorsOnTick
  }
}
