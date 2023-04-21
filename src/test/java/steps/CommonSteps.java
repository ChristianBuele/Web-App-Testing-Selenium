package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import settings.Environment;
import utils.actions;
public class CommonSteps  extends actions{
    WebDriver driver;
    Environment login = new Environment();

    // @After
    // public void LogoutLiberty(){
    //     login.ClosedNavigation();
    // }
    @Given("^Start Navigator$")
    public void iAmOnTheAutomationPage() throws Throwable {
        login.NavigationTo();
    }

    @When("^Write \"([^\"]*)\" in text box with id \"([^\"]*)\"$")
    public void writeText(String text,String element){
        By textBy=By.id(element);
        writeText(textBy,text);
    }

    
    @When("^Click Custom \"([^\"]*)\" option$")
    public void chooseMarket(String path) throws Throwable {
        By marketBy= By.xpath(path);
        Click(marketBy);
    }

    @When("^Choose a \"([^\"]*)\" option$")
    public void chooseACustomOption(String optionName) throws Throwable {
        System.out.println("Buscando "+optionName);
        By optionBy = By.xpath("//*[contains(text(), '" + optionName + "')]");
        Click(optionBy);
        System.out.println("Encontrado "+optionName);
    }

    @When("^Select \"([^\"]*)\" from selectId \"([^\"]*)\"")
    public void selectOption(String optionName,String element){
        By select=By.id(element);
        SelectText(select,optionName);
    }
    @When("^Select \"([^\"]*)\" radio button")
    public void selectRadioButton(String id){
        By select=By.id(id);
        Click(select);
    }

    

    @When("^Click on \"([^\"]*)\" button$")//continue or save and continue button or custom name
    public void clickOnContinueButton(String buttonName) throws Throwable {
        By buttonloginXpBy= By.xpath("//*[contains(text(), '" + buttonName + "')]");
        ClickTest(buttonloginXpBy);
    }
    @When("^Click on custom button \"([^\"]*)\"$")//continue or save and continue button or custom name
    public void clickOnCustomButton(String path) throws Throwable {
        System.out.println("Custom button");
        By buttonloginXpBy= By.xpath(path);
        Click(buttonloginXpBy);
    }

    @When("^Choose Power your products Addons")
    public void isChooseAddonsProduct() throws Throwable {
        By choosAddonsProductByXPat = By.xpath("//*[@id='root']/div/main/section/section/div[2]/div/div/div/div[2]/div[2]/div/div[2]");
        MultipleClick(choosAddonsProductByXPat,2);
    }
   

    
    @When("^Verify Aditional Line")
    public void verifyAditionalLine() throws Throwable {
        By verifyAditionalLineByXPat = By.xpath("/html/body/div[2]/div/div[2]/div");
        Boolean existElement= isElementPresent(verifyAditionalLineByXPat);
        if(existElement){
            System.out.println("Element is present");
            By returnCart=By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/button[1]");
            Click(returnCart);
        }else{
            System.out.println("Element is absent");
        }
    }

    @When("^Select available number option \"([^\"]*)\"$")
    public void selectAvailableNumberOption(String optionName) throws Throwable {
        By optionBy = By.xpath("//*[contains(text(), '" + optionName + "')]");
        Click(optionBy);
    }

    @When("^Chick checkOut")
    public void checkOut() throws Throwable {
        By checkOutByXPat = By.xpath("//*[@id='root']/div/div/main/section/section/div[1]/div/div[2]/div/button");
        Click(checkOutByXPat);
    }

    @When("^Write \"([^\"]*)\" in area id \"([^\"]*)\"$")
    public void inputArea(String areaName,String id ) throws Throwable {
        By textBy=By.id(id);
        writeText(textBy,areaName);
        Enter(textBy);
    }

    @When("^Click on credit card radio button$")
    public void clickCreditCart () throws InterruptedException {
        By elBy=By.xpath("/html/body/div/div/main/section/section/div[2]/div/div/div/div/form/div/div[1]/div[5]/div/div[2]/input");
        Click(elBy);
    }
    @When("^Click on billing radio button$")
    public void clickBilling () throws InterruptedException{
        By elBy=By.xpath("/html/body/div/div/main/section/section/div[2]/div/div/div/div/form/div/div[1]/div[6]/div/div[1]/input");
        Click(elBy);
    }
    @When("^Scan products$")
    public void scanProducts() throws InterruptedException{
        By product=By.xpath("//*[@id='root']/div/main/section/section/div[2]/div/div/section/div/div/div[2]/button");
        Click(product);
    }

    @When("^Click on button with id \"([^\"]*)\"$")
    public void clickOnButtonWithId(String id) throws Throwable {
        By elBy=By.id(id);
        Click(elBy);
    }
    @When("^Click on next bill radio button$")
    public void clicNextBill () throws InterruptedException{
        By elBy=By.xpath("/html/body/div/div/main/section/section/div[2]/div/section/div[2]/div/div[3]/h1[2]/div/div[2]/input");
        Click(elBy);
    }

    @When("^Close Navigator$")
    public void closeNavigator(){
        login.ClosedNavigation();
    }

    @When("^Await \"([^\"]*)\" seconds")
    public void awaitSeconds(String dataString) throws InterruptedException {
        //String to int
        int seconds = Integer.parseInt(dataString);
        Thread.sleep(seconds*1000);
        System.out.println("Await "+seconds+" seconds");
    }
}
