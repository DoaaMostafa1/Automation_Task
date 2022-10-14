package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RestaurantDetailsPage extends CorePage{

    @FindBy(xpath = "(//button[@type = 'button'])[3]")
    private WebElement sortDropdown;


    @FindBy(id = "distance-sidebar")
    private WebElement distanceRadio;


    @FindBy(xpath = "//span[contains(text(),'Distance')]")
    private WebElement tagText;

    @FindBy(xpath = "//div[@class = 'FilterTag-9986b96ac911a4d0']/p")
    private WebElement filterTag;

    @FindBy(xpath = "/html/body/div[8]/div/div/div/div/div/div[2]/span[2]/button")
    private WebElement okButtonPopUp;


    @FindBy(xpath = "//li[@class = 'HomeFeedGrid-b0432362335be7af']")
    private List<WebElement> items;

    @FindBy(xpath = " //p[contains(text(),'restaurants')]")
    private WebElement restaurants;











    public RestaurantDetailsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean getCountOfItems(){
       String [] strings =  getText(restaurants).split(" ");
       System.out.println(strings[0] + " " + items.size());
        return strings[0].equals("" +items.size());

    }


    public boolean  getFilterTag() throws InterruptedException {
        clickOnButton(okButtonPopUp);
        clickOnButton(sortDropdown);
        clickOnButton(distanceRadio);
        System.out.println(getText(filterTag) +"    "+getText(tagText));
        return getText(filterTag).contains(getText(tagText));
    }

}
