package LabWorks.Unit3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Lab1 {
    public static void main(String[] args) {
        String url = "https://www.google.com";

        try {
            URL webpage = new URL(url);
            URLConnection connection = webpage.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
                content.append("\n");
            }

            in.close();

            System.out.println("Downloaded content:");
            System.out.println(content.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

