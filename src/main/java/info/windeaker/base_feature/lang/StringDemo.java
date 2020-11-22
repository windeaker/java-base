package info.windeaker.base_feature.lang;

import java.nio.charset.StandardCharsets;

public class StringDemo {
    public static void main(String[] args) {
        String a="  是 否tr im了 么？ ";
        System.out.println(new String(a.getBytes(), StandardCharsets.UTF_8));
        String b="for english service press eight!  ";
        System.out.println(new String(b.getBytes(), StandardCharsets.UTF_8));
        byte[] c="    ".getBytes();
        for(byte temp:c){
            System.out.print(temp);
        }
        System.out.println();
    }
}
