package info.windeaker.base_feature.thread.juc;

import org.junit.Test;

import java.util.concurrent.Semaphore;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/10
 */
public class UsageSemaphore {

    @Test
    public void simpleTest2() throws InterruptedException {
        //最多5个线程并发
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
