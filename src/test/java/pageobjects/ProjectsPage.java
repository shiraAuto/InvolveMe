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
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class ProjectsPage extends BasePage{


    @FindBy(css=".dropdown>button")
    @CacheLookup
    private WebElement userMenuBtn;

    @FindBy(css=".flex>.fas") //     .dropdown>a>div>div:nth-child(2)>.flex
    @CacheLookup
    private WebElement openUserMenuBtn;

    @FindBy(css=".dropdown-menu>li:nth-child(13)>a")
    @CacheLookup
    private WebElement logOutBtn;

    @FindBy(css=".flex-col>a")
    @CacheLookup
    private WebElement startBtn;


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

    @Step("Start new project")
    public void startProject()
    {
        if (driver.getCurrentUrl().contentEquals("https://app.involve.me/projects"))
            click(startBtn);
        else
            System.out.println("you are not in the projects page");

    }

     @Step("Print list project")
     public void printOptionsList()
     {
         List<WebElement> optionList = driver.findElements(By.cssSelector("#app-layout > .container > div:nth-child(3) > div>a>div"));
         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         /* WebElement currentItem;*/
         /* Both loops act the same.
         for (int i=0;i< optionList.size();i++)
         {
             currentItem=optionList.get(i);
             System.out.println(currentItem.findElement(By.className("title")).getText());
         }
         */

        for( WebElement item : optionList)
           System.out.println(item.findElement(By.className("title")).getText());
     }

     @Step("Choose project type {0}")
     public boolean chooseProjectType(String type)
     {
         String current="";
         List<WebElement> optionList = driver.findElements(By.cssSelector("#app-layout > .container > div:nth-child(3) > div>a>div"));
         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         for( WebElement item : optionList) {
             current=item.findElement(By.className("title")).getText();
             if (current.contentEquals(type)) {
                 click(item);
                 break;
             }
         }

         sleep(4000);
         String currentUrl = driver.getCurrentUrl();
         System.out.println(currentUrl);
         if (currentUrl.contains(type.toLowerCase()) && currentUrl.contains("templates"))
             return true;
         else
             return false;

     }
}
