package info.windeaker.base_feature.lang;

import java.nio.charset.StandardCharsets;

public class DebugString {
    public static void main(String[] args) {
        new String().getBytes();
        System.out.println("jahhah".getBytes(StandardCharsets.ISO_8859_1).length);
    }
}
