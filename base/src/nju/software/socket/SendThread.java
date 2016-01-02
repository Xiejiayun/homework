package nju.software.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Xie on 2016/1/2.
 */
public class SendThread implements Runnable{
    String name;
    PrintWriter out;
    BufferedReader stdIn;

    public SendThread(String name, BufferedReader stdIn, PrintWriter out) {
        this.name = name;
        this.stdIn = stdIn;
        this.out = out;
    }

    @Override
    public void run() {
        String output;
        try {
            while ((output = stdIn.readLine()) != null) {
                out.println(output);
                if (output.equals("Bye")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
