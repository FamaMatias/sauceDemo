package sauceDemo.questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import sauceDemo.interactions.waits.WaitElement;

public class ValidarElementoLista implements Question<Boolean> {
	Target element;

    public ValidarElementoLista(Target element) {
        this.element = element;
    }

    public static ValidarElementoLista esVisible(Target element) {
        return new ValidarElementoLista(element);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
    	actor.attemptsTo(WaitElement.isVisible(element));
        boolean listaElementos = element.resolveAllFor(actor).get(0).isVisible();
        return listaElementos;
    }
}
