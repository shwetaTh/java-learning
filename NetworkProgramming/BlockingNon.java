package Chapter9;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.IntBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

public class BlockingNon {
    public static void main(String[] args) {
        SocketAddress socketAddress = new InetSocketAddress("www.example.com", 19);
        try {
            /*
            //read write using nonblocking I/O for client
            SocketChannel socketChannel = SocketChannel.open(socketAddress);
            ByteBuffer byteBuffer = ByteBuffer.allocate(74);
            int socketRead= socketChannel.read(byteBuffer);
            WritableByteChannel output = Channels.newChannel(System.out);
            byteBuffer.flip();
            output.write(byteBuffer);
            byteBuffer.clear();

            //position of the buffer
            System.out.println(byteBuffer.position());
            byteBuffer.position(25);

            //capacity
            System.out.println(byteBuffer.capacity());

            //limit
            byteBuffer.limit(50);
            System.out.println(byteBuffer.limit());

            //mark
            System.out.println(byteBuffer.mark());

            //read write for server
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            ServerSocket ss = serverSocketChannel.socket();
            ss.bind(new InetSocketAddress(19));
            socketChannel=serverSocketChannel.accept();
            //for non blocking we make it false
            socketChannel.configureBlocking(false);
            */

            CharBuffer charBuffer = CharBuffer.allocate(10);
            charBuffer.put('a');
            charBuffer.put('b');
            charBuffer.flip();
            // charBuffer.put('c'); replaces the 0 index due to flip
            System.out.println(charBuffer.position());
            System.out.println(charBuffer.get(charBuffer.position())); //returns null
            System.out.println(charBuffer.get(0)); //returns null

            byte[] bytes = "Some array string".getBytes();
            ByteBuffer byteBuffer = ByteBuffer.allocate(100);
            byteBuffer.put(bytes, 0, 10);
            byte[] newBytes = new byte[50];
            byteBuffer.get(newBytes, 0, 10);
            System.out.println(newBytes[0]);

            System.out.println(byteBuffer.getChar(0));
            byteBuffer.putChar( 10,'a');
            System.out.println(byteBuffer.getChar(10));

            //view as
            CharBuffer charBuffer1 = byteBuffer.asCharBuffer();
            IntBuffer intBuffer = byteBuffer.asIntBuffer();

            //DoubleBuffer doubleBuffer = byteBuffer.asDoubleBuffer();
            DoubleBuffer doubleBuffer = DoubleBuffer.allocate(10);
            doubleBuffer.put(10);

            DoubleBuffer doubleBuffer1 = doubleBuffer.duplicate();
            System.out.println("Double Buffer Data: "+doubleBuffer1.get(0));
            System.out.println("hashcode of original: "+ doubleBuffer.hashCode());
            System.out.println("hashcode of duplicate: "+ doubleBuffer1.hashCode());
            System.out.println(doubleBuffer1.toString());

            System.out.println("Buffer equal: "+doubleBuffer.equals(doubleBuffer1));

            doubleBuffer.put(20);
            doubleBuffer.put(30);
            doubleBuffer.put(40);
            doubleBuffer.put(50);
            doubleBuffer.put(60);
            doubleBuffer.put(70);
            //System.out.println("hashcode of original: "+ doubleBuffer.hashCode());
            doubleBuffer.position(4);
            DoubleBuffer slicedDoubleBuffer = doubleBuffer.slice();
            System.out.println(slicedDoubleBuffer.get(0));
            System.out.println(slicedDoubleBuffer.get(1));
            System.out.println(slicedDoubleBuffer.get(2));
            System.out.println(slicedDoubleBuffer.get(3));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
