package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WorkspacesPage extends BasePage{

    @FindBy(css=".dropdown-menu>li:nth-child(13)>a")
    @CacheLookup
    private WebElement logOutBtn;

    @FindBy(css="#app>.max-w-full>div>.mt-4>div>a")
    @CacheLookup
    private WebElement createBtn;


    public WorkspacesPage(WebDriver driver) {super(driver); }


    @Step("Create new project")
    public void createProject()
    {
        sleep(4000);
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        if (driver.getCurrentUrl().contentEquals("https://app.involve.me/projects"))
            click(createBtn);
        else
            System.out.println("you are not in the workspaces page");

    }


}
