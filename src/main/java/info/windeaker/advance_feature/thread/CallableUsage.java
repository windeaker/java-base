package info.windeaker.advance_feature.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableUsage {
    public static void main(String args[]) throws ExecutionException, InterruptedException {
        Callable<Integer> callable= () -> {
            int sum=0;
            for(int i=0;i<100;i++){
                sum+=i;
                Thread.sleep(100);
            }
            return sum;
        };
        FutureTask<Integer> futureTask=new FutureTask<>(callable);
        new Thread(futureTask).start();
        System.out.println("waiting for result");
        System.out.println(futureTask.get());
    }
}
