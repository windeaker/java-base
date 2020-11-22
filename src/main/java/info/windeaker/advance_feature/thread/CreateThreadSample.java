package info.windeaker.advance_feature.thread;

public class CreateThreadSample {
    public static void main(String[] args) {

    }

    /**
     * 实现Runnable接口
     */
    public static class RunnableThread implements Runnable{

        @Override
        public void run() {

        }
    }

    public static class ExtendThread extends Thread{
        @Override
        public void run() {
            super.run();
        }
    }
}
