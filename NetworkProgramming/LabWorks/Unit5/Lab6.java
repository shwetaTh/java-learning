package LabWorks.Unit5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
public class Lab6 {
    public static String handleResponse(HttpURLConnection connection) throws IOException {
        int responseCode = connection.getResponseCode();
        String responseMessage = connection.getResponseMessage();
        StringBuilder response = new StringBuilder();
        response.append("Response Code: ").append(responseCode).append("\n");
        response.append("Message: ").append(responseMessage).append("\n");
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine+ "\n");
                }
                response.append("Content: ").append(content.toString());
            }
        }
        return response.toString();
    }
    public static void main(String[] args) {
        try {
            String getUrl = "https://jsonplaceholder.typicode.com/posts/1";
            HttpURLConnection connection = Lab5.sendGetRequest(getUrl);
            String response = handleResponse(connection);
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
