package sauceDemo.userinterfaces.home.productos;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SauceLabsBackpack {

    public static final Target AÑADIR_ELEMENTO_SAUCE_LABS_BACKPACK =
            Target.the("Añadir elemento Sauce Labs Backpack")
                    .located(By.id("add-to-cart-sauce-labs-backpack"));
}
