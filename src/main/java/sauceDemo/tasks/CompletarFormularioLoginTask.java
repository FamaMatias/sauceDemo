package sauceDemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import sauceDemo.models.Credencial;

import static sauceDemo.userinterfaces.autenticacion.Login.*;

public class CompletarFormularioLoginTask implements Task {

    Credencial credencial;

    public CompletarFormularioLoginTask(Credencial credencial){this.credencial =credencial;}

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(credencial.getUsername()).into(INGRESO_EMAIL),
                Enter.theValue(credencial.getPassword()).into(INGRESO_CONTRASEÑA),
                Click.on(BTN_LOGIN)
        );
    }
    public static CompletarFormularioLoginTask conDatos(Credencial credencial){
        return Tasks.instrumented(CompletarFormularioLoginTask.class,credencial);
    }
}
