package sauceDemo.interactions.waits;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.type.Type;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class RealizarDobleDigitacion implements Interaction {

    private Target target;
    private String texto;
    private Boolean selecionarCampo = true;

    public RealizarDobleDigitacion(String texto) {
        this.texto = texto;
    }
    @Step("{0} digita el #texto sobre el #target dos veces")
    @Override
    public <T extends Actor> void performAs(T actor) {
        if (selecionarCampo) {
            actor.attemptsTo(Click.on(target));
        }
        actor.attemptsTo((Performable) Type.theValue(texto + "\n" + texto + "\n"));
    }
    public static RealizarDobleDigitacion delTexto(String texto) {
        return Tasks.instrumented(RealizarDobleDigitacion.class, texto);
    }
    public RealizarDobleDigitacion en(Target target) {
        this.target = target;
        return this;
    }
    public RealizarDobleDigitacion sinSeleccionDeCampo() {
        selecionarCampo = false;
        return this;
    }
}