package steps;

import org.openqa.selenium.By;

import io.cucumber.java.en.When;
import utils.actions;

public class FeasibilityArea extends actions{
    
    @When("^Select sugestion \"([^\"]*)\" from id \"([^\"]*)\"$")
    public void focusOn(String text,String id) throws Throwable{
        By element=By.id(id);
        selectSugestion(element, text);
    }

}
