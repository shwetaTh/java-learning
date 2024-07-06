package LabWorks.Unit4;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.List;

public class Lab1 {
    public static void main(String[] args) {
        try {
            // Create a CookieManager with default CookieStore and CookiePolicy
            CookieManager cookieManager = new CookieManager();
            cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);

            // Access the underlying CookieStore
            CookieStore cookieStore = cookieManager.getCookieStore();

            // URI for which cookies are added
            URI uri = new URI("http://example.com");

            // Add cookies
            HttpCookie cookie1 = new HttpCookie("name", "Shweta");
            HttpCookie cookie2 = new HttpCookie("lastname", "Thapa");
            cookieStore.add(uri, cookie1);
            cookieStore.add(uri, cookie2);
            System.out.println("Added cookies:");

            // Get cookies
            List<HttpCookie> cookies = cookieStore.get(uri);
            for (HttpCookie cookie : cookies) {
                System.out.println(cookie);
            }

            // Remove a specific cookie
            System.out.println("\nRemoving 'name' cookie:");
            cookieStore.remove(uri, cookie1);

            // Get cookies again after removal
            cookies = cookieStore.get(uri);
            for (HttpCookie cookie : cookies) {
                System.out.println(cookie);
            }

            // Remove all cookies
            System.out.println("\nRemoving all cookies:");
            cookieStore.removeAll();

            // Get cookies again after removing all
            cookies = cookieStore.get(uri);
            System.out.println("Cookies after removing all:");
            for (HttpCookie cookie : cookies) {
                System.out.println(cookie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

