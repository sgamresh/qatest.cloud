package test.web.utils;

import java.util.Map;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.restassured.response.Response;
import test.web.base.BaseTest;

public class Event extends BaseTest {
	
//	public Event(ExtentTest test) {
//		this.test=test;
//		 
//	}


	public void log(String status, String message) {
		switch(status.toLowerCase())
		{
		case "pass":
		{
			test.pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
			util.sendReportViaSlack(message);
 			break;
		}
		case "skip":
		{
			test.pass(MarkupHelper.createLabel(message, ExtentColor.GREY));	
			break;
			}
		case "fail":
		{
			test.pass(MarkupHelper.createLabel(message, ExtentColor.RED));	
			break;
		}
		case "warning":
		{
			test.pass(MarkupHelper.createLabel(message, ExtentColor.BLUE));	
			break;
			}
		   
		}
		
	}
	
	
	public void log(String status, Map<String, String> map) {
		String mapstr = map.toString();
		switch(status.toLowerCase())
		{
		case "pass":
		{
 			test.pass(MarkupHelper.createCodeBlock(mapstr));
 			util.sendReportViaSlack(mapstr);
 			break;
		}
		case "skip":
		{
 			test.skip(MarkupHelper.createCodeBlock(mapstr));
 			break;
		}
		case "fail":
		{
 			test.fail(MarkupHelper.createCodeBlock(mapstr));
 			break;
			
		}
		 
		}
		
	}
	
	public void log(String status, Response json) {
		String jsonString=json.asString();
 		switch(status.toLowerCase())
		{
		case "pass":
		{
 			test.pass(MarkupHelper.createCodeBlock(jsonString));
 			util.sendReportViaSlack(jsonString);
 			
 			break;
		}
		case "skip":
		{
 			test.skip(MarkupHelper.createCodeBlock(jsonString));
 			break;
		}
		case "fail":
		{
 			test.fail(MarkupHelper.createCodeBlock(jsonString));
 			break;
			
		}
		 
		}
		
	}

}
