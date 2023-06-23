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
import java.util.Random;
import java.util.Set;
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
        webDriver.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement schedulesItem = webDriver.getDriver().findElement(element);
        List<WebElement> schedules = schedulesItem.findElements(By.xpath("./*"));
        System.out.println("Existen " + schedules.size() + " horarios");
        // for each in schedules
        for (int i = 0; i <= schedules.size() - 1; ++i) {
            WebElement schedule = schedules.get(i);
            WebElement timeDiv = schedule.findElements(By.xpath("./*")).get(1);// para obtener el segundo div que tiene
                                                                               // los horarios
            List<WebElement> times = timeDiv.findElements(By.xpath("./*"));// slots de horarios
            System.out.println("con " + times.size() + " slots");
            if (times.size() > 0) {
                System.out.println("Existen horarios. Eligiendo ...");
                Random random = new Random();
                int randomIndex = random.nextInt(times.size());
                times.get(randomIndex).click();
                // salir del for
                break;
            }
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

    public void selectRandomElement(By element) {
        WebElement item = webDriver.getDriver().findElement(element);
        List<WebElement> items = item.findElements(By.xpath("./*"));
        int totalElements = items.size();
        Random random = new Random();
        int randomIndex = random.nextInt(totalElements);
        WebElement selectedPlan = items.get(randomIndex);
        WebElement name = selectedPlan.findElement(By.tagName("h2"));
        System.out.println("El plan elegido es " + name.getText());
        selectedPlan.click();
    }

    public String getText(By element) {
        webDriver.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        WebElement button = webDriver.getDriver().findElement(By.xpath("/html/body/div/div/main/div/div[2]/button[2]"));
        WebElement textElement = webDriver.getDriver().findElement(element);
        System.out.println(textElement);
        String number = textElement.getText().substring(textElement.getText().indexOf(":") + 1).trim();
        return number;
    }

    public void changeWindow() {
        Set<String> windowHandles = webDriver.getDriver().getWindowHandles();
        String currentWindowHandle = webDriver.getDriver().getWindowHandle();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                webDriver.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
        System.out.println("Título de la nueva pestaña: " + webDriver.getDriver().getTitle());

        // Continuar con las acciones adicionales en la nueva pestañ
    }

    public void returnWindow() {
        // Obtener el identificador de la ventana actual
        String currentWindowHandle = webDriver.getDriver().getWindowHandle();

        // Cerrar la pestaña actual
        webDriver.getDriver().close();

        // Cambiar el foco a la ventana anterior (si es necesario)
        Set<String> windowHandles = webDriver.getDriver().getWindowHandles();
        if (windowHandles.size() > 1) {
            // Obtener el identificador de la ventana anterior
            String previousWindowHandle = windowHandles.stream()
                    .filter(handle -> !handle.equals(currentWindowHandle))
                    .findFirst()
                    .orElse(null);

            if (previousWindowHandle != null) {
                webDriver.getDriver().switchTo().window(previousWindowHandle);
            }
        }
    }
}
