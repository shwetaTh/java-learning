package LabWorks.Unit6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class DateClient {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 80;

        try {
            // Connect to the server using a socket constructor
            Socket socket = new Socket(InetAddress.getByName(serverAddress), port);

            // Set socket options
            socket.setTcpNoDelay(true);
            socket.setSoTimeout(5000); // 5 seconds timeout

            // Retrieve and display socket information
            System.out.println("Remote Address: " + socket.getInetAddress());
            System.out.println("Remote Port: " + socket.getPort());
            System.out.println("Local Address: " + socket.getLocalAddress());
            System.out.println("Local Port: " + socket.getLocalPort());
            System.out.println("TCP_NODELAY: " + socket.getTcpNoDelay());
            System.out.println("SO_TIMEOUT: " + socket.getSoTimeout());

            // Send a request for the current date and time
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("GET_DATE");
            String response = in.readLine();

            System.out.println("Server response: " + response);

            // Close socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

