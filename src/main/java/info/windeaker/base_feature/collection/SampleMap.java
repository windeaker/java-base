package info.windeaker.base_feature.collection;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class SampleMap {
    public static void main(String[] args) {
        new HashMap<String,String>();
    }

    @Test
    public void linkedHashMapDemo(){
        LinkedHashMap linkedHashMap=new LinkedHashMap<>();
        linkedHashMap.put(1,"a");
        linkedHashMap.put(2,"b");
        linkedHashMap.put(3,"c");
        linkedHashMap.put(4,"d");
    }

    @Test
    public void hashSample(){
        Object object=new Object();
        System.out.println(hashDemo(object));
        System.out.println(hash(object));
        System.out.println(15&hash(object));
    }

    static final int hashDemo(Object key){
        if (key==null){
            return 0;
        }else{
            int h=key.hashCode();
            int a=h>>>16;
            int result=h^a;
            return result;
        }
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
