package nju.software.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * A complex client using two threads to send and receive messages
 * Created by Xie on 2016/1/2.
 */
public class ComplexClient {

    private static final String host = "127.0.0.1";
    private static final int port = 6666;

    public static void main(String[] args) {
        ComplexClient complexClient = new ComplexClient();
        complexClient.clientCommunicate();
    }

    private void clientCommunicate() {
        try {
            Socket client = new Socket(host, port);
            PrintWriter out =
                    new PrintWriter(client.getOutputStream(), true);
            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(client.getInputStream()));
            BufferedReader stdIn =
                    new BufferedReader(
                            new InputStreamReader(System.in));
            Thread sendThread = new Thread(new SendThread(getClass().toString(), stdIn, out));
            Thread receiveThread = new Thread(new ReceiveThread(getClass().toString(), in));
            sendThread.start();
            receiveThread.start();
        } catch (UnknownHostException e) {
            System.out.println("Unable to connect to the specific host, application terminated!");
            e.printStackTrace();
        } catch (ConnectException e) {
            System.out.println("Unable to connect to the server, application terminated!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

