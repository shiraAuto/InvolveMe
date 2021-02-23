package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProjectsPage extends BasePage{
/*
    @FindBy(css=".dropdown-menu")
    @CacheLookup
    private List<WebElement> menuList;
  */
    @FindBy(css=".dropdown>button")
    private WebElement userMenuBtn;

    @FindBy(css=".dropdown>a>div>div:nth-child(2)>.flex") //  .flex>.fas
    private WebElement openUserMenuBtn;

    private WebElement logOutBtn;

    public ProjectsPage(WebDriver driver) {super(driver); }

    public boolean isUserMenuVisible()
    {

        if(userMenuBtn.isDisplayed())
            return true;
        else
            return false;

    }

    public void openMenuList()
    {
        click(openUserMenuBtn);
    }

    public void logOut()
    {
        click(openUserMenuBtn);
        List<WebElement> menuList =driver.findElements((By.cssSelector(".dropdown-menu>li")));
        sleep(5000);
        for (WebElement item : menuList)
        {
            System.out.println(item.getText());
            if(item.getText().contentEquals("Log Out"))
                click(item);
        }
    }
}
