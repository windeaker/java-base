package info.windeaker.base_feature.thread.base;

import org.junit.Test;

public class ThreadLocalSample {


//   static ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();


    @Test
    public void sample1() {
        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                stringThreadLocal.set(currentThread().getName()+" threadlocal");
                System.out.println(stringThreadLocal.get());
                stringThreadLocal.remove();
                System.out.println(currentThread().getName()+" "+stringThreadLocal.get());

            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                stringThreadLocal.set(currentThread().getName()+" threadlocal");
                System.out.println(stringThreadLocal.get());
                stringThreadLocal.remove();
                System.out.println(currentThread().getName()+" "+stringThreadLocal.get());

            }
        };
        thread1.start();
        thread2.start();
    }

    @Test
    public void sample2(){
        final ThreadLocal<Object> threadLocal=new ThreadLocal<Object>(){
            @Override
            protected Object initialValue() {
                return "test";
            }
        };
        threadLocal.set("main");
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+":"+threadLocal.get() );
            threadLocal.set("object");
            System.out.println(Thread.currentThread().getName()+":"+threadLocal.get() );
        },"threada").start();
        System.out.println(Thread.currentThread().getName()+":"+threadLocal.get() );
    }
}
