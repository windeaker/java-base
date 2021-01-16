package info.windeaker.base_feature.thread;

/**
 * synchronize 会将对象锁住，
 */
public class SynchronizeLockAreaUsage {

    public static void main(String[] args) {
        Resource resource=new Resource();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"开始执行"+System.currentTimeMillis());
                resource.increment();
                System.out.println(Thread.currentThread().getName()+"结束"+System.currentTimeMillis());
            }
        },"threadA").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"开始执行"+System.currentTimeMillis());
                resource.getI();
                System.out.println(Thread.currentThread().getName()+"结束"+System.currentTimeMillis());
            }
        },"threadB").start();
    }

    static class Resource{
        int i=0;

        public synchronized void increment(){
            System.out.println(Thread.currentThread().getName()+"持有锁"+System.currentTimeMillis());
            i++;
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"即将释放锁"+System.currentTimeMillis());
        }
        public synchronized int getI(){
            System.out.println(Thread.currentThread().getName()+"持有锁"+System.currentTimeMillis());
            return i;
        }

    }
}
