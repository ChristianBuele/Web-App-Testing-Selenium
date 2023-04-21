package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import settings.Environment;

public class FixedLineSteps {
    WebDriver driver;
    Environment login = new Environment();
    @Given("^Open Tab")
    public void openTab() throws Throwable {
        login.openNewTab();
    }
}
