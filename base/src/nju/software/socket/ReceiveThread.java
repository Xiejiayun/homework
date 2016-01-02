package nju.software.socket;

import java.io.BufferedReader;
import java.io.IOException;

public class ReceiveThread implements Runnable {
    BufferedReader in;

    public ReceiveThread(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        String input;
        try {
            while ((input = in.readLine()) != null) {
                System.out.println(getClass().toString() + " received: " + input);
                if (input.equals("Bye")) {
                    in.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}