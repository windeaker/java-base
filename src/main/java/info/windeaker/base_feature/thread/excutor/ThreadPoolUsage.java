package info.windeaker.base_feature.thread.excutor;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

public class ThreadPoolUsage {
    public static void main(String[] args) {
//        executorService();
        singleThreadPool();
    }

    @Test
    public void executorService(){
        ThreadPoolExecutor executor=new ThreadPoolExecutor(1,1,60,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(100));
        System.out.println(executor.isShutdown());
        System.out.println(executor.isTerminating());
        System.out.println(executor.isTerminated());
        executor.shutdown();
    }

    public static void singleThreadPool() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        Future<Integer> future= executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum=0;
                for (int i=0;i<=100;i++){
                    sum+=i;
                }
                return sum;
            }
        });


        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(future.getClass());
        System.out.println(executor.isShutdown());
        executor.shutdown();
    }

    public static void fixedThreadPool() {
        Executors.newFixedThreadPool(10);
    }

    public static void cachedThreadPool() {
        Executors.newCachedThreadPool();
    }

    public static void workStealingPool() {
        Executors.newWorkStealingPool();
    }

    public static void singleThreadScheduledExecutor() {
        Executors.newSingleThreadScheduledExecutor();
    }

    public static void sheduledThreadPool() throws ExecutionException, InterruptedException {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            Future<Integer> result = pool.schedule(new Callable<Integer>() {

                @Override
                public Integer call() throws Exception {
                    int num = new Random().nextInt(100);//生成随机数
                    System.out.println(Thread.currentThread().getName() + " : " + num);
                    return num;
                }

            }, 1, TimeUnit.SECONDS);

            System.out.println(result.get());
        }

        pool.shutdown();
    }
}
