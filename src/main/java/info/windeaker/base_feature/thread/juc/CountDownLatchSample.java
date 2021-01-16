package info.windeaker.base_feature.thread.juc;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchSample {

    @Test
    public void sample1() throws InterruptedException {
        System.out.println("父线程开始");
        final CountDownLatch countDownLatch = new CountDownLatch(100);
        new Thread(()->{
            System.out.println("子线程" + Thread.currentThread().getName() + "开始");
            for (int i=0;i<100;i++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }
            System.out.println("子线程结束。");
        }).start();
        countDownLatch.await();
        System.out.println("父线程结束");
    }

    @Test
    public void sample2() throws InterruptedException {
        System.out.println("父线程开始");
        final CountDownLatch countDownLatch = new CountDownLatch(100);
        new Thread(()->{
            System.out.println("子线程" + Thread.currentThread().getName() + "开始");
            for (int i=0;i<100;i++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }
            System.out.println("子线程结束。");
        }).start();
        countDownLatch.await();
        System.out.println("父线程结束");
    }
    @Test
    public void sample3() {
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
