package test.web.onboarding;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import test.web.base.BaseTest;

public class VerifyOnboardingTest extends BaseTest{
	
	
	@Test()
	public void LaunchingTheWebApplication(){
		
		test.log(Status.PASS, "Opening the WebBrowser");
		driver.get("https://www.google.com/");
		test.log(Status.PASS, "Closing the WebBrowser");

		
	}
	
	@Test()
	public void LaunchingTheWebApplication2(){
		
		test.log(Status.PASS, "Opening the WebBrowser");
		driver.get("https://www.Facebook.com/");
		test.log(Status.PASS, "Closing the WebBrowser");

		
	}
	 

}
