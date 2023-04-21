package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import utils.actions;

public class LoginSteps extends actions {
    @When("^Click on Sing In button$")
    public void isclick() throws Throwable {
        By buttonloginXpBy= By.xpath("//*[@id='kc-login']");
        Click(buttonloginXpBy);
    }
}
