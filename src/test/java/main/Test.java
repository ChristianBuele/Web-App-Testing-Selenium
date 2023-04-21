package main;
import org.junit.runner.RunWith;
 
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features={
        "src/test/resources/features/TV"
    },
    glue = {
        "steps"
    }
)
public class Test {
    
}
