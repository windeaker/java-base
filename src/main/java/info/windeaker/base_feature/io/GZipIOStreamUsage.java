package info.windeaker.base_feature.io;

import java.util.*;

public class GZipIOStreamUsage {
    public static void main(String[] args) {
//        GZIPInputStream gzipInputStream=new GZIPInputStream();
        int times1=10000;
        Random random=new Random();
        HashSet<Integer> hashSet=new HashSet<>();
        while(hashSet.size()<1000000000){
            hashSet.add(random.nextInt());
        }
        Iterator<Integer> iterator1=new ArrayList<>(hashSet).iterator();
        Iterator<Integer> iterator2=new ArrayList<>(hashSet).iterator();
        boolean judge=false;
        long milis1=System.currentTimeMillis();
        while(iterator1.hasNext()){
            judge=((int)(iterator1.next())&1)==1;
        }
        long milis2=System.currentTimeMillis();
        System.out.println("first:"+(milis2-milis1));
        long milis3=System.currentTimeMillis();
        while(iterator2.hasNext()){
            judge=((int)(iterator2.next())%2)!=0;
        }
        long milis4=System.currentTimeMillis();
        System.out.println("next:"+(milis4-milis3));

    }
}
