package sauceDemo.userinterfaces.home;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Home extends PageObject {


    public static final Target VALIDACION_INGRESO =
            Target.the("Visualizacion de Tarjetas")
                    .located(By.xpath("//div[@class='app_logo']"));

    public static final Target TITULO_ELEMENTO_SAUCE_LABS_BACKPACK =
            Target.the("Elemento Sauce Labs Backpack")
                    .located(By.xpath("(//div[@class='inventory_item_name'])[1]"));

    public static final Target BTN_ELEMENTO_SAUCE_LABS_BACKPACK =
            Target.the("Boton elemento Sauce Labs Backpack")
                    .located(By.id("add-to-cart-sauce-labs-backpack"));

    public static final Target BTN_CARRITO =
            Target.the("Boton Carrito de Compra")
                    .located(By.xpath("//a[@class='shopping_cart_link']"));


    public static final Target VALIDACION_TEXTO_REMOVE =
            Target.the("Validacion de texto remove")
                    .located(By.xpath("//button[@name='remove-sauce-labs-backpack']"));

}
