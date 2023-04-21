package sauceDemo.stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import sauceDemo.models.Credencial;
import sauceDemo.questions.ValidarElemento;
import sauceDemo.tasks.AbrirPaginaTask;
import sauceDemo.tasks.CompletarFormularioLoginTask;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getWebdriverManager;
import static sauceDemo.userinterfaces.autenticacion.Login.CARTEL_CREDENCIAL_ERRONEO;
import static sauceDemo.userinterfaces.home.Home.VALIDACION_INGRESO;

public class InicioDeSessionDefinitions {


    @Before
    public void initScenario(Scenario scenario) {
        OnStage.setTheStage(new OnlineCast());
    }
    @Dado("^El (.*) ingresa a la pagina de SauceDemo$")
    public void elUsuarioIngresaALaPaginaDeSauceDemo(String usuario) {
        theActorCalled(usuario).attemptsTo(AbrirPaginaTask.deSucedemo());
    }

    @Cuando("^Completa con los datos$")
    public void completaConLosDatos(List<Credencial> credenciales) {
        theActorInTheSpotlight().attemptsTo(CompletarFormularioLoginTask.conDatos(credenciales.get(0)));
    }

    @Entonces("^debe visualizar un la pagina correspondiente$")
    public void debeVisualizarUnLaPaginaCorrespondiente() {
        theActorInTheSpotlight().should(seeThat(ValidarElemento.esVisible(VALIDACION_INGRESO)));

    }

    @Entonces("^debe visualizar cartel en rojo indicando el error correspondiente$")
    public void debeVisualizarCartelEnRojoIndicandoElErrorCorrespondiente() {
        theActorInTheSpotlight().should(seeThat(ValidarElemento.esVisible(CARTEL_CREDENCIAL_ERRONEO)));

    }


}
