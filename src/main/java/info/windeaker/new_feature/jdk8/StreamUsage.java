package info.windeaker.new_feature.jdk8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class StreamUsage {

    @Test
    public void filterDemo(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        strings.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("a");
            }
        }).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        strings.stream().filter(s -> s.startsWith("a")).forEach(s -> System.out.println(s));
    }


    @Test
    public void mapDemo(){
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        numbers.stream().map(new Function<Integer, Object>() {
            @Override
            public Object apply(Integer integer) {
                return integer*2;
            }
        }).forEach(s-> System.out.println(s));
    }

    @Test
    public void collectDemo(){

    }


}
