package utils;

import org.openqa.selenium.By;
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
    
    public void writeText (By elementLocation, String text) {
        webDriver.getDriver().findElement(elementLocation).sendKeys(text);
    }

    public void Click(By elementLocator) {
        webDriver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
        WebElement element=webDriver.getDriver().findElement(elementLocator);
        element.click();
    }

    public void clicOnItemName(By element, String name){
        webDriver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
        List<WebElement> items=webDriver.getDriver().findElement(element).findElements(By.xpath("./child::*"));
        for (WebElement webElement : items) {
            System.out.println(webElement.getText());
            webElement.findElement(By.xpath("//*[contains(text(), '" + name + "')]")).click();
            break;
        }
    }
    public void clicOnItemPosition(By element, int name){
        webDriver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
        List<WebElement> items=webDriver.getDriver().findElement(element).findElements(By.xpath("./child::*"));
        items.get(name).click();
    }
    public void MultipleClick(By elementLocator, int number) {
        webDriver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
        List<WebElement> items=webDriver.getDriver().findElement(elementLocator).findElements(By.xpath("./child::*"));
        if(items.size()<number){
            number=items.size();
        }
        for (int i = 0; i < number; i++) {
            items.get(i).click();
        }
    }

    public Boolean isElementPresent(By elementLocator) {
        try {
            webDriver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
            webDriver.getDriver().findElement(elementLocator);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public String ReadText(By elementLocator) {
        webDriver.getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS) ;
        return webDriver.getDriver().findElement(elementLocator).getText();
    }

    public void SelectText(By elementLocator, String NameLocator) {
        WebElement identifier = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        identifier.click();
        Select select = new Select(identifier);
        select.selectByVisibleText(NameLocator);

    }

    
    public void Signature(By elementLocator) {
    WebElement text = webDriver.getDriver().findElement(elementLocator);
        Actions actionBuilder = new Actions(webDriver.getDriver());
         Action drawAction = actionBuilder.moveToElement(text,660,96)
            .click()
            .clickAndHold(text)
            .moveByOffset(120, 120)
            .moveByOffset(60,70)
            .moveByOffset(-140,-140)
            .release(text)
            .build();
      drawAction.perform();
      }
    public void Enter(By element){
        webDriver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
        webDriver.getDriver().findElement(element).sendKeys(Keys.RETURN);
    }

   
    
}