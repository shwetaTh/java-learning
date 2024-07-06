package LabWorks.Unit5;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class Lab4 {
    public static void main(String[] args) {
        try {
            // Establish a URLConnection to the specified URL
            URL url = new URL("https://www.example.com");
            URLConnection urlConnection = url.openConnection();
            
            urlConnection.setConnectTimeout(5000); // 5 seconds timeout for connecting
            urlConnection.setReadTimeout(5000); // 5 seconds timeout for reading

            // Enable/disable caching
            urlConnection.setUseCaches(false); // Disable caching

            // Configure user interaction
            urlConnection.setAllowUserInteraction(true);

            urlConnection.connect();

            System.out.println("Connect timeout: "+ urlConnection.getConnectTimeout());
            System.out.println("Read timeout: "+ urlConnection.getReadTimeout());
            System.out.println("Use caches: "+ urlConnection.getUseCaches());
            System.out.println("Allow user interaction: "+ urlConnection.getAllowUserInteraction());



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

