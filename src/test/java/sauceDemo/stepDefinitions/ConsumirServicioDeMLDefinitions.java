package sauceDemo.stepDefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import sauceDemo.endPoint.ApiEndPoint;
import sauceDemo.endPoint.ConsumirApiDeTipoGet;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.*;

public class ConsumirServicioDeMLDefinitions {

    private EnvironmentVariables envVars;
    private Actor analista;

    @Before
    public void configurarElEscenario(){
        String baseUrl = envVars.optionalProperty("restapi.baseurl").orElseThrow(IllegalArgumentException::new);
        SerenityRest.useRelaxedHTTPSValidation("TLS");
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Analista");
        analista = Actor.named("Matias").whoCan(CallAnApi.at(baseUrl));
    }


    @Dado("^el Analista desea consumir el servicio llamado '(.*)' '(.*)'$")
    public void elAnalistaDeseaConsumirElServicioLlamadoMenu(String arg1,String arg2) {
        ConsumirApiDeTipoGet.tipoGET(ApiEndPoint.obtenerEndPoint((arg1)+ "/" + (arg2)),analista);

    }

    @Entonces("^su status debe ser '(.*)' y visualizar la pagina de '(.*)'$")
    public void suStatusDebeSerYVisualizarLaPaginaDeDepartments(int codigo, String arg2) {
        analista.should(
                seeThatResponse("El usuario interactuo correctamente",
                        response -> response
                                .statusCode(codigo)
                                .body(containsString(arg2))
                                .log()
                                .all()
                )
        );
    }
}
