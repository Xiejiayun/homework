package nju.software.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.Socket;

/**
 * Simple Client using Socket to communicate with Server
 * Created by Xie on 2015/12/21.
 */
public class SimpleClient {

    private static final String host = "127.0.0.1";
    private static final int port = 6666;
    private static Socket socket;
    public static void main(String[] args) {
        SimpleClient simpleClient = new SimpleClient();
        simpleClient.connect();
        simpleClient.sendMessage("hello netease");
    }

    //send out some message
    private void sendMessage(String message) {
        try {
            if (socket == null) {
                return;
            }
            socket.setSoTimeout(5000);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write(message);
            writer.flush();
            writer.close();
            //whenever message is sent out, close the socket
            socket.close();
        } catch (ConnectException e) {
            System.out.println("Unable to connect to the server");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //connect to the server with host and port
    private void connect() {
        try {
            socket = new Socket(host, port);
        } catch (ConnectException e) {
            System.out.println("Unable to connect to the server");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //connect to the server with specified host and port
    private void connect(String host, int port) {
        try {
            socket = new Socket(host, port);
        } catch (ConnectException e) {
            System.out.println("Unable to connect to the server");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
