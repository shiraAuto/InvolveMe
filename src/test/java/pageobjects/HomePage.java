package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

    public class HomePage extends BasePage{

        @FindBy(css=".other-links>.login")
        @CacheLookup
        private WebElement loginBtn;

        @FindBy(css=".other-links>.register")
        @CacheLookup
        private WebElement registerBtn;


        public HomePage(WebDriver driver) { super(driver); }

        public void clickLogin(){ click(loginBtn);}
        public void clickRegister(){ click(registerBtn);}


}
