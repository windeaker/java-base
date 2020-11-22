package info.windeaker.new_feature.jdk8.lamda;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/5
 */
//@FunctionalInterface 标注的接口有且只能有一个方法
@FunctionalInterface
public interface NoReturnMultiParam {
    void method(int a, int b);
}
