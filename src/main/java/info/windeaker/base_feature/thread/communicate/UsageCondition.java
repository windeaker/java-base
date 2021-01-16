package info.windeaker.base_feature.thread.communicate;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UsageCondition {
    Lock lock=new ReentrantLock();
    public static void main(String[] args) {

    }

    class Producer extends Thread{
        @Override
        public void run() {

        }
    }

    class Consumer extends Thread{

    }


}
