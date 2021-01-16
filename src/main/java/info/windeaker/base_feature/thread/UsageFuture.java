package info.windeaker.base_feature.thread;

public class UsageFuture {
    public static void main(String[] args) {
        final Object object = new Object();
        new Thread(() -> {
            synchronized (object) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
