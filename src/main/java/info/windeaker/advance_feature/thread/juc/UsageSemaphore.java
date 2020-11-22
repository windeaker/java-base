package info.windeaker.advance_feature.thread.juc;

import org.junit.Test;

import java.util.concurrent.Semaphore;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/10
 */
public class UsageSemaphore {
    public static void main(String[] args) {

    }

    @Test
    public void simpleTest() throws InterruptedException {
        Semaphore semaphore=new Semaphore(0);
        new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"release");
            semaphore.release();
        }).start();
        new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"release");
            semaphore.release();
        }).start();
        semaphore.acquire(2);
    }

    @Test
    public void simpleTest2() throws InterruptedException {
        final Semaphore semaphore=new Semaphore(5);
        for(int i=0;i<10;i++){
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println("工人"+Thread.currentThread().getName()+"占用一个机器在生产...");
                    Thread.sleep(2000);
                    System.out.println("工人"+Thread.currentThread().getName()+"释放出机器");
                    semaphore.release();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
        Thread.sleep(20000);
    }
}
