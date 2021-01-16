package info.windeaker.base_feature.lang;

import org.junit.Test;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/22
 */
public class OperationalSymbol {
    @Test
    public void 位运算符(){
        int a=60;
        int b=13;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));

        System.out.println(Integer.toBinaryString(a&b));
        System.out.println(Integer.toBinaryString(a|b));
        System.out.println(Integer.toBinaryString(a^b));
        System.out.println(Integer.toBinaryString(~a));
        System.out.println(Integer.toBinaryString(a<<3));
        System.out.println(Integer.toBinaryString(a>>3));
        System.out.println(Integer.toBinaryString(a>>>3));
    }

}
