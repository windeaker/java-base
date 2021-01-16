package info.windeaker.base_feature.thread.communicate;

import java.util.ArrayList;
import java.util.List;

public class NoWaitNotifyDemo {

    public static void main(String[] args) {
        Resource resource=new Resource();
        Thread threadA=new Thread(new Runnable() {
            @Override
            public void run() {
//                System.out.println("线程A开始");
                while (resource.getSize()<10){
                    resource.add(1);
//                    System.out.println("线程 A size:"+resource.getSize());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程A结束");
            }
        });
        Thread threadB=new Thread(new Runnable() {
            @Override
            public void run() {
//                System.out.println("线程B开始");
                while (true){
                    int size=resource.getSize();
//                    System.out.println("线程 B size:"+resource.getSize());
                    if (size==5){
                        System.out.println("线程B即将退出");
                        break;
                    }else{
//                        System.out.println("线程 B size:"+size);
                    }
                }
            }
        });

        threadA.start();
        threadB.start();
    }

    static class Resource{
        private List<Integer> integerList=new ArrayList<>();

        public void add(Integer i){
            integerList.add(i);
        }

        public int getSize(){
            return integerList.size();
        }
    }
}
