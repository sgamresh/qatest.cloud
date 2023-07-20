package test.web.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class SlackAttachmentExample {

    public static void main(String[] args) {
        String slackApiUrl = "https://hooks.slack.com/services/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"; // Slack API endpoint

        // Your Slack API token (keep this secure!)
        String apiToken = "YOUR_SLACK_API_TOKEN";

        // JSON payload with attachment
        String attachmentJson = "{\"attachments\":[{\"fallback\":\"Fallback Text\",\"text\":\"Hello from Java with Attachment!\",\"color\":\"#36a64f\"}]}";

        // Create an instance of HttpClient
        HttpClient httpClient = HttpClients.createDefault();

        // Create a POST request to Slack API
        HttpPost httpPost = new HttpPost(slackApiUrl);

        // Add Slack API token to the request headers
        httpPost.addHeader("Authorization", "Bearer " + apiToken);

        // Set the JSON payload as the request entity
        httpPost.setEntity(new StringEntity(attachmentJson, ContentType.APPLICATION_JSON));

        try {
            // Execute the POST request
            org.apache.http.HttpResponse response = httpClient.execute(httpPost);

            // Get the response content (if available)
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String responseBody = EntityUtils.toString(entity);
                System.out.println("Response Body: \n" + responseBody);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
