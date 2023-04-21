package sauceDemo.interactions.waits;

import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickInvisible implements IsSilent, Interaction {

  private Target element;

  public ClickInvisible(Target elemento) {
    this.element = element;
  }

  public static ClickInvisible inInvisbleClick(Target element) {
    return instrumented(ClickInvisible.class, element);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Click.on(element));

  }
}
