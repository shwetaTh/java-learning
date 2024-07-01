package LabWorks.Unit3;

import java.net.*;

public class Lab4 {
    public static void main(String[] args) {

        try {
            URL urlObj1 = new URL("http://www.ibiblio.org");
            URL urlObj2 = new URL("http://ibiblio.org");

            if (urlObj1.equals(urlObj2)) {
                System.out.println("same URLs");
            } else {
                System.out.println("not same URLs.");
            }

        } catch (MalformedURLException e) {
            System.err.println("Invalid URL format: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
