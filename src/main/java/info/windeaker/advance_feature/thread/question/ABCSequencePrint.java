package info.windeaker.advance_feature.thread.question;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 编写一个程序，开启 3 个线程，这三个线程的 ID 分别为
 * A、B、C，每个线程将自己的 ID 在屏幕上打印 10 遍，要
 * 求输出的结果必须按顺序显示。
 * 如：ABCABCABC…… 依次递归
 * @author windeaker
 * @Description TODO
 * @Date 20/8/21
 */
public class ABCSequencePrint {
    static int number=1;
    public static void main(String[] args) {
        Lock lock=new ReentrantLock();
        Condition condition1=lock.newCondition();
        Condition condition2=lock.newCondition();
        Condition condition3=lock.newCondition();
        new Thread(()->{
            for (int i = 1; i <= 20; i++) {
                lock.lock();

                try {
                    //1. 判断
                    if(number != 1){
                        condition1.await();
                    }

                    //2. 打印
//                    for (int a = 1; a <= 1; a++) {
//                        System.out.println(Thread.currentThread().getName() + "\t" + a + "\t" + i);
//                    }
                    System.out.println(Thread.currentThread().getName() + "\t" + i);
                    //3. 唤醒
                    number = 2;
                    condition2.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();
        new Thread(()->{
            for (int i = 1; i <= 20; i++) {
                lock.lock();

                try {
                    //1. 判断
                    if(number != 2){
                        condition2.await();
                    }

                    //2. 打印
//                    for (int a = 1; a <= 1; a++) {
//                        System.out.println(Thread.currentThread().getName() + "\t" + a + "\t" + i);
//                    }
                    System.out.println(Thread.currentThread().getName() + "\t" + i);


                    //3. 唤醒
                    number = 3;
                    condition3.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();
        new Thread(()->{
            for (int i = 1; i <= 20; i++) {
                lock.lock();

                try {
                    //1. 判断
                    if(number != 3){
                        condition3.await();
                    }

                    //2. 打印
//                    for (int a = 1; a <= 1; a++) {
//                        System.out.println(Thread.currentThread().getName() + "\t" + a + "\t" + i);
//                    }
                    System.out.println(Thread.currentThread().getName() + "\t" + i);
                    //3. 唤醒
                    number = 1;
                    condition1.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

                System.out.println("-----------------------------------");
            }
        }).start();
    }
}
