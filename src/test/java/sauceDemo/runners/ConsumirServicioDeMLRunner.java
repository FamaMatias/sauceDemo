package sauceDemo.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/consumirServicioDeML.feature",
        glue = "sauceDemo/stepDefinitions",
        //tags = {"@"},
        snippets = SnippetType.CAMELCASE)
public class ConsumirServicioDeMLRunner {
}
