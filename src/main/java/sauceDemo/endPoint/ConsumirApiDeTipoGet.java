package sauceDemo.endPoint;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ConsumirApiDeTipoGet {

    public static void tipoGET(String endPoint, Actor actor) {

        actor.attemptsTo(Get.resource(endPoint)
                .with(request -> request
                        .header("Content-Type", "application/json")
                        .relaxedHTTPSValidation("TLS")
                        .log().all()));
    }
}
