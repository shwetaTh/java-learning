package Chapter2;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlLab {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.lolcats.com/");
            URL url1 = new URL("http", "www.audubon.org", "/abc.html");
            URL url2 = new URL("http", "www.audubon.org", 81, "/abc.html");
            URL url3 = new URL(url, "/abc.html");
            System.out.println(url3);

            InputStream inputStream= url.openStream();
            int c;
            while ((c = inputStream.read())!= -1){
                //System.out.println(c);
            }
            inputStream.close();

            URLConnection urlConnection = url.openConnection();
            InputStream inputStream2= urlConnection.getInputStream();
            int d;
            while ((d = inputStream2.read())!= -1){
                //System.out.println(d);
            }

            Object o = url.getContent();
            System.out.println(o.toString());

            Class<InputStream>[] classes = new Class[3];
            classes[0]= InputStream.class;
            InputStream o1 = (InputStream) url.getContent(classes);
            System.out.println(o1);
            int e;
            while ((e = o1.read())!= -1){
                //System.out.println(e);
            }

            //URL into pieces

            URL urlPieces = new URL("http://www.ibiblio.org/javafaq/books/jnp/index.html?isbn=1565922069#toc,");
            System.out.println("Protocol: " + urlPieces.getProtocol());
            System.out.println("Host: "+urlPieces.getHost());
            System.out.println("Port: "+urlPieces.getPort());
            System.out.println("File: "+urlPieces.getFile());
            System.out.println("Ref: "+ urlPieces.getRef()); //returns fragment
            System.out.println("Query: "+urlPieces.getQuery());
            System.out.println("Path: "+urlPieces.getPath());
            System.out.println("UserInfo: "+urlPieces.getUserInfo());
            System.out.println("Authority: "+urlPieces.getAuthority());

            System.out.println(url.equals(url2));
            System.out.println(url.hashCode());
            System.out.println(url.toString());

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
