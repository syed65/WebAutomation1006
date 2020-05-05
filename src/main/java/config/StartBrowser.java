package config;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StartBrowser {
	public static WebDriver driver;
	 ExtentHtmlReporter htmlReporter;
	public static ExtentReports extents;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
  
  @BeforeMethod
  public void method(Method method) {
	  parentTest=extents.createTest(method.getName());  
  }

  @BeforeClass
  public void setUpBrowser() {
	  WebDriverManager.chromedriver().setup();
	 String driver_path = WebDriverManager.chromedriver().getBinaryPath();
	String driver_version = WebDriverManager.chromedriver().getDownloadedVersion();
	 System.out.println("The Path: "+driver_path);
	 System.out.println("The Browser Version: "+driver_version);
	  driver = new ChromeDriver(); 
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }

  @BeforeTest
  public void report() {
	  htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/report/MyReport.html");
	  extents = new ExtentReports();
	  extents.attachReporter(htmlReporter);
  }
  
  @AfterMethod
  public void afterMethod() {
  }
 
  @AfterClass
  public void afterClass() {
	  driver.quit();
	  extents.flush();
  }
  
  @AfterTest
  public void afterTest() {
	  
  }

}
