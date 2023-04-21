package settings;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
public class Environment {
    BrowserManager webDriver = BrowserManager.Instance();
    private String Step;
    private String StepB;
    private String baseURL;
    

    /**
     * Constructor Class.
     * Envronment test.
     * }
     **/

    public Environment() {
        StepB = PropertyManager.getLoadData("StepQA");
        if (StepB.equals("QA")) {
            baseURL = PropertyManager.getLoadData("urlQA");
        }
    }

    public void NavigationTo() {
        webDriver.getDriver().get(baseURL);
        webDriver.getDriver().manage().window().maximize();
        webDriver.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    public void openNewTab(){
    //    webDriver.getDriver().findElement(By.tagName("body")).sendKeys();
       ((JavascriptExecutor)webDriver.getDriver()).executeScript("window.open()");
       // Cambiar el enfoque al nuevo tab
    ArrayList<String> tabs = new ArrayList<String>(webDriver.getDriver().getWindowHandles());
    webDriver.getDriver().switchTo().window(tabs.get(1));
    }
    public void openPage(){
        webDriver.getDriver().get(baseURL);
    }

    /**
     * Closed navigation.
     **/
    public void ClosedNavigation() {
        webDriver.getDriver().manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        webDriver.getDriver().manage().deleteAllCookies();
        webDriver.getDriver().close();

    }
}
