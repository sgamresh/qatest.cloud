package test.web.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer {

	int retryLimit = 1;
	int counter = 0;
	
	
	@Override
	public boolean retry(ITestResult result) {
		if(counter < retryLimit) {
			counter++;
			return true;
			
			
		}
		
		
		return false;
	}

}
