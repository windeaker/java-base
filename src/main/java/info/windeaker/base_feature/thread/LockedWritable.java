package info.windeaker.base_feature.thread;

import java.util.ArrayList;
import java.util.List;

public class LockedWritable {
    public static void main(String[] args) {
        List<Integer> resources=new ArrayList<>();
        synchronized (resources) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    for (int i = 0; i < 10; i++) {
                        resources.add(i);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    resources.notify();
                    System.out.println(Thread.currentThread().getName() + "已执行完");
                }
            }).start();
            try {
                resources.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("主线程执行完");
        }
    }
}
