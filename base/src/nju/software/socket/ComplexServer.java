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
        serverCommunicate();
    }

    private static void serverCommunicate() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out =
                    new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            BufferedReader stdIn =
                    new BufferedReader(
                            new InputStreamReader(System.in));
            Thread sendThread = new Thread(new SendThread(stdIn, out));
            Thread receiveThread = new Thread(new ReceiveThread(in));
            sendThread.start();
            receiveThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}