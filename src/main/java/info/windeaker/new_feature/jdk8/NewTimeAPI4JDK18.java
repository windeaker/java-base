package info.windeaker.new_feature.jdk8;

import java.time.Instant;

/**
 * jdk1.8 引入的新的时间api
 * @since jdk1.8
 */
public class NewTimeAPI4JDK18 {
    public static void main(String[] args) {
        instant();
    }

    public static void instant(){
        Instant instant=Instant.now();
        System.out.println(instant.toString());

        instant=Instant.ofEpochMilli(2000000);
        System.out.println(instant.toString());

        instant=Instant.ofEpochSecond(20);
        System.out.println(instant.toString());


    }
}
