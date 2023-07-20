package test.web.onboarding;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import test.web.base.BaseTest;
import test.web.listeners.RetryListener;

public class VerifyOnboardingTest extends BaseTest{
	
	
	@Test(enabled=true, retryAnalyzer = RetryListener.class)
	public void LaunchingGoogleApplication()  throws Exception{
		
 
			event.log("PASS", "Opening the WebBrowser");
//			driver.get("https://www.google.com/");
		 
			Map<String, String> map = new HashMap<String, String>();
			map.put("Amresh", "Abhishek");
			map.put("Amreshs", "Abhishek1");
			map.put("Amreshd", "Abhishek2");
			map.put("Amreshc", "Abhishek3");
			event.log("PASS", map);
			
			
			
			String uri="https://api.genderize.io?name=luc";
			Response res=null;
			try {
//				res = RestAssured.given().when().get(uri);
				res =RestAssured.given().when().get(uri);
//				res.prettyPrint();
				event.log("PASS", res);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			
			
			
			
		
		
		
		
		
		
		
		
		
		
	}
	 
	 

}
