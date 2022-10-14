package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CorePage {

    WebDriver driver;

    public CorePage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        driver = webDriver ;
    }

    protected void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver , 10);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    protected void waitForElements(List<WebElement> elements){
        WebDriverWait w = new WebDriverWait(driver,10);
        w.until(ExpectedConditions.visibilityOfAllElements(elements));
    }




    protected void enterDataToField(WebElement element , String text){
        clear(element);
        element.sendKeys(text);
    }


    protected void clear(WebElement element ){
        waitForElement(element);
        element.clear();
    }

    protected String  getText(WebElement element ){
        waitForElement(element);
        return element.getText();
    }


    protected String  getAttribute(WebElement element ,String attribute ){
        waitForElement(element);
        return element.getAttribute(attribute);
    }


    public String getURL(){

        return driver.getCurrentUrl();
    }

    public boolean Displayed(WebElement element){
        waitForElement(element);
        return element.isDisplayed();
    }



    protected void  clickOnButton(WebElement element){
        waitForElement(element);
        element.click();
    }


}
