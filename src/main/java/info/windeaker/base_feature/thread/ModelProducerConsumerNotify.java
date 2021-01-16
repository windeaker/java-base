package info.windeaker.base_feature.thread;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/21
 */
public class ModelProducerConsumerNotify {
    private int queueSize = 10;
    private Queue<Integer> queue = new ArrayDeque<>(10);

    public class Producer extends Thread {
        @Override
        public void run() {

            Random random = new Random();
            while (true) {
                synchronized (queue) {
                    while (queue.size() >= queueSize) {
                        System.out.println("队列满，等待数据被消费");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.offer(random.nextInt());
                    System.out.println("向队列添加一个元素，队列剩余" + queue.size() + "个元素");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    queue.notify();
                }
            }
        }
    }

    public class Consumer extends Thread {

        @Override
        public void run() {

            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        System.out.println("队列空，等待数据");
                        try {
                            queue.wait();
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
                    queue.notify();

                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ModelProducerConsumerNotify modelProducerConsumerNotify = new ModelProducerConsumerNotify();
        Consumer consumer = modelProducerConsumerNotify.new Consumer();
        Producer producer = modelProducerConsumerNotify.new Producer();
        consumer.start();
        producer.start();
        Thread.sleep(1000000);
    }

}
