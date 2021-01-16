package info.windeaker.base_feature.thread.base;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CreateThreadSample {

    /**
     * 实现runnable创建线程
     */
    @Test
    public void createThreadByImplementRunnable() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(10000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println(Thread.currentThread().getName());
    }

    @Test
    public void createThreadByExtendThread() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(10000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        System.out.println(thread.getClass().getName());
        System.out.println(Thread.currentThread().getName());
    }

    @Test
    public void createThreadByFutureTask() throws ExecutionException, InterruptedException {
        Callable<Integer> callable = () -> {
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += i;
                Thread.sleep(100);
            }
            return sum;
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
        System.out.println("waiting for result");
        System.out.println(futureTask.get());
    }

}
