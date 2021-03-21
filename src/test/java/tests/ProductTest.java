package tests;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobjects.*;
import utils.Utils;


@Epic("Projects Tests")
public class ProductTest extends BaseTest{
    SoftAssert softAssert = new SoftAssert();

    @Story("Login in order to test the site")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Log in to continue test")
    @Test(priority = 0, description = "Log in to continue test ")
    public void login() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
      //  loginPage.login("shira.man2@gmail.com", "Mandel0206");
        loginPage.login(Utils.readProp("email"), Utils.readProp("password"));
        ProjectsPage projPage = new ProjectsPage(driver);
        Assert.assertTrue(projPage.isUserMenuVisible());

    }

    @Story("As a user I would like to start a new project")
    @Severity(SeverityLevel.NORMAL)
    @Description("start a new project - Form")
    @Test(priority = 1, description = "start form project")
    public void createProjectForm() throws InterruptedException {
        WorkspacesPage wp = new WorkspacesPage(driver);
        wp.createProject();
        ProjectsPage projPage2 = new ProjectsPage(driver);
        projPage2.startProject();
        softAssert.assertTrue(projPage2.chooseProjectType("Form"));
        FormTemplatesPage formTemplate = new FormTemplatesPage(driver);
        softAssert.assertTrue(formTemplate.moveToBlank());
        formTemplate.chooseProjectType("myForm");
    }
/*
    @Story("As a user I would like to start a new project")
    @Severity(SeverityLevel.NORMAL)
    @Description("start a new project - Form")
    @Test(priority = 1, description = "start form project")
    public void startProjectForm() throws InterruptedException {
        ProjectsPage projPage2 = new ProjectsPage(driver);
        projPage2.startProject();
        softAssert.assertTrue(projPage2.chooseProjectType("Form"));
        FormTemplatesPage formTemplate = new FormTemplatesPage(driver);
        softAssert.assertTrue(formTemplate.moveToBlank());

    }
*/


}
