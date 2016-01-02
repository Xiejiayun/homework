package nju.software.nio;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

/**
 * This example comes from 《Java networking programming》 4th Edition
 * Created by Xie on 2015/12/21.
 */
public class NioSocketClient {

    private static final String DEFAULT_SERVER = "localhost";
    private static final int DEFAULT_PORT = 6666;

    public static void main(String[] args) {
        new NioSocketClient().sendMessage(null, -1);
    }

    public void sendMessage(String server, int port) {
        if (server == null)
            server = DEFAULT_SERVER;
        if (port == -1)
            port = DEFAULT_PORT;
        try {
            SocketAddress socketAddress = new InetSocketAddress(server, port);
            SocketChannel socketChannel = SocketChannel.open(socketAddress);

            ByteBuffer byteBuffer = ByteBuffer.allocate(74);
            WritableByteChannel writableByteChannel = Channels.newChannel(System.out);

            while (socketChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                writableByteChannel.write(byteBuffer);
                byteBuffer.clear();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
