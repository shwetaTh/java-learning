package Chapter10;

import java.io.IOException;
import java.net.*;
import java.nio.channels.DatagramChannel;
import java.util.Date;

public class UpdServerTest {
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(13);
            DatagramPacket datagramPacket = new DatagramPacket(new byte[1024], 1024);
            datagramSocket.receive(datagramPacket);
            byte[] data = new Date().toString().getBytes();
            DatagramPacket response = new DatagramPacket(data, data.length, datagramPacket.getAddress(), datagramPacket.getPort());
            datagramSocket.send(response);

            SocketAddress socketAddress = new InetSocketAddress(InetAddress.getByName("localhost"),13);
            DatagramPacket datagramPacket1 = new DatagramPacket(data, data.length, socketAddress);
            DatagramPacket datagramPacket2 = new DatagramPacket(data, 1, data.length, socketAddress);

            //with port and interface address
            DatagramSocket datagramSocket1 = new DatagramSocket(80, InetAddress.getByName("AO01"));

            //with socket address
            SocketAddress socketAddress1 = new InetSocketAddress(90);
            DatagramSocket datagramSocket2 = new DatagramSocket(socketAddress1);
            datagramSocket2.close();

            datagramSocket2.connect(InetAddress.getByName("localhost"),80);
            System.out.println(datagramSocket2.getPort());
            System.out.println(datagramSocket2.getInetAddress());
            System.out.println(datagramSocket2.getRemoteSocketAddress());
            datagramSocket2.setSoTimeout(5000);
            datagramSocket2.getSoTimeout();
            datagramSocket2.setReceiveBufferSize(100);
            datagramSocket2.setSendBufferSize(100);
            datagramSocket2.setReuseAddress(true);
            datagramSocket2.setBroadcast(true);
            datagramSocket2.setTrafficClass(100);


            //datagramSocket2.send(new DatagramPacket());

            //receive
            datagramSocket2.disconnect();

            DatagramChannel datagramChannel = DatagramChannel.open();
            DatagramSocket datagramSocket3 = datagramChannel.socket();
            datagramSocket3.bind(new InetSocketAddress(30));

            DatagramPacket request1 = new DatagramPacket(new byte[1],
                    1,
                    InetAddress.getByName("localhost"),
                    13);
            datagramSocket3.send(request1);

            DatagramPacket response1 = new DatagramPacket(new byte[1024],
                    1024);
            datagramSocket3.receive(response1);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
