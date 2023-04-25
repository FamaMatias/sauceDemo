package sauceDemo.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/inicioDeSession.feature"
        ,glue = "classpath:sauceDemo/stepDefinitions"
        //,tags = {"@Test"}
        ,plugin = "pretty"
        ,snippets = SnippetType.CAMELCASE)
public class InicioDeSessionRunner {
}
