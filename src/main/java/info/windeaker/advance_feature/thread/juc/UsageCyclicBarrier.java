package info.windeaker.advance_feature.thread.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/10
 */
public class UsageCyclicBarrier {
    public static void main(String[] args) {
        testa();
    }

    public static void testa(){
        final CyclicBarrier barrier=new CyclicBarrier(5,()-> System.out.println("所有线程执行完成后再执行后续任务"+Thread.currentThread().getName()));
        barrier.reset();
        barrier.reset();
        for (int i=0;i<5;i++){
            new Thread(()->{
                System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据...");
                try {
                    Thread.sleep(5000);      //以睡眠来模拟写入数据操作
                    System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }catch(BrokenBarrierException e){
                    e.printStackTrace();
                }
                System.out.println("所有线程写入完毕，继续处理其他任务...");
            }).start();
        }

        System.out.println("主线程即将结束");
    }
}
