package info.windeaker.base_feature.thread;

import org.junit.Test;

/**
 * @author winde
 * @Description TODO
 * @Date 2020/12/5
 */
public class ThreadVisibleSample {
    public static boolean isOverA =false;

    public static volatile boolean isOverB=false;

    public static Boolean isOverA1 =false;

    public static volatile Boolean isOverB1=false;
    @Test
    public void sample1() throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"开始");
                while(!isOverA){

                }
                System.out.println(Thread.currentThread().getName()+"结束");
            }
        },"Thread A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"开始");
                try {
                    Thread.sleep(5*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                isOverA =true;
                System.out.println(Thread.currentThread().getName()+"结束");
            }
        },"Thread B").start();

        Thread.sleep(60*60*1000);
    }

    @Test
    public void sample2() throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"开始");
                while(!isOverB){

                }
                System.out.println(Thread.currentThread().getName()+"结束");
            }
        },"Thread A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"开始");
                try {
                    Thread.sleep(5*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                isOverB =true;
                System.out.println(Thread.currentThread().getName()+"结束");
            }
        },"Thread B").start();

        Thread.sleep(60*60*1000);
    }

    @Test
    public void sample3() throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"开始");
                while(!isOverA1){

                }
                System.out.println(Thread.currentThread().getName()+"结束");
            }
        },"Thread A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"开始");
                try {
                    Thread.sleep(5*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                isOverA1 =true;
                System.out.println(Thread.currentThread().getName()+"结束");
            }
        },"Thread B").start();

        Thread.sleep(60*60*1000);
    }

    @Test
    public void sample4() throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"开始");
                while(!isOverB1){

                }
                System.out.println(Thread.currentThread().getName()+"结束");
            }
        },"Thread A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"开始");
                try {
                    Thread.sleep(5*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                isOverB1 =true;
                System.out.println(Thread.currentThread().getName()+"结束");
            }
        },"Thread B").start();

        Thread.sleep(60*60*1000);
    }
}
