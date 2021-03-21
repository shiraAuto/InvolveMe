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

public class FormTemplatesPage extends BasePage{


    @FindBy(css="tr:nth-child(1)>td:nth-child(1)>div>.c-thumbnail-image-wrapper > a")
    @CacheLookup
    private WebElement blankBtn;

    private WebElement inputProjectName,startEditingBtn;

    public FormTemplatesPage(WebDriver driver) {super(driver); }


    public boolean moveToBlank()
    {
        click(blankBtn);
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        if (currentUrl.contains("new-project"))
            return true;
        else
            return false;
    }

    public void chooseProjectType(String projectName)
    {

        //driver.switchTo().frame(driver.findElement(By.id("cm_iframe")));
        sleep(5000);
        String modalTitle=driver.findElement(By.cssSelector("swal-title")).getText();
        if(modalTitle.contentEquals("Choose Project Type"))
        {
            inputProjectName = driver.findElement(By.cssSelector("#new-project-form>.form-group>input"));
            fillText(inputProjectName,projectName);
            startEditingBtn = driver.findElement(By.cssSelector("div > div:nth-child(1) > label > div > button"));
            click(startEditingBtn);
        }
        else
        {
            System.out.println("chooseProjectType - Test Failed - modal title is not displaying");
        }
    }


}
