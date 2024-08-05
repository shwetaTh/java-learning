package LabWorks.Unit8;

import javax.net.ssl.*;
import java.io.*;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

public class SSLClient {
    public static void main(String[] args) throws Exception {
        String serverAddress = "localhost";
        int port = 8443;

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[]{new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() { return null; }
            public void checkClientTrusted(X509Certificate[] certs, String authType) {}
            public void checkServerTrusted(X509Certificate[] certs, String authType) {}
        }}, new SecureRandom());

        SSLSocketFactory socketFactory = sslContext.getSocketFactory();
        try (SSLSocket socket = (SSLSocket) socketFactory.createSocket(serverAddress, port)) {
            socket.setEnabledProtocols(new String[]{"TLSv1.2"});
            socket.setEnabledCipherSuites(new String[]{
                    "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
                    "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384"
            });

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String response = in.readLine();
            System.out.println("Server response: " + response);
        }
    }
}
