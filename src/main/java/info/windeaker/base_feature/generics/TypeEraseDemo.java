package info.windeaker.base_feature.generics;

import java.util.ArrayList;

/**
 * Java 的泛型使用了类型擦除机制，类型擦除即，类型参数只存在于编译期，在运行时，Java 的虚拟机 ( JVM ) 并不知道泛型的存在。
 */
public class TypeEraseDemo<T> {

    public static void main(String[] args) {
        Class a=new ArrayList<String>().getClass();
        Class b=new ArrayList<Integer>().getClass();
        System.out.println(a==b);
        //output：true
    }
}


