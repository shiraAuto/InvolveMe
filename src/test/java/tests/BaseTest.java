///BaseTest AutomationEbay  VVVVV
package tests;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Utils;

import java.io.File;
import java.io.IOException;

public class BaseTest {
	WebDriver driver;
	//String browserVersion;
	//String browserName;
	//public Logger logger = Logger.getLogger(Utils.Log.class);

	/*
	@BeforeClass
	public void setup() {
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src\\test\\java\\log4j.properties");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		Reporter.log("Browser Opened");
		driver.manage().window().maximize();
		driver.get(Utils.readProp("url"));
		Reporter.log("open url " + Utils.readProp("url"));
 	}
   */
	
	@BeforeClass
	 protected void setup(ITestContext testContext) {
	 //PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src\\test\\java\\log4j.properties");
	  WebDriverManager.chromedriver().setup();
	  ChromeOptions cOptions = new ChromeOptions();
	  cOptions.addArguments("disable-infobars");
	  driver = new ChromeDriver(cOptions);
	  testContext.setAttribute("WebDriver", this.driver);	  
	  driver.get(Utils.readProp("url"));
	  driver.manage().window().maximize();
	 }
	
	//@AfterMethod
	public void failedTest(ITestResult result) {
	  //check if the test failed
		if (result.getStatus() == ITestResult.FAILURE ){
			TakesScreenshot ts = (TakesScreenshot)driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			try {
			//	FileUtils.copyFile(srcFile, new File("./ScreenShots/"+result.getName()+".jpg"));
				FileUtils.copyFile(srcFile, new File("D:\\automations\\projectsLogs\\screenshots\\AutomationPractice\\"+result.getName()+".jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//result.getname() method will give you current test case name. 
			//./ScreenShots/ tell you that, in your current directory, create folder ScreenShots. dot represents current directory
		}
	}
	
	
	//@AfterClass
	public void tearDown() {
		if(driver != null) {
			driver.quit();
			Reporter.log("Browser Closed");
		}
	}
}
