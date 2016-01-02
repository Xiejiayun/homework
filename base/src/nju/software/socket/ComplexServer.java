package nju.software.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Xie on 2016/1/2.
 */
public class ComplexServer {

    public static final int port = 6666;

    public static void main(String[] args) {
        ComplexServer complexServer = new ComplexServer();
        complexServer.serverCommunicate();
    }

    private void serverCommunicate() {
        try {
            ServerSocket server = new ServerSocket(port);
            Socket client = server.accept();
            PrintWriter out =
                    new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            BufferedReader stdIn = new BufferedReader(
                    new InputStreamReader(System.in));
            Thread sendThread = new Thread(new SendThread(getClass().toString(), stdIn, out));
            Thread receiveThread = new Thread(new ReceiveThread(getClass().toString(), in));
            sendThread.start();
            receiveThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}