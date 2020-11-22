package info.windeaker.base_feature.generics;

import java.util.ArrayList;
import java.util.List;

public class B<D> implements A {
    @Override
    public <T extends String> void test(T t) {
        System.out.println(t.toString());
    }

    public <E> E getE(E e){
        System.out.println(e.getClass());
        return (E)e;
    }

    public <E> List<E> getListE(){

        return new ArrayList<E>();
    }


    public static void main(String[] args) {
       B b= new B();
       b.test("122");
       String str=(String)b.getE("6666".toString());
       List<String> strList=b.getListE();
        new A(){

            @Override
            public <T extends String> void test(T t) {

            }
        }.test("j");
        System.out.println();
        System.out.println(b instanceof A);
    }
}
