package info.windeaker.advance_feature.thread.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class UsageCountDownLatch {
    public static void main(String[] args) {
        System.out.println("父线程开始");
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(() -> {
            synchronized (countDownLatch) {
                System.out.println("子线程" + Thread.currentThread().getName() + "开始");
                //模拟耗时任务.
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程结束。");
                countDownLatch.countDown();
            }
        }).start();
        new Thread(() -> {
            synchronized (countDownLatch) {
                System.out.println("子线程" + Thread.currentThread().getName() + "开始");
                //模拟耗时任务.
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程结束。");
                countDownLatch.countDown();
            }
        }).start();
        //子线程不结束父线程必须等待下去
        try {
            System.out.println("还需");
            countDownLatch.await(100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("父线程即将结束");
    }

}
