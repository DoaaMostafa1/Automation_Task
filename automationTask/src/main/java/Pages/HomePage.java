package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;
import java.util.Locale;

public class HomePage extends CorePage{

    @FindBy(id = "location-search")
    private WebElement searchField;

    @FindBy(xpath = "//div[@class = 'ccl-c9fc3192a5030dce']/ul/ul/li/button/div/div/div[2]/p[1]")
    private List<WebElement> searchList;


    @FindBy(id = "modal-header-title")
    private WebElement mapPopUp;

    @FindBy(xpath = "(//button[@type = 'button'])[4]")
    private WebElement searchButton;




    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean searchUsingKeyword(String text) throws InterruptedException {
        enterDataToField(searchField, text);
        Thread.sleep(2000);
        try {
            waitForElements(searchList);
            System.out.println("The List Contain " + searchList.size() +" elements");

            if(searchList.size() > 0){
                return allWordsContainKeyword(text);
            }
            else{
                System.out.println("The search list not contains any element");
                return true;
            }
        }
        catch (Exception e){
            System.out.println("The List Contain " + 0 +" elements");
            return true;
        }

    }




    public boolean viewMap(String text) throws InterruptedException {
        enterDataToField(searchField , text);
        searchButton.click();
        return mapIsDisplayed();
    }


    private boolean allWordsContainKeyword(String text){
        boolean same = true;

        for (WebElement element: searchList) {

            String e = getText(element).toLowerCase(Locale.ROOT);
            text = text.toLowerCase(Locale.ROOT);
            System.out.println(e);

            if(e.contains(text) == false){
                System.out.println("There is an element which the Text inside it not contains the keyword");

                same = false;
                break;

            }


        }

        return same;
    }


    public void selectElementFromSearchList(int  position){
        if(searchList.size() >= position){
            System.out.println("You selected :" + getText(searchList.get(position-1)));
            clickOnButton(searchList.get(position-1));

        }
        else
            System.out.println("Invalid Position");
    }


    //map is displayed in case entered invalid location
    private boolean mapIsDisplayed(){
        try {
            //driver.switchTo().activeElement();
            return Displayed(mapPopUp);
        }
        catch (Exception e){
            System.out.println("AAAAAA");
        }
       return false;
    }




}
