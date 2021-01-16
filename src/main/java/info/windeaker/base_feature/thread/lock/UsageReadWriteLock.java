package info.windeaker.base_feature.thread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class UsageReadWriteLock {

    public static void main(String[] args) {
//        readShareRead();
//        readExclusiveWrite();
//        writeExclusiveWrite();
        writeExclusiveRead();
    }

    public static void readShareRead(){
        Runner runner=new Runner();
        Thread theadA=new Thread(new Runnable() {
            @Override
            public void run() {
                runner.read();
            }
        });
        theadA.setName("a");
        Thread theadB=new Thread(new Runnable() {
            @Override
            public void run() {
                runner.read();
            }
        });
        theadB.setName("b");
        theadA.start();
        theadB.start();
    }

    public static void readExclusiveWrite(){
        Runner runner=new Runner();
        Thread theadA=new Thread(new Runnable() {
            @Override
            public void run() {
                runner.read();
            }
        });
        theadA.setName("a");
        Thread theadB=new Thread(new Runnable() {
            @Override
            public void run() {
                runner.write();
            }
        });
        theadB.setName("b");
        theadA.start();
        theadB.start();
    }

    public static void writeExclusiveWrite(){
        Runner runner=new Runner();
        Thread theadA=new Thread(new Runnable() {
            @Override
            public void run() {
                runner.write();
            }
        });
        theadA.setName("a");
        Thread theadB=new Thread(new Runnable() {
            @Override
            public void run() {
                runner.read();
            }
        });
        theadB.setName("b");
        theadA.start();
        theadB.start();
    }

    public static void writeExclusiveRead(){
        Runner runner=new Runner();
        Thread theadA=new Thread(new Runnable() {
            @Override
            public void run() {
                runner.read();
            }
        });
        theadA.setName("a");
        theadA.start();
        Thread theadB=new Thread(new Runnable() {
            @Override
            public void run() {
                runner.write();
            }
        });
        theadB.setName("b");
        theadB.start();
    }


    static class Runner{
        private ReentrantReadWriteLock lock=new ReentrantReadWriteLock();

        public void write(){
            try {
                try {
                    lock.writeLock().lock();
                    System.out.println("获得写锁" + Thread.currentThread().getName() + "  " + System.currentTimeMillis());
                    Thread.sleep(30000);
                } finally {
                    lock.writeLock().unlock();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        public void read(){
            try {
                try {
                    lock.readLock().lock();
                    System.out.println("获得读锁" + Thread.currentThread().getName() + "  " + System.currentTimeMillis());
                    Thread.sleep(30000);
                } finally {
                    lock.readLock().unlock();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
