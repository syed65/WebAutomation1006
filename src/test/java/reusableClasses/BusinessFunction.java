package reusableClasses;

import org.openqa.selenium.WebDriver;

import config.StartBrowser;
import objectRepository.Homepage;
import objectRepository.Loginpage;
import wdComd.ActionDriver;

public class BusinessFunction {
	WebDriver driver;
	ActionDriver aDriver;
	
	public BusinessFunction(){
		driver=StartBrowser.driver;
		aDriver=new ActionDriver();
		
	}
	public void goToApplication(){
		
		try {
			StartBrowser.childTest=StartBrowser.parentTest.createNode("Navigate to Google");
			aDriver.navigateToBrowser("https://google.com");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void login() throws Exception {
		StartBrowser.childTest=StartBrowser.parentTest.createNode("Login to Google");
		aDriver.clickOperation(Homepage.lnkSignIn,"Link Sign in");
		aDriver.enterTestData(Loginpage.emailId,"Email Text box","email");
		aDriver.enterTestData(Loginpage.password,"Pasword Text box","password");
		aDriver.verifyPageTitle();
	}
	public void verify() throws Exception {
		aDriver.verifyPageTitle();
	}

}
