package info.windeaker.advance_feature.thread;

import java.util.concurrent.FutureTask;

public class UsageFuture {
    public static void main(String[] args) {
        final Object object = new Object();
        new Thread(() -> {
            synchronized (object) {
                System.out.println("thread-name:" + Thread.currentThread().getName());
                object.notify();
            }
        }).start();
        synchronized (object) {
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
