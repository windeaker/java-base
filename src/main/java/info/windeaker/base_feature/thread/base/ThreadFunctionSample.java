package info.windeaker.base_feature.thread.base;

import org.junit.Test;

public class ThreadFunctionSample {

    public void yieldFunctionSample(){

    }




    @Test
    public void joinFunctionSample() {
        Thread childThread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程开始运行:"+Thread.currentThread().getName());
                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程结束运行:"+Thread.currentThread().getName());

            }
        });
        childThread.start();
        //子线程结束运行后父线程才能继续
        try {
            //
//            childThread.join();
            // 有参则表示父线程等待一定时间后，子线程如果还没结束，则父线程继续执行
            childThread.join(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("父线程线程结束运行:"+Thread.currentThread().getName());
    }

    /**
     * interrupt 方法中断正在阻塞的线程
     */
    @Test
    public void interruptFunctionSample1(){
        Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程开始运行:"+Thread.currentThread().getName());
                try {
                    Thread.sleep(60*1000);
                    System.out.println("线程结束运行:"+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    System.out.println("线程异常:"+Thread.currentThread().getName());
                    e.printStackTrace();
                }

            }
        });
        thread.start();
        try {
            Thread.sleep(20*1000);
            thread.interrupt();
            System.out.println("interrupt执行完毕");
            Thread.sleep(60*1000);
            System.out.println("父线程执行完毕");
        } catch (InterruptedException e) {
            System.out.println("线程异常:"+Thread.currentThread().getName());
            e.printStackTrace();
        }
    }

    /**
     * interrupt 方法无法中断非阻塞状态的线程
     */
    @Test
    public void interruptFunctionSample2(){
        Thread thread =new Thread(){
            @Override
            public void run() {
                System.out.println("线程开始运行:"+Thread.currentThread().getName());
                int i = 0;
                while(i<Integer.MAX_VALUE){
                    System.out.println(i+" while循环");
                    i++;
                }
                System.out.println("线程结束运行:"+Thread.currentThread().getName());
            }
        };
        thread.start();
        try {
            thread.interrupt();
            System.out.println("interrupt执行完毕");
            Thread.sleep(60*1000);
            System.out.println("父线程执行完毕");
        } catch (InterruptedException e) {
            System.out.println("线程异常:"+Thread.currentThread().getName());
            e.printStackTrace();
        }
    }

    /**
     * interrupt 方法配合isInterrupt 终端非阻塞状态的线程
     */
    @Test
    public void interruptFunctionSample3(){
        Thread thread =new Thread(){
            @Override
            public void run() {
                System.out.println("线程开始运行:"+Thread.currentThread().getName());
                int i = 0;
                while(!isInterrupted()&&i<Integer.MAX_VALUE){
                    System.out.println(i+" while循环");
                    i++;
                }
                System.out.println("线程结束运行:"+Thread.currentThread().getName());
            }
        };
        thread.start();
        try {
            Thread.sleep(1000);
            thread.interrupt();
            System.out.println("interrupt执行完毕");
            Thread.sleep(60*1000);
            System.out.println("父线程执行完毕");
        } catch (InterruptedException e) {
            System.out.println("线程异常:"+Thread.currentThread().getName());
            e.printStackTrace();
        }
    }

    @Test
    public void daemonThreadSample(){
        Runnable target;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程开始运行:"+Thread.currentThread().getName());
                    Thread.sleep(60*1000);
                    System.out.println("线程结束运行:"+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        try {
            System.out.println("线程开始运行:"+Thread.currentThread().getName());
            Thread.sleep(10*1000);
            System.out.println("线程结束运行:"+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
