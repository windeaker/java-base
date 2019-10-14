package info.windeaker.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DebugArrayList {

    public static void doDebug() {
        ArrayList<Integer> arrayList=new ArrayList<>(1);
        arrayList.add(1);
        arrayList.remove(0);
        arrayList.clear();
    }



    public static void main(String[] args) {
        System.out.println(5>>1);
//        DebugArrayList.doDebug();
    }
}
