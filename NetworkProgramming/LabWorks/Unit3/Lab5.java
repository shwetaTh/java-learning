package LabWorks.Unit3;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Lab5 {
    /*
        http://www.example.com/path/to/resource?query=value#fragment
        mailto:user@example.com
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a URI: ");
        String userInput = scanner.nextLine();
        scanner.close();

        try {
            URI uri1 = new URI(userInput);
            if (uri1.isOpaque()) {
                System.out.println("URI is opaque.");
                System.out.println("Scheme: " + uri1.getScheme());
                System.out.println("Scheme-specific part: " + uri1.getSchemeSpecificPart());
                System.out.println("Fragment: " + uri1.getFragment());
            } else {
                System.out.println("URI is hierarchical.");
                System.out.println("Authority: " + uri1.getAuthority());
                System.out.println("Fragment: " + uri1.getFragment());
                System.out.println("Host: " + uri1.getHost());
                System.out.println("Path: " + uri1.getPath());
                System.out.println("Port: " + uri1.getPort());
                System.out.println("Query: " + uri1.getQuery());
            }

        } catch (URISyntaxException e) {
            System.err.println("Invalid URI syntax: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

