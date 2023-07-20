package test.web.utils;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import test.web.base.BaseTest;

public class Utilities extends BaseTest{
	

	public void sendReportViaSlack(String msg)
	{
		  String webhookUrl = "https://hooks.slack.com/services/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";

	    try {
	        URL url = new URL(webhookUrl);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	        // Set connection properties
	        connection.setRequestMethod("POST");
	        connection.setRequestProperty("Content-Type", "application/json");
	        connection.setDoOutput(true);

	        // Create the message payload
	        String message = "{\"text\":\"Hello, Slack! "+msg+"\"}";

	        // Send the message
	        try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
	            outputStream.writeBytes(message);
	            outputStream.flush();
	        }

	        int responseCode = connection.getResponseCode();
	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            System.out.println("Message sent successfully to Slack.");
	        } else {
	            System.out.println("Failed to send message to Slack. Response code: " + responseCode);
	        }

	        connection.disconnect();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		
	}
	
	
	

}
