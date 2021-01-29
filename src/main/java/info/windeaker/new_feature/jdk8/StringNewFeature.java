package info.windeaker.new_feature.jdk8;

import org.junit.Test;

import java.util.StringJoiner;

/**
 * @author windeaker
 * @Description jdk1.8 string feature
 * @Date 2021/1/17
 */
public class StringNewFeature {

    @Test
    public void stringJoiner(){
        StringJoiner s = new StringJoiner(",");
        s.add("a");
        s.add("b");
        s.add("c");
        System.out.println(s.toString());
        s.add("d");
        System.out.println(s.toString());
    }

    @Test
    public void StringJoinFunction(){

    }
}
