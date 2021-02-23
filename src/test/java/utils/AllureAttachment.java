//AllureAttachment AutomationEbay  VVVVV
package utils;

import java.nio.charset.StandardCharsets;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.underscore.lodash.U;

import io.qameta.allure.Attachment;

public class AllureAttachment {

	// add log 
	@Attachment(value = "{0}", type = "text/plain")
	public static String addTextAttachment(String message) {return message;	}

	// add screenshot
	 @Attachment(value = "Page Screenshot", type = "image/png", fileExtension = ".png")
	 public static byte[] attachScreenshot(WebDriver driver) {
		 return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	 }
	 
	 //add page Source
	 @Attachment(value = "Html source", type = "text/html", fileExtension = ".html")
		public static byte[] getPageSource(WebDriver driver) {
			return driver.getPageSource().getBytes(StandardCharsets.UTF_8);
		}
	 
	 //add Element Screenshot
	 @Attachment(value = "Element Screenshot", type = "image/png", fileExtension = ".png")
		public static byte[] attachElementScreenshot(WebElement element) {
			return element.getScreenshotAs(OutputType.BYTES);
		}
	 
	//add Json
	 @Attachment(value = "JSON attachment", type = "application/json", fileExtension = ".json")
	    public static String attachJson(String json) {
	        return U.formatJson(json);
	    }
	 
	//add Xml
	 @Attachment(value = "XML attachment", type = "application/xml", fileExtension = ".xml")
	    public static String attachXml(String xml) {
	        return U.formatXml(xml);

	    }
	 
	//add csv
	 @Attachment(value = "CSV attachment", type = "text/csv", fileExtension = ".csv")
	    public static String attachCSV(String csv) {
	        return csv;
	    }
	 
	//add url
	 @Attachment(value = "URL attachment", type = "text/uri-list", fileExtension = ".uri")
	    public static String attachURL(String url) {
	        return url;
	    }
	 
	//add browser information
	/* 
	 @Attachment(value = "Browser information", type = "text/plain")
	 public static String addBrowserInformationOnAllureReport(WebDriver driver) {
	     return 
	 }
	 
	 */
	
}
