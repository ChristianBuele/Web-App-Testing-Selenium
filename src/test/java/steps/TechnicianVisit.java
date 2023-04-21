package steps;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import utils.actions;

public class TechnicianVisit extends actions{
    @When("^Select schedule$")
    public void selectDate(){
        By next= By.xpath("//*[@id='root']/div/main/section/section/div[2]/div/div/div[1]/div[1]/button[2]");
        Click(next);
        By schedules= By.xpath("//*[@id='root']/div/main/section/section/div[2]/div/div/div[1]/div[2]");
        selectSchedule(schedules);
    }
}
