package info.windeaker.base_feature.thread.communicate;

public class TransferDataBetweenDifferentThreadByPipeStream {
    public static void main(String[] args) {
//        noLockWaitException();
//        noLockNotifyException();
        System.out.println(2<<11);
    }


    public static void noLockWaitException() {
        String str = new String();
        try {
            str.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void noLockNotifyException() {
        String str = new String();
        str.notify();
    }
}
