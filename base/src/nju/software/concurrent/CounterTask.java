package nju.software.concurrent;

/**
 * Created by Xie on 2015/12/18.
 */
public class CounterTask implements Runnable {

    private static int count = 50;

    @Override
    public void run() {
        count--;
    }

    public static void main(String[] args) {
    }
}
