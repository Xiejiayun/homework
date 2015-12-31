package nju.software.concurrent;

/**
 * A simple example about dead lock
 * Created by Xie on 2015/12/31.
 */
public class DeadLockExample {

    private static DeadLockExample one = new DeadLockExample();

    private static DeadLockExample two = new DeadLockExample();

    public static void main(String[] args) {
        Thread first = new Thread();
        Thread second = new Thread();

    }

    public void operationOne() {
        synchronized (one) {
            System.out.println("operation one step 1 finished");
            synchronized (two) {
                System.out.println("operation one step 2 finished");
            }
        }
    }

    public void operationTwo() {
        synchronized (two) {
            System.out.println("operation two step 1 finished");
            synchronized (one) {
                System.out.println("operation two step 2 finished");
            }
        }
    }
}
