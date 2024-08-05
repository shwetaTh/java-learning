package LabWorks.Unit8;

import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

//write this in terminal before running program
//keytool -genkeypair -alias serverkey -keyalg RSA -keysize 2048 -keystore keystore.jks -validity 365

public class SSLServer {
    public static void main(String[] args) throws Exception {
        int port = 8443;

        // Load keystore
        KeyStore keyStore = KeyStore.getInstance("JKS");
        InputStream keyStoreInput = new FileInputStream("keystore.jks"); // Adjust path
        keyStore.load(keyStoreInput, "shweta".toCharArray()); // Adjust password here

        // Initialize SSL context
        SSLContext sslContext = SSLContext.getInstance("TLS");
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, "shweta".toCharArray()); // Adjust password
        sslContext.init(keyManagerFactory.getKeyManagers(), new TrustManager[]{new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() { return null; }
            public void checkClientTrusted(X509Certificate[] certs, String authType) {}
            public void checkServerTrusted(X509Certificate[] certs, String authType) {}
        }}, new SecureRandom());

        SSLServerSocketFactory serverSocketFactory = sslContext.getServerSocketFactory();
        SSLServerSocket serverSocket = (SSLServerSocket) serverSocketFactory.createServerSocket(port);

        // Set enabled protocols and cipher suites
        serverSocket.setEnabledProtocols(new String[]{"TLSv1.2"});
        serverSocket.setEnabledCipherSuites(new String[]{
                "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
                "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384"
        });

        System.out.println("SSL server started on port " + port);

        while (true) {
            try (SSLSocket clientSocket = (SSLSocket) serverSocket.accept()) {
                System.out.println("Client connected");

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                out.println("Current Date and Time: " + new java.util.Date().toString());
            }
        }
    }
}
