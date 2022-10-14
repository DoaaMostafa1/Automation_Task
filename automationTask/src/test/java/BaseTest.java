import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseTest {

    WebDriver driver;
    String URL = "https://deliveroo.co.uk/";

    @BeforeSuite
    public void setUp(){

        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(URL);
    }


    @AfterSuite
    public void tearDown(){
        if(driver != null)
            driver.quit();
    }


}
