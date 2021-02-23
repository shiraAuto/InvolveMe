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

public class ProjectsPage extends BasePage{
/*
    @FindBy(css=".dropdown-menu")
    @CacheLookup
    private List<WebElement> menuList;
  */
    @FindBy(css=".dropdown>button")
    @CacheLookup
    private WebElement userMenuBtn;

    @FindBy(css=".flex>.fas") //     .dropdown>a>div>div:nth-child(2)>.flex
    @CacheLookup
    private WebElement openUserMenuBtn;

    @FindBy(css=".dropdown-menu>li:nth-child(13)>a")
    @CacheLookup
    private WebElement logOutBtn;

    public ProjectsPage(WebDriver driver) {super(driver); }

    public boolean isUserMenuVisible()
    {
        if(userMenuBtn.isDisplayed())
            return true;
        else
            return false;
    }

    public void clickMenuItem(WebElement itemToClick)
    {
        click(openUserMenuBtn);
        // explicit wait - to wait for the compose button to be click-able
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfAllElements());

        List<WebElement> menuList =driver.findElements((By.cssSelector(".dropdown-menu>li")));

        for (WebElement item : menuList)
        {
            if(item.getText().contentEquals(itemToClick.getText()))
                click(item);
        }

    }

    public void openMenuList()
    {
        click(openUserMenuBtn);
    }

    @Step("Log out")
    public void logOut()
    {
        click(openUserMenuBtn);
        click(logOutBtn);
    }
}
