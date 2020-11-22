package info.windeaker.advance_feature.thread;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/21
 */
public class ModelProducerConsumerCondition {
    private int queueSize = 10;
    private Queue<Integer> queue = new ArrayDeque<>(10);
    Lock lock = new ReentrantLock(true);
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();

    public class Producer extends Thread {
        public Producer() {
            super();
            this.setName("Producer");
        }

        @Override
        public void run() {

            Random random = new Random();
            while (true) {
                if (lock.tryLock()) {
                    try {
                        while (queue.size() >= queueSize) {
                            System.out.println("队列满，等待数据被消费");
                            condition1.await();
                        }
                        queue.offer(random.nextInt());
                        System.out.println("向队列添加一个元素，队列剩余" + queue.size() + "个元素");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //通知线程2可以可我抢临界资源了
                        condition2.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }else{
//                    System.out.println(this.getName()+"获取锁失败");
                }
            }
        }
    }

    public class Consumer extends Thread {

        public Consumer() {
            super();
            this.setName("Consumer");
        }

        @Override
        public void run() {
            while (true) {
                if (lock.tryLock()) {
                    try {
                        while (queue.isEmpty()) {
                            System.out.println("队列空，等待数据");
                            try {
                                condition2.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("consumer:" + queue.poll());
                        System.out.println("从队列取走一个元素，队列剩余" + queue.size() + "个元素");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //通知其他资源可以和我争抢临界资源了
                        condition1.signal();

                    } finally {
                        lock.unlock();
                    }
                }else{
//                    System.out.println(this.getName()+"获取锁失败");
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ModelProducerConsumerCondition modelProducerConsumerCondition = new ModelProducerConsumerCondition();
        Consumer consumer = modelProducerConsumerCondition.new Consumer();
        Producer producer = modelProducerConsumerCondition.new Producer();
        consumer.start();
        producer.start();
        Thread.sleep(1000000);
    }
}
