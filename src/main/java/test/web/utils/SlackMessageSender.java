package test.web.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
//https://qatest-kue4733.slack.com/apps/A0F7XDUAZ-incoming-webhooks
//String webhookUrl = "https://hooks.slack.com/services/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";
//String htmlFilePath = "C:\\Users\\Geetanjali\\FrameworkDemo\\test\\target\\Spark.html";
//https://www.diehardtechy.com/2019/07/how-to-send-attachment-in-slack-channel.html
public class SlackMessageSender {
	
	
    public static void main(String[] args) {
    	String webhookUrl = "https://hooks.slack.com/services/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";

        try {
            URL url = new URL(webhookUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set connection properties
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
 
            // Create the message payload
            String message = "{\"text\":\"Hello, Slack! \"}";

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
    }}
