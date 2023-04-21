package sauceDemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static sauceDemo.userinterfaces.home.Home.*;

public class SeleccionarSauceLabsBackpackPorTituloTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(TITULO_ELEMENTO_SAUCE_LABS_BACKPACK)
        );
    }
    public static SeleccionarSauceLabsBackpackPorTituloTask seleccionar() {

        return Tasks.instrumented(SeleccionarSauceLabsBackpackPorTituloTask.class);

    }
}
