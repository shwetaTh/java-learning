package LabWorks.Unit7;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {
    public static void main(String[] args) {
        int port = 80;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            // Set server socket options
            serverSocket.setSoTimeout(0); // 0 means infinite timeout
            serverSocket.setReuseAddress(true);

            System.out.println("Server is listening on port " + port);

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("New client connected");

                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    String clientRequest = in.readLine();

                    if ("GET_BINARY".equals(clientRequest)) {
                        // Serve binary data (e.g., an image file)
                        File file = new File("path/to/binary/file"); // replace with actual binary file path
                        if (file.exists() && file.isFile()) {
                            try (OutputStream outputStream = socket.getOutputStream();
                                 FileInputStream fileInputStream = new FileInputStream(file)) {

                                byte[] buffer = new byte[4096];
                                int bytesRead;
                                while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                                    outputStream.write(buffer, 0, bytesRead);
                                }
                                outputStream.flush();
                            }
                        } else {
                            out.println("Binary file not found or is not a file.");
                        }
                    } else if ("GET_DATE".equals(clientRequest)) {
                        // Respond with the current date and time
                        out.println("Current Date and Time: " + new Date().toString());
                    } else {
                        out.println("Unknown request.");
                    }

                } catch (IOException e) {
                    System.out.println("Exception in client handling: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
