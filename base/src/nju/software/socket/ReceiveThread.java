package nju.software.socket;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Receive thread to receive messages
 * Created by Xie on 2016/1/2.
 */
public class ReceiveThread implements Runnable {

    String name;
    BufferedReader in;

    public ReceiveThread(String name, BufferedReader in) {
        this.name = name;
        this.in = in;
    }

    @Override
    public void run() {
        String input;
        try {
            while (in != null && (input = in.readLine()) != null) {
                System.out.println(name + " received: " + input);
                if (input.equals("Bye")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}