package LabWorks.Unit3;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Lab3 {
    public static void main(String[] args) {
        try {

            //URL into pieces

            URL urlPieces = new URL("http://www.ibiblio.org/javafaq/books/jnp/index.html?isbn=1565922069#toc,");
            System.out.println("Protocol: " + urlPieces.getProtocol());
            System.out.println("Host: " + urlPieces.getHost());
            System.out.println("Port: " + urlPieces.getPort());
            System.out.println("File: " + urlPieces.getFile());
            System.out.println("Ref: " + urlPieces.getRef()); //returns fragment
            System.out.println("Query: " + urlPieces.getQuery());
            System.out.println("Path: " + urlPieces.getPath());
            System.out.println("UserInfo: " + urlPieces.getUserInfo());
            System.out.println("Authority: " + urlPieces.getAuthority());

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
