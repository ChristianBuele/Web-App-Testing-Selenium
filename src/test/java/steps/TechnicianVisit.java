package steps;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import utils.actions;

public class TechnicianVisit extends actions{
    @When("^Select schedule$")
    public void selectDate(){
        By schedules= By.xpath("/html/body/div/div/main/section/section/div[2]/div/div/div[1]/div/div[2]");
        selectSchedule(schedules);
    }
}
