package domain.eventHandlers;

import domain.Generator;
import domain.events.TickEvent;
import util.Observer;

import java.time.Duration;
import java.util.List;

public class AddElapsedToGeneratorsOnTick implements Observer<TickEvent>
{
  private final List<Generator> generators;
  public final static int priority = 0;

  public AddElapsedToGeneratorsOnTick(List<Generator> generators){
	this.generators = generators;
  }

  @Override
  public void handleChange(TickEvent observable)
  {
	for(Generator generator : this.generators){
	  generator.incrementElapsed(observable.getElapsed());
	}
  }

  @Override
  public int getPriority(){
	return AddElapsedToGeneratorsOnTick.priority;
  }
}
