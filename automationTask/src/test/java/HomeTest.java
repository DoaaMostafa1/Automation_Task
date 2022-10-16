import Pages.HomePage;
import Pages.LoginPage;
import Pages.RestaurantDetailsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest{


    HomePage homePage;

    @BeforeClass
    public void initialization(){
        homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getURL() , "https://deliveroo.co.uk/");
    }



    @Test(priority = 1)
    public void validateSearch_UsingValidKeyWord() throws InterruptedException {
        String keyword = "liverpool";
        Assert.assertTrue(homePage.searchUsingKeyword(keyword));

        homePage.selectElementFromSearchList(1);
        Thread.sleep(2000);
        System.out.println(homePage.getURL());
        //statement
    }


    @Test(priority = 2)
    public void validateSearch_UsingInValidKeyWord() throws InterruptedException {
        driver.navigate().to("https://deliveroo.co.uk/");
        String keyword = "@#";
        Assert.assertTrue(homePage.searchUsingKeyword(keyword));
    }


    @Test(priority = 3)
    public void validate_mapAppearsWhenClickOnSearch() throws InterruptedException {
        driver.navigate().to("https://deliveroo.co.uk/");
        String keyword = "######";
        Assert.assertTrue(homePage.viewMap(keyword));

    }

    @Test(priority = 4)
    public void validateFilter() throws InterruptedException {
        driver.navigate().to("https://deliveroo.co.uk/");
        String keyword = "liverpool";
        Assert.assertTrue(homePage.searchUsingKeyword(keyword));
        homePage.selectElementFromSearchList(1);
        RestaurantDetailsPage restaurantDetailsPage = new RestaurantDetailsPage(driver);
        restaurantDetailsPage.getFilterTag();
    }
      @Test(priority = 5)
        public void validateCountOfRestaurants() throws InterruptedException {
          driver.navigate().to("https://deliveroo.co.uk/");
        String keyword = "liverpool";
        Assert.assertTrue(homePage.searchUsingKeyword(keyword));
        homePage.selectElementFromSearchList(1);
        RestaurantDetailsPage restaurantDetailsPage = new RestaurantDetailsPage(driver);
        restaurantDetailsPage.getFilterTag();
        restaurantDetailsPage.getCountOfItems();



    }


    @Test(priority = 5)
    public void login() throws InterruptedException {
        driver.navigate().to("https://deliveroo.co.uk/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnContinueWithEmailButton("mdoaa924@gmail.com","Doaa@1234");
        //need to call API to return OTP Code

    }




}
