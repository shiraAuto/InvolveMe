package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css=".input-label>[name='email']")
    @CacheLookup
    private WebElement emailField;

    @FindBy(css=".input-label>[name='password']")
    @CacheLookup
    private WebElement passwordField;

    @FindBy(css="[type='submit']")
    @CacheLookup
    private WebElement loginBtn;

    @FindBy(css=".form-group>.alert")
    @CacheLookup
    private WebElement invalidDetailsMsg;


    public LoginPage(WebDriver driver) { super(driver); }

    @Step("login with email {0} and password {1}")
    public void  login(String userEmail , String userPassword) {
      fillText(emailField , userEmail );
      fillText(passwordField , userPassword );
      click(loginBtn);
    }

    public String getInvalidDetailsMsg()
    {
       return invalidDetailsMsg.getText();
    }
}
