package info.windeaker.advance_feature.thread;

public class JoinUsage {
    public static void main(String[] args) {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程开始运行:"+Thread.currentThread().getName());
                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程结束运行:"+Thread.currentThread().getName());

            }
        });
        thread.start();
        //子线程结束运行后父线程才能继续
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("父线程线程结束运行:"+Thread.currentThread().getName());
    }
}
