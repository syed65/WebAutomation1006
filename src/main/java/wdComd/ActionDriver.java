package wdComd;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.MediaEntityBuilder;

import config.StartBrowser;

public class ActionDriver {
	
	WebDriver driver;
	
	public ActionDriver() {
		
		driver=StartBrowser.driver;
	}
	/**
	 * This method for navigate to the AUT
	 * @param url
	 * @throws Exception
	 */
	public void navigateToBrowser(String url) throws Exception {
		
		try {
			driver.get(url);
			StartBrowser.childTest.pass("successfully navigated to url: "+url);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to navigate to url: "+url);
			throw e;
		}
	}

	/**
	 * Used to perform click on the button, links,RB and checkBox
	 * @param-locator--get it from object repository
	 * @param-elementName --name of the element
	 * @param-throws--Exception
	 */
		public void clickOperation(By locator,String element) throws Exception {
			
			try {
				driver.findElement(locator ).click();
				StartBrowser.childTest.pass("successfully performed click action on: "+element);
			} catch (Exception e) {
				StartBrowser.childTest.fail("Unable to find locator on:"+element,
						MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
				StartBrowser.childTest.info(e);
				throw e;
			}
			
	}
		/**
		 * This method to enter testData into textBox/textArea
		 * @param locator
		 * @param testData
		 * @throws Exception
		 */
		public void enterTestData(By locator, String testData, String element) throws Exception {
			
			try {
				driver.findElement(locator).sendKeys(testData);
				StartBrowser.childTest.pass("successfully entered data into the: "+element);
			} catch (Exception e) {
				StartBrowser.childTest.fail("Unable to find locator:"+element,
				MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
				StartBrowser.childTest.info(e);
				throw e;
			}
	
		}
		public String screenshot() {
			return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
			
		}
		
public void verifyPageTitle() throws Exception {
			
			try {
				 String title = driver.getTitle();
				StartBrowser.childTest.pass("Page Title is: "+title);
			} catch (Exception e) {
				StartBrowser.childTest.fail("Unable to find page Title:",
				MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
				StartBrowser.childTest.info(e);
				throw e;
			}
	
		}
}
