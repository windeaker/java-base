package info.windeaker.advance_feature.thread;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/16
 */
public class SampleThreadLocal {
    public static void main(String[] args) {

    }
    static void threadLocalDemo(){
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
