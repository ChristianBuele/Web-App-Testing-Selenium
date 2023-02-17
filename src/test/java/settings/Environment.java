package settings;

import java.util.concurrent.TimeUnit;

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

    /**
     * Closed navigation.
     **/
    public void ClosedNavigation() {
        webDriver.getDriver().manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        webDriver.getDriver().manage().deleteAllCookies();
        webDriver.getDriver().close();

    }
}
