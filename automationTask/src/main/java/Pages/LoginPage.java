package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends CorePage{


    @FindBy(id ="continue-with-email")
    private WebElement continueWithEmailButton;

    @FindBy(id ="email-address")
    private WebElement emailField;

    @FindBy(xpath ="//button[@type = 'submit']")
    private WebElement continueButton;

    @FindBy(id ="type-password-btn")
    private WebElement typePassword;

    @FindBy(id ="login-password")
    private WebElement passwordField;

    @FindBy(xpath ="//button[@type = 'submit']")
    private WebElement loginButton;


    @FindBy(xpath ="//a[text() = 'Log in']")
    private WebElement goToLogin;











    public  void clickOnContinueWithEmailButton(String email , String password){
        clickOnButton(goToLogin);
        clickOnButton(continueWithEmailButton);
        enterDataToField(emailField ,email);
        clickOnButton(continueButton);
        //clickOnButton(typePassword);
        enterDataToField(passwordField , password);
        clickOnButton(loginButton);

    }

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
}
