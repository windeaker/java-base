package info.windeaker.base_feature.thread.juc;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/10
 */
public class UsageCyclicBarrier {


    @Test
    public void sample1(){
        int threadNum=5;
        final CyclicBarrier cyclicBarrier=new CyclicBarrier(threadNum);
        for(int i=0;i<5;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程"+Thread.currentThread().getName()+"开始");
                    try {
                        Thread.sleep(5*1000);
                        //以睡眠来模拟写入数据操作
                        System.out.println("线程"+Thread.currentThread().getName()+"休眠完毕,开始等待其他线程");
                        cyclicBarrier.await();
                        System.out.println("线程"+Thread.currentThread().getName()+"等待完成，开始继续自己的操作");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }catch(BrokenBarrierException e){
                        e.printStackTrace();
                    }
                    System.out.println("线程"+Thread.currentThread().getName()+"结束");
                }
            },"thread-"+i).start();
        }

        try {
            // 防止父线程提前结束
            Thread.sleep(20 * 1000);
            System.out.println("主线程结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sample2(){
        int threadNum=6;
        final CyclicBarrier cyclicBarrier=new CyclicBarrier(threadNum);
        for(int i=0;i<5;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程"+Thread.currentThread().getName()+"开始");
                    try {
                        Thread.sleep(5*1000);
                        //以睡眠来模拟写入数据操作
                        System.out.println("线程"+Thread.currentThread().getName()+"休眠完毕,开始等待其他线程");
                        cyclicBarrier.await();
                        System.out.println("线程"+Thread.currentThread().getName()+"等待完成，开始继续自己的操作");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }catch(BrokenBarrierException e){
                        e.printStackTrace();
                    }
                    System.out.println("线程"+Thread.currentThread().getName()+"结束");
                }
            },"thread-"+i).start();
        }

        try {
            Thread.sleep(20 * 1000);
            cyclicBarrier.await();
            System.out.println("线程"+Thread.currentThread().getName()+"等待完成，开始继续自己的操作");
            Thread.sleep(20 * 1000);
            System.out.println("主线程结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sample3(){
        int threadNum=5;
        final CyclicBarrier cyclicBarrier=new CyclicBarrier(threadNum, new Runnable() {
            @Override
            public void run() {
                System.out.println("所有线程执行完成后再执行后续任务"+Thread.currentThread().getName());
            }
        });
        for(int i=0;i<5;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程"+Thread.currentThread().getName()+"开始");
                    try {
                        Thread.sleep(5*1000);
                        //以睡眠来模拟写入数据操作
                        System.out.println("线程"+Thread.currentThread().getName()+"休眠完毕,开始等待其他线程");
                        cyclicBarrier.await();
                        System.out.println("线程"+Thread.currentThread().getName()+"等待完成，开始继续自己的操作");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }catch(BrokenBarrierException e){
                        e.printStackTrace();
                    }
                    System.out.println("线程"+Thread.currentThread().getName()+"结束");
                }
            },"thread-"+i).start();
        }

        try {
            // 防止父线程提前结束
            Thread.sleep(20*1000);
            System.out.println("主线程结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
