package sauceDemo.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "classpath:features/agregadoDeProductosAlCarrito.feature"
        ,glue = "classpath:sauceDemo/stepDefinitions"
        //,tags = {"@"}
        ,snippets = SnippetType.CAMELCASE)
public class AgregadoDeProductosAlCarritoRunner {
}
