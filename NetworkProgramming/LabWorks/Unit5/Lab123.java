package LabWorks.Unit5;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class Lab123 {
    public static void main(String[] args) {
        try {
            // Establish a URLConnection to the specified URL
            URL url = new URL("https://www.example.com");
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();

            // Print URL details
            System.out.println("URL: " + url.toString());
            System.out.println("Protocol: " + url.getProtocol());

            // Get and print content length
            int contentLength = urlConnection.getContentLength();
            if (contentLength != -1) {
                System.out.println("Content Length: " + contentLength + " bytes");
            } else {
                System.out.println("Content Length: not available");
            }

            System.out.println("Extended program for lab 2: ");
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String inputLine;
            System.out.println("\n--- Content Start ---");
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            System.out.println("--- Content End ---");
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

