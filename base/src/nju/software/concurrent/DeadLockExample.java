package nju.software.concurrent;

/**
 * A simple dead lock example using two synchronized  objects
 * Created by Xie on 2015/12/31.
 */
public class DeadLockExample {

    private static DeadLockExample one = new DeadLockExample();
    private static DeadLockExample two = new DeadLockExample();

    public static void main(String[] args) {
        deadlock();

    }

    private static void deadlock() {
        Thread first = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (one) {
                    System.out.println("operation one step 1 finished");
                    synchronized (two) {
                        System.out.println("operation one step 2 finished");
                    }
                }
            }
        });
        Thread second = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (two) {
                    System.out.println("operation two step 1 finished");
                    synchronized (one) {
                        System.out.println("operation two step 2 finished");
                    }
                }
            }
        });

        first.start();
        second.start();
    }

}
