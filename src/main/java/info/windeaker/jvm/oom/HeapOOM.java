package info.windeaker.jvm.oom;

public class HeapOOM {
    byte[] bytes=new byte[1024*1024*1024];
    public static void main(String[] args) {
        while (true){
            new HeapOOM();
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
