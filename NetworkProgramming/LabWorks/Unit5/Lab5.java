package LabWorks.Unit5;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Lab5 {
    public static void main(String[] args) {
        try {
            String getUrl = "http://example.com";
            String postUrl = "http://example.com";
            String postPayload = "{\"key\":\"value\"}";

            // Sending HTTP GET request
            HttpURLConnection getResponse = (HttpURLConnection) new URL(getUrl).openConnection();
            getResponse.setRequestMethod("GET");
            System.out.println("GET Request Response Code: " + getResponse.getResponseCode());

            // Sending HTTP POST request
            HttpURLConnection postResponse = (HttpURLConnection) new URL(postUrl).openConnection();
            postResponse.setRequestMethod("POST");
            postResponse.setDoOutput(true);
            try (OutputStream os = postResponse.getOutputStream()) {
                byte[] input = postPayload.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            System.out.println("POST response code: " + postResponse.getResponseCode());

            // Sending HTTP TRACE request
            HttpURLConnection traceResponse = (HttpURLConnection) new URL(getUrl).openConnection();
            traceResponse.setRequestMethod("TRACE");
            System.out.println("TRACE response code: " + traceResponse.getResponseCode());

            // Sending HTTP OPTIONS request
            HttpURLConnection optionsResponse = (HttpURLConnection) new URL(getUrl).openConnection();
            optionsResponse.setRequestMethod("OPTIONS");
            System.out.println("OPTIONS response code: " + optionsResponse.getResponseCode());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
