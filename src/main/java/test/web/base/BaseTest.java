package test.web.base;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import test.web.utils.Event;
import test.web.utils.Utilities;

import org.testng.*;

public class BaseTest {
	public static ExtentTest test;
//	protected ExtentTest maintest;
 	protected ExtentReports extent;
	protected ExtentTest node;
	protected WebDriver driver;
	public static Event event= new Event();
	public static Utilities util = new Utilities();
	
	@BeforeSuite
	public void startServer() {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
	}
	
	@BeforeMethod()
	public void launchApp(Method testmethod) {
//		String TestName = ctx.getCurrentXmlTest().getName();
//		System.out.println(TestName);
//		node = test.createNode(testmethod.getName());
		test = extent.createTest(testmethod.getName());

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-site-isolation-trials");
		options.addArguments("--start-maximized");
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.default_content_setting_values.media_stream_mic", 2);
		options.setExperimentalOption("prefs", prefs);
		
		  driver = new ChromeDriver(options);
	}

	@AfterMethod
	public void closeApp() {
		if (driver != null) {
//			driver.close();
			driver.quit();
		}

	}

	@AfterSuite
	public void stopServer() {
		extent.flush();
	}

}
