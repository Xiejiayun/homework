package nju.software.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * This example comes from 《Java networking programming》 4th Edition
 * Created by Xie on 2015/12/21.
 */
public class NioSocketServer {

    private static final String DEFAULT_SERVER = "localhost";
    private static final int DEFAULT_PORT = 6666;
    private byte[] data = new byte[95 * 2];

    public static void main(String[] args) {
        NioSocketServer nioSocketServer = new NioSocketServer();
        nioSocketServer.initData();
        nioSocketServer.listenAndAccept(DEFAULT_SERVER, DEFAULT_PORT);
    }

    public void initData() {
        for (byte i = ' '; i < '~'; i++) {
            data[i - ' '] = i;
            data[i + 95 - ' '] = i;
        }
    }

    public void listenAndAccept(String server, int port) {
        //create the channel and selector, then bind the channel with selection key in selector
        if (server == null)
            server = DEFAULT_SERVER;
        if (port == -1)
            port = DEFAULT_PORT;
        ServerSocketChannel serverSocketChannel;
        Selector selector;
        try {
            serverSocketChannel = ServerSocketChannel.open();
            ServerSocket serverSocket = serverSocketChannel.socket();
            InetSocketAddress address = new InetSocketAddress(port);
            serverSocket.bind(address);
            serverSocketChannel.configureBlocking(false);
            selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        //listen to the server port
        while (true) {
            try {
                selector.select();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }

            Set<SelectionKey> readyKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = readyKeys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                keyIterator.remove();
                try {
                    if (key.isAcceptable()) {
                        ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
                        SocketChannel client = serverChannel.accept();
                        System.out.println("from client " + client);
                        client.configureBlocking(false);
                        SelectionKey key2 = client.register(selector, SelectionKey.OP_WRITE);
                        ByteBuffer byteBuffer = ByteBuffer.allocate(74);
                        byteBuffer.put(data, 0, 72);
                        byteBuffer.put((byte) '\r');
                        byteBuffer.put((byte) '\n');
                        key2.attach(byteBuffer);
                    } else if (key.isWritable()) {
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
                        if (!byteBuffer.hasRemaining()) {
                            byteBuffer.rewind();
                            int first = byteBuffer.get();
                            byteBuffer.rewind();
                            int posistion = Math.abs(first - ' ' + 1);
                            System.out.println(first + " " + posistion);
                            byteBuffer.put(data, posistion, 72);
                            byteBuffer.put((byte) '\r');
                            byteBuffer.put((byte) '\n');
                            byteBuffer.flip();
                        }
                        socketChannel.write(byteBuffer);
                    }
                } catch (IOException e) {
                    System.out.printf("Exception occurs");
                    key.cancel();
                    try {
                        key.channel().close();
                    } catch (IOException cex) {

                    }
                }
            }
        }

    }

}
