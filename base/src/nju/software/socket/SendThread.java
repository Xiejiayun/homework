package nju.software.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Xie on 2016/1/2.
 */
public class SendThread implements Runnable{
    PrintWriter out;
    BufferedReader stdIn;

    public SendThread(BufferedReader stdIn, PrintWriter out) {
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
                    stdIn.close();
                    out.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
