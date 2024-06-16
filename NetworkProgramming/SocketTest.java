package Chapter6;

import java.io.*;
import java.net.*;

public class SocketTest {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("time.nist.gov",13);
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "ASCII");
            String dateTime="";
            int time;
            while ((time=inputStreamReader.read())!=-1){
                dateTime=dateTime+ (char) time;
            }
            System.out.println(dateTime);

            //write to socket
            OutputStream outputStream = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
            writer.write("write something");
            writer.flush();

            //Socket socket1 = new Socket(InetAddress.getByName("www.google.com"),90);

            //creating socket without address and making the address later
            Socket socket2 = new Socket();
            SocketAddress socketAddress = new InetSocketAddress("time.nist.gov", 13);
            socket2.connect(socketAddress);

            System.out.println(socket2.getRemoteSocketAddress());
            System.out.println(socket2.getLocalAddress());

            Proxy proxy = new Proxy(Proxy.Type.HTTP, socketAddress);
            Socket socket3 = new Socket(proxy);
            socket3.connect(socketAddress);
            System.out.println(socket3.getInetAddress());
            System.out.println(socket3.getLocalPort());
            System.out.println(socket3.getPort());
            System.out.println(socket3.getLocalAddress());

            if (socket3.isConnected()){
                System.out.println("Socket is connected");
            }
            socket3.close();
            if (socket3.isClosed()){
                System.out.println("Socket is closed");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
