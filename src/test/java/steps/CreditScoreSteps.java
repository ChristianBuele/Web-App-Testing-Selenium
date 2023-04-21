package steps;

import org.jruby.RubyBoolean.True;
import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import utils.actions;

public class CreditScoreSteps extends actions{
    @Given("^Verify existing account \"([^\"]*)\"$")
    public void verifyExistingAccount(String option) throws Throwable {
        By element=By.xpath("//*[contains(text(), 'Do you want to use an existing account?')]");
        boolean exist=existElement(element);
        if(exist==true){
            By buttonloginXpBy= By.xpath("//*[contains(text(), '" + option + "')]");
            Click(buttonloginXpBy);
        }
    }
    
}
