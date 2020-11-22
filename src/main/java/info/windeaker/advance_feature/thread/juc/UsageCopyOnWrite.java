package info.windeaker.advance_feature.thread.juc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/15
 */
public class UsageCopyOnWrite {
   private static List<Integer> list= new ArrayList<>();

    public static void main(String[] args) {
        useCopyOnArrayList();
    }
    public static void useList(){

        new Thread(()->{
            Collections.addAll(list,2,3,5,9,0,1,10);
            Iterator<Integer> iterator=list.iterator();
            while(iterator.hasNext()){
                try {
                    System.out.println(iterator.next());
                    Thread.sleep(1000);//模拟耗时操作
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(()->{
            for(int i=10;i<20;i++){
                try {
                    Thread.sleep(200);
                    list.add(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //多线程环境下会报ConcurrentModifiedException
    }

    private static List<Integer> cowList= new CopyOnWriteArrayList<>();
    public static void useCopyOnArrayList(){
        new Thread(()->{
            Collections.addAll(cowList,2,3,5,9,0,1,10);
            Iterator<Integer> iterator=cowList.iterator();
            while(iterator.hasNext()){
                try {
                    System.out.println(iterator.next());
                    Thread.sleep(1000);//模拟耗时操作
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(()->{
            for(int i=10;i<20;i++){
                try {
                    Thread.sleep(200);
                    cowList.add(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
