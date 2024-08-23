package LabWorks.Unit10;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 9876;

        try (DatagramSocket clientSocket = new DatagramSocket()) {
            InetAddress IPAddress = InetAddress.getByName(serverAddress);

            Scanner scanner = new Scanner(System.in);
            byte[] sendBuffer = new byte[1024];
            byte[] receiveBuffer = new byte[1024];

            System.out.print("Enter message: ");
            String message = scanner.nextLine();
            sendBuffer = message.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, IPAddress, port);
            clientSocket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            clientSocket.receive(receivePacket);

            String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Server response: " + serverResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

