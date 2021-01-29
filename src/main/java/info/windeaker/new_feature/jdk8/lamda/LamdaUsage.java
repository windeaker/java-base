package info.windeaker.new_feature.jdk8.lamda;


/**
 * @author windeaker
 * @description lamda表达式用法
 */
public class LamdaUsage {
    public static void main(String[] args) {
        NoReturnMultiParam noReturnMultiParam=(int a,int b)->{
            System.out.println("a:"+a+"  b:"+b);
        };
        noReturnMultiParam.method(1,2);
        NoReturnOneParam noReturnOneParam=(int a)->{
            System.out.println("NoReturnOneParam:"+a);
        };
    }
}
