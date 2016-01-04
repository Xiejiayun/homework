package nju.software.concurrent.lock;

/**
 * Created by Xie on 2016/1/1.
 */
public class SynchronizedExample {

    public synchronized  void count() {

    }

    public static void main(String[] args) {
        synchronized (new Object()) {
        }
    }

//    public static void count() {
//        synchronized (SynchronizedExample.class) {
//        }
//    }
}
