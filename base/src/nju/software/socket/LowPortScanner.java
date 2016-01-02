package nju.software.socket;

import java.io.IOException;
import java.net.Socket;

/**
 * This example comes from 《Java networking programming》 4th Edition
 * Created by Xie on 2015/12/21.
 */
public class LowPortScanner {

    private static final String host = "localhost";

    public static void main(String[] args) {
        new LowPortScanner().scanLowPort();
    }

    public void scanLowPort() {
        for (int port = 1; port < 1024; port++) {
            try (Socket socket = new Socket(host, port)) {
                System.out.println("There exits a port on " + host + port);
                socket.close();
            } catch (IOException e) {
                System.out.println("Exception occurs on port " + port);
//                e.printStackTrace();
            }
        }
    }

}
