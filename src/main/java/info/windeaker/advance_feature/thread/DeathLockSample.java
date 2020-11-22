package info.windeaker.advance_feature.thread;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/16
 */
public class DeathLockSample {
    public static void main(String[] args) {

    }

    public static void syncDeathLockDemo(){
        Object resourceA=new Object();
        Object resourceB=new Object();
        new Thread(()->{
            synchronized (resourceA){
                System.out.println(Thread.currentThread().getName()+"获得A锁");
                //持锁休眠一下，让线程B能持有B锁，线程A无法持有B锁
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resourceB){
                    System.out.println(Thread.currentThread().getName()+"获得A,B锁");
                }
            }
        },"Thread A").start();
        new Thread(()->{
            synchronized (resourceB){
                System.out.println(Thread.currentThread().getName()+"获得B锁");
                //持锁休眠一下，让线程A能持有A锁，线程B无法持有A锁
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resourceA){
                    System.out.println(Thread.currentThread().getName()+"获得B,A锁");
                }
            }
        },"Thread B").start();
    }

}
