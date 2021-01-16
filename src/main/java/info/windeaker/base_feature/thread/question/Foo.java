package info.windeaker.base_feature.thread.question;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/21
 */
public class Foo {
    int type = 1;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            if (type!=1){
                condition1.await();
            }
            printFirst.run();
            type=2;
            condition2.signal();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            if (type!=2){
                condition2.await();
            }
            printSecond.run();
            type=3;
            condition3.signal();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            if (type!=3){
                condition3.await();
            }
            printThird.run();
            type=1;
            condition1.signal();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Foo foo=new Foo();
        Runnable one=()-> System.out.println("one");
        Runnable two=()-> System.out.println("two");
        Runnable three=()-> System.out.println("three");
        new Thread(()->{
            try {
                foo.first(one);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"one").start();
        new Thread(()->{
            try {
                foo.second(two);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"two").start();
        new Thread(()->{
            try {
                foo.third(three);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"three").start();
    }
}
