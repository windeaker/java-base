package info.windeaker.advance_feature.thread.lock;

import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class UsageReentranLock {
    private final static ReentrantLock lock = new ReentrantLock();

    public void tryLockDemo() {
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    System.out.println(Thread.currentThread().getName() + "正在执行方法");
                    Thread.sleep(10000);
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + "获取锁失败");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void lockDemo() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "正在执行方法lockDemo");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void lockDemo2() {
        lock.lock();
        try {

            System.out.println(Thread.currentThread().getName() + "正在执行方法lockDemo2");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void lockInterruptiblyDemo() throws InterruptedException {
        lock.lockInterruptibly();
        try {

        } finally {
            lock.unlock();
        }

    }

    @Test
    public void doTest1() {
        UsageReentranLock demo = new UsageReentranLock();
        Executor executor = Executors.newFixedThreadPool(10);
        executor.execute(() -> demo.lockDemo());
        executor.execute(() -> demo.lockDemo2());
    }

    @Test
    public void doTest2() throws InterruptedException {
        UsageReentranLock demo = new UsageReentranLock();
        new Thread(() -> {
            demo.lockDemo();
        }, "Thread A").start();
        new Thread(() -> {
            demo.lockDemo2();
        }, "Thread B").start();
        Thread.sleep(4000);
    }

}