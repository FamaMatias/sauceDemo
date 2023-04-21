package sauceDemo.userinterfaces.carrito;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Carrito {

    public static final Target VALIDACION_SAUCE_LABS_BACKPACK =
            Target.the("Visualizacion de elemento Sauce labs Backpack")
                    .located(By.xpath("//div[@class='cart_item_label']"));



}
