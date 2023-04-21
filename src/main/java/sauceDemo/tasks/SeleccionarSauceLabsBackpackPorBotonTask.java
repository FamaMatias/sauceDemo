package sauceDemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static sauceDemo.userinterfaces.home.Home.BTN_CARRITO;
import static sauceDemo.userinterfaces.home.Home.BTN_ELEMENTO_SAUCE_LABS_BACKPACK;

public class SeleccionarSauceLabsBackpackPorBotonTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_ELEMENTO_SAUCE_LABS_BACKPACK)
        );
    }

    public static SeleccionarSauceLabsBackpackPorBotonTask seleccionar(){
        return Tasks.instrumented(SeleccionarSauceLabsBackpackPorBotonTask.class);
    }
}
