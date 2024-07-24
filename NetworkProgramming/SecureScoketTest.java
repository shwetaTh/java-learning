package Chapter8;

import javax.net.ServerSocketFactory;
import javax.net.SocketFactory;
import javax.net.ssl.*;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class SecureScoketTest {
    public static void main(String[] args) {
        SocketFactory socketFactory = SSLSocketFactory.getDefault();
        //ServerSocketFactory serverSocketFactory = ServerSocketFactory.getDefault();
        try {
            /*Socket socket = socketFactory.createSocket("login.ibiblio.org", 3400);
            OutputStream outputStream = socket.getOutputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            bufferedOutputStream.write(123); */

            SSLSocket sslSocket =(SSLSocket) socketFactory.createSocket();
            /*sslSocket.addHandshakeCompletedListener(new HandshakeCompletedListener() {
                @Override
                public void handshakeCompleted(HandshakeCompletedEvent handshakeCompletedEvent) {
                    System.out.println("Handshake completed");
                }
            });

            sslSocket.removeHandshakeCompletedListener(new HandshakeCompletedListener() {
                @Override
                public void handshakeCompleted(HandshakeCompletedEvent handshakeCompletedEvent) {
                    System.out.println("Handshake removed");
                }
            });

            sslSocket.setUseClientMode(true);

            InetAddress inetAddress= InetAddress.getByName("www.google.com");
            Socket socket1 = socketFactory.createSocket(inetAddress, 3400);*/

            //SSLServerSocket sslServerSocket = (SSLServerSocket) serverSocketFactory.createServerSocket(3400);
            List<String> ciphers = List.of(sslSocket.getSupportedCipherSuites());
            System.out.println(ciphers);
            sslSocket.setEnabledCipherSuites(new String[]{"TLS_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384"});
            System.out.println(List.of(sslSocket.getEnabledCipherSuites()));
            sslSocket.setEnableSessionCreation(true);
            System.out.println("Session enabled? "+ sslSocket.getEnableSessionCreation());
            sslSocket.setNeedClientAuth(true);
            System.out.println("need client auth? "+ sslSocket.getNeedClientAuth());
            sslSocket.setUseClientMode(true);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
