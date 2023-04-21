package sauceDemo.userinterfaces.autenticacion;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class Login extends PageObject {

    public static final Target INGRESO_EMAIL =
            Target.the("Ingresar Email")
                    .located(By.id("user-name"));

    public static final Target INGRESO_CONTRASEÑA =
            Target.the("Ingresar Contraseña")
                    .located(By.id("password"));

    public static final Target BTN_LOGIN =
            Target.the("Boton Login")
                    .located(By.id("login-button"));

    public static final Target CARTEL_CREDENCIAL_ERRONEO =
            Target.the("Cartel de credenciales erroneas")
                    .located(By.xpath("//div[@class='error-message-container error']"));



}
