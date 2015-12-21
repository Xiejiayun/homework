package nju.software.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Created by Xie on 2015/12/21.
 */
public class SimpleClient {

    private static final String host = "127.0.0.1";
    private static final int port = 6666;

    public static void main(String[] args) {
        SimpleClient simpleClient = new SimpleClient();
        simpleClient.sendMessage("hello netease");
    }

    public void sendMessage(String message) {
        try {
            Socket socket = new Socket(host, port);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write(message);
            writer.flush();
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
