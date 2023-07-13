package test.web.onboarding;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import test.web.base.BaseTest;
import test.web.listeners.RetryListener;

public class VerifyOnboardingTest extends BaseTest{
	
	
	@Test(retryAnalyzer = RetryListener.class)
	public void LaunchingTheWebApplication(){
		
		test.log(Status.PASS, "Opening the WebBrowser");
		driver.get("https://www.google.com/");
		test.log(Status.PASS, "Closing the WebBrowser");

		
	}
	
	@Test(enabled=true, retryAnalyzer = RetryListener.class)
	public void LaunchingTheWebApplication2(){
		Assert.assertEquals(true, false);
		test.log(Status.FAIL, "Opening the WebBrowser");
		driver.get("https://www.Facebook.com/");
		test.log(Status.FAIL, "Closing the WebBrowser");

		
	}
	 

}
