package info.windeaker.advance_feature.thread.question;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/21
 */
public class FooBar {
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    boolean toFoo = true;
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                if (!toFoo) {
                    condition1.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                toFoo = false;
                condition2.signal();
                /*
                错误的写法，
                await之后，啥事都没干，白白朗费一次循环，
                await之后，由于没有更改signal()条件，导致另一个线程处于await状态
                 */

//                // printFoo.run() outputs "foo". Do not change or remove this line.
//                if (toFoo) {
//                    printFoo.run();
//                    toFoo = false;
//                    condition2.signal();
//                } else {
//                    condition1.await();
//                }
            } finally {
                lock.unlock();
            }
        }

    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                if (toFoo) {
                    condition2.await();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                toFoo = true;
                condition1.signal();
                //错误的写法
//                if (!toFoo) {
//                    // printBar.run() outputs "bar". Do not change or remove this line.
//                    printBar.run();
//                    toFoo = true;
//                    condition1.signal();
//                } else {
//                    condition2.await();
//                }
            } finally {
                lock.unlock();
            }
        }

    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(2);
        Runnable foo = () -> System.out.println("Foo");
        Runnable bar = () -> System.out.println("Bar");
        new Thread(() -> {
            try {
                fooBar.foo(foo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "foo").start();
        new Thread(() -> {
            try {
                fooBar.bar(bar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "bar").start();
//        try {
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
