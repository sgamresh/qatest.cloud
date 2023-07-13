package test.web.base;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.*;

public class BaseTest {
	protected WebDriver driver = null;
	protected ExtentTest test;
//	protected ExtentTest maintest;

	protected ExtentReports extent;
	protected ExtentTest node;

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
		driver = new ChromeDriver();
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
