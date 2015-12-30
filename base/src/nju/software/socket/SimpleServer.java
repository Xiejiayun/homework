package nju.software.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Simple Server using Socket to communicate with Client
 * Created by Xie on 2015/12/21.
 */
public class SimpleServer {

    public static final int port = 6666;

    public static void main(String[] args) {
        SimpleServer simpleServer = new SimpleServer();
        simpleServer.listenAndAccept();
    }

    //Listen on the specific port to receive message from client
    public void listenAndAccept() {
        String message = "";
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while ((message = bufferedReader.readLine()) != null) {
                System.out.println("Received from Client: " + message);
            }
            bufferedReader.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
