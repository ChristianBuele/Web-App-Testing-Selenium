package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.actions;
import settings.Environment;
public class PruebaSteps extends actions {
    WebDriver driver;
    Environment env=new Environment();

    @Then("^OpenNewTab")
    public void OpenNewTab() throws Throwable {
        env.openNewTab();
    }
    @When("HelloWorld")
    public void HelloWorld() throws Throwable {
        System.out.println("Hello World");
    }
    @When("^Open Web Page")
    public void OpenWebPage() throws Throwable {
        env.openPage();
    }

}
