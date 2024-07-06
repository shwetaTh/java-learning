package LabWorks.Unit5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Lab6 {
    public static void main(String[] args) {
        try {
            String getUrl = "https://jsonplaceholder.typicode.com/posts/1";
            HttpURLConnection connection = (HttpURLConnection) new URL(getUrl).openConnection();
            connection.setRequestMethod("GET");

            StringBuilder response = new StringBuilder();
            int responseCode = connection.getResponseCode();
            String responseMessage = connection.getResponseMessage();

            response.append("Response Code: ").append(responseCode).append("\n");
            response.append("Message: ").append(responseMessage).append("\n");

            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine).append("\n");
                    }
                }
            }

            System.out.println(response.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
