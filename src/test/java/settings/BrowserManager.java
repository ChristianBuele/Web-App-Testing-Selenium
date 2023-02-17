package settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserManager {
    WebDriver webDriver;
    private static BrowserManager instance = null;

    private BrowserManager() {
        System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    public static BrowserManager Instance() {
        if (instance == null) {
            instance = new BrowserManager();
        }
        return instance;
    }

    public WebDriver getDriver()
    {
        return webDriver;
    }
}
