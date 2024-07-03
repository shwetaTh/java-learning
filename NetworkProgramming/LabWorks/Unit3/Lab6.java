package LabWorks.Unit3;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Lab6 {
    public static void main(String[] args) {
        try {
            String[] charsToEncode = {" ", "*", "%", "+", "\\", ":", "=", "&"};
            System.out.println("Encoding specified punctuation characters:");
            for (String charToEncode : charsToEncode) {
                String encoded = URLEncoder.encode(charToEncode, "UTF-8");
                System.out.println("Original: " + charToEncode + " Encoded: " + encoded);
            }s
            String query = "https://www.google.com/search?client=firefox-b-d&q=encoding+in+UTF8";
            String encodedQuery = URLEncoder.encode(query, "UTF-8");
            System.out.println("\nOriginal Query: " + query);
            System.out.println("Encoded Query: " + encodedQuery);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
