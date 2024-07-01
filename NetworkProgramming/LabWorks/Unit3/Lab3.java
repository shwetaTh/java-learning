package LabWorks.Unit3;

import java.net.*;
import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] exampleUrls = {
                "https://www.example.com/path/to/resource?query=value#fragment",
                "http://java.sun.com/j2se/1.3/",
                "ftp://ftp.is.co.za/rfc/rfc1808.txt"
        };
        System.out.print("Enter a URL: ");
        String userInput = scanner.nextLine();
        analyzeURL(userInput);
        scanner.close();
    }
    public static void analyzeURL(String urlString) {
        try {
            URL url = new URL(urlString);

            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("File: " + url.getFile());
            System.out.println("Ref: " + url.getRef()); // returns fragment
            System.out.println("Query: " + url.getQuery());
            System.out.println("Path: " + url.getPath());
            System.out.println("UserInfo: " + url.getUserInfo());
            System.out.println("Authority: " + url.getAuthority());

        } catch (MalformedURLException e) {
            System.err.println("Invalid URL: " + urlString);
            e.printStackTrace();
        }
    }
}
