package tests;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.ProjectsPage;
import utils.Utils;


@Epic("Login Tests")
public class LoginTest extends BaseTest{
     private final String INVALID_LOGIN_DETAILS = "These credentials do not match our records.";

    //  SoftAssert softAssert = new SoftAssert();

    @Story("As a User when I enter valid username and password you should be logged in the site")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Valid username and password")
    @Test(priority = 1, description = "Log in succsess")
    public void loginSuccessful() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage(driver);
      //  loginPage.login("shira.man2@gmail.com", "Mandel0206");
        loginPage.login(Utils.readProp("email"), Utils.readProp("password"));
        ProjectsPage projPage = new ProjectsPage(driver);
        Assert.assertTrue(projPage.isUserMenuVisible());

    }

    @Story("As a User when I click logout...")
    @Severity(SeverityLevel.NORMAL)
    @Description("Log out test")
    @Test(priority = 2, description = "Log out")
    public void logOut() throws InterruptedException {

        ProjectsPage projPage = new ProjectsPage(driver);
        projPage.logOut();
        Thread.sleep(5000);
        System.out.println("Current_url: " + driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("app.involve.me/login"));
    }

    @Story("As a User when I enter invalid username and password I will get an error message")
    @Severity(SeverityLevel.NORMAL)
    @Description("Invalid username and password")
   // @Test(priority = 3, description = "Log in failed")
    public void loginFailed() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Utils.readProp("email"), "123456");
        // System.out.println("invalid message " + loginPage.getInvalidDetailsMsg());
        Assert.assertEquals(INVALID_LOGIN_DETAILS,loginPage.getInvalidDetailsMsg());

    }
    //public void loginFailed() throws InterruptedException {
//
  //  }
}
