package info.windeaker.base_feature.thread.juc;

import java.util.concurrent.atomic.AtomicInteger;

public class UsageAtomic {

    public static void main(String[] args) {

    }

    public static void AtomicIntegerUsage(){
        AtomicInteger atomicInteger=new AtomicInteger();
        new Thread(()->{

        },"Thread A").start();
        new Thread(()->{

        },"Thread B").start();
    }
}
