package sauceDemo.stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import sauceDemo.questions.ValidarElemento;
import sauceDemo.questions.ValidateInformationText;
import sauceDemo.tasks.AñadirProductoAlCarritoTask;
import sauceDemo.tasks.CompletarFormularioLoginTask;
import sauceDemo.tasks.SeleccionarSauceLabsBackpackPorBotonTask;
import sauceDemo.tasks.SeleccionarSauceLabsBackpackPorTituloTask;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static sauceDemo.userinterfaces.carrito.Carrito.VALIDACION_SAUCE_LABS_BACKPACK;
import static sauceDemo.userinterfaces.home.Home.VALIDACION_INGRESO;
import static sauceDemo.userinterfaces.home.Home.VALIDACION_TEXTO_REMOVE;

public class AgregadoDeProductosAlCarritoDefinitions {

    @Before
    public void initScenario(Scenario scenario) {
        OnStage.setTheStage(new OnlineCast());
    }


    @Cuando("^Añado el producto Sauce Labs Backpack con el boton al carrito$")
    public void añadoElProductoSauceLabsBackpackConElBotonAlCarrito() {
        theActorInTheSpotlight().attemptsTo(SeleccionarSauceLabsBackpackPorBotonTask.seleccionar());
    }

    @Entonces("^Se visualiza la palabra (.*) en color rojo$")
    public void seVisualizaLaPalabraRemoveEnColorRojo(String arg) {
        theActorInTheSpotlight().should(seeThat(ValidateInformationText.validateInformationText(VALIDACION_TEXTO_REMOVE)));

    }

    @Cuando("^Selecciona Sauce Labs Backpack por titulo$")
    public void seleccionaSauceLabsBackpackPorTitulo() {
        theActorInTheSpotlight().attemptsTo(SeleccionarSauceLabsBackpackPorTituloTask.seleccionar());
    }

    @Cuando("^Añado producto Al carrito$")
    public void añadoProductoAlCarrito() {
        theActorInTheSpotlight().attemptsTo(AñadirProductoAlCarritoTask.elemento());
    }

    @Entonces("^debe visualizar el elemento correspondiente$")
    public void debeVisualizarElElementoCorrespondiente() {
        theActorInTheSpotlight().should(seeThat(ValidarElemento.esVisible(VALIDACION_SAUCE_LABS_BACKPACK)));

    }



}
