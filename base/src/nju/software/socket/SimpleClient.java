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

    public static void main(String[] args) {
        SimpleClient simpleClient = new SimpleClient();
        simpleClient.sendMessage("hello netease");
    }

    //send out some message
    private void sendMessage(String message) {
        try (Socket socket = new Socket(host, port)){
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
}
