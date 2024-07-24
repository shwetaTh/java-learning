package Chapter7;

import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.logging.Logger;

public class ServerSocketTest {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("request");
        try {
            /*
            ServerSocket serverSocket = new ServerSocket(13);
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            Reader reader = new InputStreamReader(inputStream);


            OutputStream outputStream = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(outputStream);
            Date date = new Date();

            int ms = (byte) date.getTime();
            outputStream.write(ms);
            writer.write(date.toString());

            int c;
            while ((c= inputStream.read())!=-1){
                writer.write((char) c);
            }
            writer.flush();
            socket.close();
            serverSocket.close();


            logger.warning("This is warning");

            logger.fine("Its good");

            ServerSocket serverSocket1 = new ServerSocket(80,50);
            InetAddress local = InetAddress.getByName("192.168.100.203");
            ServerSocket serverSocket2 = new ServerSocket(80, 10, local);
*/
            //no arg server socket
            ServerSocket serverSocket3 = new ServerSocket();
            SocketAddress socketAddress = new InetSocketAddress(80);
            serverSocket3.bind(socketAddress, 50);

            System.out.println(serverSocket3.getLocalSocketAddress());
            System.out.println(serverSocket3.getLocalPort());
            System.out.println(serverSocket3.getInetAddress());

            serverSocket3.setSoTimeout(100);
            System.out.println("timeout: "+serverSocket3.getSoTimeout());
            serverSocket3.setReuseAddress(true);
            System.out.println("reuse address: "+serverSocket3.getReuseAddress());
            serverSocket3.setReceiveBufferSize(200);
            System.out.println("Receive buffer size: "+serverSocket3.getReceiveBufferSize());

            serverSocket3.setPerformancePreferences(3,1,3);


        } catch (IOException e) {
            logger.severe("Very critical: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
