package info.windeaker.advance_feature.thread.question;

import java.util.concurrent.CyclicBarrier;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/22
 */
public class H2O {
    private int hnum=0;
    private CyclicBarrier cyclicBarrier=new CyclicBarrier(3);
    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
    }
}
