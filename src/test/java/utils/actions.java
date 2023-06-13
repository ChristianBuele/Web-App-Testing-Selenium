package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import settings.BrowserManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class actions {
    BrowserManager webDriver = BrowserManager.Instance();
    WebDriverWait wait = new WebDriverWait(webDriver.getDriver(), 15);

    public void writeText(By elementLocation, String text) {
        webDriver.getDriver().findElement(elementLocation).sendKeys(text);
    }

    public void openConsoleDevelop() {
        Actions actions = new Actions(webDriver.getDriver());
        actions.sendKeys(Keys.F12).build().perform();
    }

    public void waitForServices() {
        WebDriverWait wait = new WebDriverWait(webDriver.getDriver(), 10);
        wait.until(webDriver -> {
            // Verifica si todos los servicios han terminado de cargar
            return ((JavascriptExecutor) webDriver).executeScript("return jQuery.active == 0");
        });
    }

    public void Click(By elementLocator) {
        webDriver.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement element = webDriver.getDriver().findElement(elementLocator);
        element.click();
    }

    public void ClickTest(By elementLocator) {
        webDriver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement element = webDriver.getDriver().findElement(elementLocator);
        element.click();
    }

    public void clicOnItemName(By element, String name) {
        webDriver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        List<WebElement> items = webDriver.getDriver().findElement(element).findElements(By.xpath("./child::*"));
        for (WebElement webElement : items) {
            System.out.println(webElement.getText());
            webElement.findElement(By.xpath("//*[contains(text(), '" + name + "')]")).click();
            break;
        }
    }

    public void clicOnItemPosition(By element, int name) {
        webDriver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        List<WebElement> items = webDriver.getDriver().findElement(element).findElements(By.xpath("./child::*"));
        items.get(name).click();
    }

    public boolean existElement(By element) {
        webDriver.getDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        if (webDriver.getDriver().findElement(element).isDisplayed()) {
            return true;
        }
        return false;
    }

    public void MultipleClick(By elementLocator, int number) {
        webDriver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        List<WebElement> items = webDriver.getDriver().findElement(elementLocator).findElements(By.xpath("./child::*"));
        if (items.size() < number) {
            number = items.size();
        }
        for (int i = 0; i < number; i++) {
            items.get(i).click();
        }
    }

    public Boolean isElementPresent(By elementLocator) {
        try {
            webDriver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            webDriver.getDriver().findElement(elementLocator);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public String ReadText(By elementLocator) {
        webDriver.getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        return webDriver.getDriver().findElement(elementLocator).getText();
    }

    public void SelectText(By elementLocator, String NameLocator) {
        WebElement identifier = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        identifier.click();
        Select select = new Select(identifier);
        select.selectByVisibleText(NameLocator);

    }

    public void selectSchedule(By element) {
        webDriver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        List<WebElement> items = webDriver.getDriver().findElement(element).findElements(By.xpath("./child::*"));
        System.out.println("Se realiza la busqueda de shecdules");
        if (items.isEmpty() == false) {
            System.out.println("Se hace click");
            System.out.println(items.get(0).getText());
            items.get(0).click();
        }
    }

    public void Signature(By elementLocator) {
        WebElement text = webDriver.getDriver().findElement(elementLocator);
        Actions actionBuilder = new Actions(webDriver.getDriver());
        Action drawAction = actionBuilder.moveToElement(text, 660, 96)
                .click()
                .clickAndHold(text)
                .moveByOffset(120, 120)
                .moveByOffset(60, 70)
                .moveByOffset(-140, -140)
                .release(text)
                .build();
        drawAction.perform();
    }

    public void Enter(By element) {
        webDriver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.getDriver().findElement(element).sendKeys(Keys.RETURN);
    }

    public void selectSugestion(By element, String text) {
        WebElement input = webDriver.getDriver().findElement(element);
        input.sendKeys(text);
        WebDriverWait wait = new WebDriverWait(webDriver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address.streetName-listbox")));
        System.out.println("Buscando la sugerencia");
        // Selecciona la primera sugerencia
        input.sendKeys(Keys.ARROW_DOWN);
        input.sendKeys(Keys.ENTER);
    }
}
