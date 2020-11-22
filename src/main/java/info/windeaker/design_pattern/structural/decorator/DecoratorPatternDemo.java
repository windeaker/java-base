package info.windeaker.design_pattern.structural.decorator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/10/30
 */
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        List list=new ArrayList<Object>();
        Collections.addAll(list,"1","2","3","4","5","7","8");
        CharSequence[] a=new CharSequence[list.size()];
        list.toArray(a);
        System.out.println(a);
    }
}
