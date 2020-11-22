package info.windeaker.advance_feature.thread;

public class UsageThreadLocal {

    public static boolean ready=false;

    public static int num=0;

    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }

    public static void test() throws InterruptedException {
        ReadThread readThread=new ReadThread();
        readThread.start();
        WriteThread writeThread=new WriteThread();
        writeThread.start();
        Thread.sleep(10);
        readThread.interrupt();
        System.out.println("main exit");
    }

    public static class ReadThread extends Thread{
        @Override
        public void run() {
            while(!Thread.currentThread().isInterrupted()){
                if (ready){
                    System.out.println(num+num);
                }
                System.out.println("read thread ....");
            }
        }
    }

    public static class WriteThread extends Thread{
        @Override
        public void run() {
            num=2;
            ready=true;
            System.out.println("writeThread set over ...");
        }
    }
}
