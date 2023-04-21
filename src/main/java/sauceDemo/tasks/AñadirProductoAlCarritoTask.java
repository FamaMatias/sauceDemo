package sauceDemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static sauceDemo.userinterfaces.home.Home.BTN_CARRITO;
import static sauceDemo.userinterfaces.home.productos.SauceLabsBackpack.AÑADIR_ELEMENTO_SAUCE_LABS_BACKPACK;

public class AñadirProductoAlCarritoTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(AÑADIR_ELEMENTO_SAUCE_LABS_BACKPACK),
                Click.on(BTN_CARRITO)
        );
    }

    public static AñadirProductoAlCarritoTask elemento(){
        return Tasks.instrumented(AñadirProductoAlCarritoTask.class);
    }
}
